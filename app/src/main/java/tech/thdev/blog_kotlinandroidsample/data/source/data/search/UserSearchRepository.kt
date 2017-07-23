package tech.thdev.blog_kotlinandroidsample.data.source.data.search

/**
 * Created by taehwankwon on 7/23/17.
 */
object UserSearchRepository : UserSearchDataSource {

    override fun getSearchUser(userKeyword: String, page: Int, perPage: Int)
            = UserSearchRemoteDataSource.getSearchUser(userKeyword, page, perPage)
}