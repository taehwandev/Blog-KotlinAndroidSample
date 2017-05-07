package tech.thdev.androidblogexamplewithkotlin

import android.os.Bundle
import tech.thdev.base.view.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
