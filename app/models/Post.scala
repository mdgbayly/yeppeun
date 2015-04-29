package models

/**
 * Created by mbayly on 29/04/2015.
 */
case class Post(author: String, name: String)

object Post {
  var posts = Set(
    Post("alice", "Out shopping"),
    Post("bev", "Big night out"),
    Post("clarice", "School daze"),
    Post("alice", "Ship ahoy")
  )

  def findAll = posts.toList.sortBy(_.name)
}
