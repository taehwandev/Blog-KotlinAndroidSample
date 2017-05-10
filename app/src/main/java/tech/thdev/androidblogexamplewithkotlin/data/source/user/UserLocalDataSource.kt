package tech.thdev.androidblogexamplewithkotlin.data.source.user

import io.reactivex.Flowable
import tech.thdev.androidblogexamplewithkotlin.data.UserInfo

/**
 * Created by tae-hwan on 5/11/17.
 */

object UserLocalDataSource : UserSource {

    val mutableMap = mutableMapOf("user" to "1234", "user2" to "4567")

    override fun getUserData(userId: String, userPassword: String): Flowable<UserInfo> {
        mutableMap[userId]?.let {
            return Flowable.just(UserInfo("User", 20, "user@user.com", userId, userPassword))
        } ?: return Flowable.empty()
    }
}