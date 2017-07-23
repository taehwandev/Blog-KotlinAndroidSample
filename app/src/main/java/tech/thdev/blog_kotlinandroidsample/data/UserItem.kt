package tech.thdev.blog_kotlinandroidsample.data

/**
 * Created by Taehwan on 21/07/2017.
 */

data class UserItem(val login: String,
                    val avatar_url: String,
                    val html_url: String,
                    val score: Float,
                    var isLike: Boolean = false)