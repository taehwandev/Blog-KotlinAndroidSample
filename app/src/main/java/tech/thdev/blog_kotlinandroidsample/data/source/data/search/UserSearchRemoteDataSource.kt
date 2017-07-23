package tech.thdev.blog_kotlinandroidsample.data.source.data.search

import io.reactivex.Flowable
import tech.thdev.blog_kotlinandroidsample.data.UserItem
import tech.thdev.blog_kotlinandroidsample.network.GitHubService
import tech.thdev.blog_kotlinandroidsample.network.createRetrofit

/**
 * Created by Taehwan on 7/23/17.
 */
object UserSearchRemoteDataSource : UserSearchDataSource {

    val gitHubService: GitHubService by lazy {
        createRetrofit(GitHubService::class.java, "https://api.github.com/")
    }

    override fun getSearchUser(userKeyword: String, page: Int, perPage: Int): Flowable<List<UserItem>> =
            gitHubService.searchUser(userKeyword, page, perPage)
                    .flatMap {
                        Flowable.just(it.items)
                    }
}