package tech.thdev.androidblogexamplewithkotlin.view.login.viewmodel

import io.reactivex.subjects.PublishSubject
import tech.thdev.androidblogexamplewithkotlin.data.UserInfo
import tech.thdev.androidblogexamplewithkotlin.data.source.user.UserRepository

/**
 * Created by tae-hwan on 5/10/17.
 */

class LoginViewModel(val userRepository: UserRepository) : LoginNavigation {

    val FAIL_TYPE_DO_NOT_ENTER_ID: Int = 0
    val FAIL_TYPE_DO_NOT_ENTER_PASSOWD: Int = 0
    val FAIL_TYPE_NOT_FOUND_USER: Int = 0

    override val publishShowProgress: PublishSubject<Boolean> = PublishSubject.create()

    override val publishLoginSuccess: PublishSubject<UserInfo> = PublishSubject.create()

    override val publishLoginFail: PublishSubject<Int> = PublishSubject.create()

    override fun startLogin(userId: String, password: String) {
        if (userId.isEmpty()) {
            publishLoginFail.onNext(FAIL_TYPE_DO_NOT_ENTER_ID)
            return
        }
        if (password.isEmpty()) {
            publishLoginFail.onNext(FAIL_TYPE_DO_NOT_ENTER_PASSOWD)
            return
        }
//        userRepository.getUserData(userId, password)
//                .filter {
//
//                }
    }
}