package tech.thdev.blog_kotlinandroidsample.data

/**
 * Created by taehwankwon on 7/27/17.
 */
data class Photos(val page: Int,
                  val pages: Int,
                  val perpage: Int,
                  val total: String,
                  val photo: List<Photo>,
                  val stat: String)