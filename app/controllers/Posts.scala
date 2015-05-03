package controllers

import models.Post
import play.api.mvc.{Action, Controller}
import play.api.data.Form
import play.api.data.Forms.{text, mapping, number, nonEmptyText}
import play.api.i18n.Messages

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

  private val postForm: Form[Post] = Form(
    mapping(
      "id" -> number,
      "author" -> nonEmptyText,
      "name" -> nonEmptyText,
      "image1" -> text,
      "image2" -> text
    )(Post.apply)(Post.unapply)
  )
}
