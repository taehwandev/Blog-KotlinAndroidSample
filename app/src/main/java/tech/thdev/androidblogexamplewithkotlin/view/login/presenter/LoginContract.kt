package tech.thdev.androidblogexamplewithkotlin.view.login.presenter

import tech.thdev.base.presenter.BasePresenter
import tech.thdev.base.presenter.BaseView

/**
 * Created by tae-hwan on 5/10/17.
 */

interface LoginContract {

    interface View : BaseView {

        fun showProgress()

        fun hideProgress()

        fun loginSuccess()

        fun loginFail()
    }

    interface Presetner : BasePresenter<View> {

        fun startLogin(name: String, password: String)
    }
}