package controllers

import models.Post
import play.api.mvc.{Action, Controller}
import play.api.data.Form
import play.api.data.Forms.{text, mapping, number, nonEmptyText}
import play.api.i18n.Messages
import play.api.mvc.Flash

import views.html.helper.form

/**
 * Created by mbayly on 29/04/2015.
 */
object Posts extends Controller {

  def list = Action {implicit request =>
    val posts = Post.findAll

    Ok(views.html.posts.list(posts))
  }

  def show(id: Int) = Action { implicit request =>
    Post.findById(id).map { post =>
      Ok(views.html.posts.details(post))
    }.getOrElse(NotFound)
  }

  def newPost = Action { implicit request =>

    val form = if (request.flash.get("error").isDefined)
      postForm.bind(request.flash.data)
    else
      postForm

    Ok(views.html.posts.editPost(form))
  }

  def save = Action { implicit request =>
    val newPostForm = postForm.bindFromRequest()

    newPostForm.fold (
      hasErrors = { form =>
        Redirect(routes.Posts.newPost()).
          flashing(Flash(form.data) +
            ("error" -> Messages("validation.errors")))
      },

      success = { newPost =>
        Post.add(newPost)
        val message = Messages("posts.new.success", newPost.name)
        Redirect(routes.Posts.show(newPost.id)).
          flashing("success" -> message)
      }
    )
  }

  private val postForm: Form[Post] = Form(
    mapping(
      "id" -> number.verifying("validation.id.duplicate", Post.findById(_).isEmpty),
      "author" -> nonEmptyText,
      "name" -> nonEmptyText,
      "image1" -> text,
      "image2" -> text
    )(Post.apply)(Post.unapply)
  )
}
