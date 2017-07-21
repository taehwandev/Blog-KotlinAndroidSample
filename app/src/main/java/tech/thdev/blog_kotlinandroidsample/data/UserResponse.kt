package tech.thdev.blog_kotlinandroidsample.data

/**
 * Created by Taehwan on 21/07/2017.
 */

data class UserResponse(val message: String,
                        val documentation_url: String,
                        val total_count: String,
                        val jincomplete_results: Boolean,
                        val items: List<UserItem>)