package tech.thdev.androidblogexamplewithkotlin.data.source.user

import io.reactivex.Flowable
import io.reactivex.Maybe
import tech.thdev.androidblogexamplewithkotlin.data.UserInfo

/**
 * Created by tae-hwan on 5/11/17.
 */

object UserRepository : UserSource {

    private val userLocalDataSource = UserLocalDataSource
    private var userInfo: UserInfo? = null

    override fun getUserData(userId: String, userPassword: String): Flowable<UserInfo>
            = userInfo?.
            let {
                Flowable.just(it)
            }
            ?: getLocalDataUserInfo(userId, userPassword)

    private fun getLocalDataUserInfo(userId: String, userPassword: String)
            = userLocalDataSource.getUserData(userId, userPassword)
            .flatMap {
                Flowable.just(it)
                        .doOnNext {
                            userInfo = it
                        }
            }
}