package views.html.posts

object MyHelpers {
  import views.html.helper.FieldConstructor
  implicit val myFields = FieldConstructor(myFieldConstructor.f)
}