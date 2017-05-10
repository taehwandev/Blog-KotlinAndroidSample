package tech.thdev.androidblogexamplewithkotlin.view.login.viewmodel

import io.reactivex.subjects.PublishSubject
import tech.thdev.androidblogexamplewithkotlin.data.UserInfo

/**
 * Created by tae-hwan on 5/10/17.
 */

interface LoginNavigation {

    val publishShowProgress: PublishSubject<Boolean>

    val publishLoginSuccess: PublishSubject<UserInfo>

    val publishLoginFail: PublishSubject<Int>

    fun startLogin(userId: String, password: String)
}