package tech.thdev.androidblogexamplewithkotlin.data.source.user

import io.reactivex.Flowable
import tech.thdev.androidblogexamplewithkotlin.data.UserInfo

/**
 * Created by tae-hwan on 5/11/17.
 */

interface UserSource {

    fun getUserData(userId: String, userPassword: String): Flowable<UserInfo>
}