package controllers

import models.Post
import play.api.mvc.{Action, Controller}

/**
 * Created by mbayly on 29/04/2015.
 */
object Posts extends Controller {

  def list = Action {implicit request =>
    val posts = Post.findAll

    Ok(views.html.posts.list(posts))
  }
}
