package tech.thdev.blog_kotlinandroidsample.network

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query
import tech.thdev.blog_kotlinandroidsample.BuildConfig
import tech.thdev.blog_kotlinandroidsample.data.PhotosContainer

/**
 * Created by taehwankwon on 7/23/17.
 */
interface FlickrApiService {

    // https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=key&format=json&nojsoncallback=1
    @GET("?method=flickr.photos.search&format=json&privacy_filter=1&nojsoncallback=1&safe_search=1&api_key=${BuildConfig.FLICKR_API_KEY}")
    fun searchUser(
            @Query(value = "text", encoded = true) searchKeyword: String,
            @Query("page") page: Int,
            @Query("per_page") perPage: Int): Flowable<PhotosContainer>
}
