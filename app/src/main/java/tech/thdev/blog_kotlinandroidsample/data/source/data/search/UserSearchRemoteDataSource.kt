package tech.thdev.blog_kotlinandroidsample.data.source.data.search

import io.reactivex.Flowable
import tech.thdev.blog_kotlinandroidsample.data.Photo
import tech.thdev.blog_kotlinandroidsample.network.FlickrApiService
import tech.thdev.blog_kotlinandroidsample.network.createRetrofit

/**
 * Created by Taehwan on 7/23/17.
 */
object UserSearchRemoteDataSource : UserSearchDataSource {

    val flickrApiService: FlickrApiService by lazy {
        createRetrofit(FlickrApiService::class.java, "https://api.flickr.com/services/rest/")
    }

    override fun getSearchUser(userKeyword: String, page: Int, perPage: Int): Flowable<List<Photo>> =
            flickrApiService.searchUser(userKeyword, page, perPage)
                    .filter {
                        it.photos.photo.isNotEmpty()
                    }
                    .flatMap {
                        Flowable.just(it.photos.photo)
                    }
}