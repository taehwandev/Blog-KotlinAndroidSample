package tech.thdev.blog_kotlinandroidsample.data.source.data.search

import io.reactivex.Flowable
import tech.thdev.blog_kotlinandroidsample.data.Photo

/**
 * Created by Taehwan on 21/07/2017.
 */
interface UserSearchDataSource {

    fun getSearchUser(userKeyword: String, page: Int, perPage: Int): Flowable<List<Photo>>
}