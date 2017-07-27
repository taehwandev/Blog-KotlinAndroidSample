package tech.thdev.blog_kotlinandroidsample

import android.os.Bundle
import tech.thdev.androidblogexamplewithkotlin.R
import tech.thdev.base.view.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
