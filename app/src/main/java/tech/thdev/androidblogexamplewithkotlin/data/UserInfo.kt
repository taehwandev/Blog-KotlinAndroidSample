package tech.thdev.androidblogexamplewithkotlin.data

/**
 * Created by tae-hwan on 5/10/17.
 */

data class UserInfo(
        var name: String,
        var age: Int,
        var email: String,
        val userName: String,
        var password: String)