package models

/**
 * Created by mbayly on 29/04/2015.
 */
case class Post(id: Int, author: String, name: String, image1: String, image2: String)

object Post {
  var posts = Set(
    Post(1, "Alice", "The layout system", "image1.jpg", "image4.jpg"),
    Post(2, "Bev", "Big night out", "image3.jpg", "image2.jpg"),
    Post(3, "Diana", "A spot of gardening", "image1.jpg", "image3.jpg"),
    Post(4, "Clarice", "School daze", "image5.jpg", "image1.jpg"),
    Post(5, "Alice", "Ship ahoy", "image3.jpg", "image4.jpg")  )

  def findAll = posts.toList.sortBy(_.name)
  def findById(id: Int) = posts.find(_.id == id)

  def add(post: Post): Unit = {
    posts = posts + post
  }
}
