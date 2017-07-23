package tech.thdev.blog_kotlinandroidsample.network

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query
import tech.thdev.blog_kotlinandroidsample.data.UserResponse

/**
 * Created by taehwankwon on 7/23/17.
 */
interface GitHubService {

    // https://api.github.com/search/users?q=tom+repos:%3E42&page=3&per_page=50
    @GET("/search/users?")
    fun searchUser(
            @Query(value = "q", encoded = true) userKeyword: String,
            @Query("page") page: Int,
            @Query("per_page") perPage: Int): Flowable<UserResponse>
}