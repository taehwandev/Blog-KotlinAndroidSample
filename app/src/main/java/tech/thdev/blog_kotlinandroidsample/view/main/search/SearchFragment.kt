package tech.thdev.blog_kotlinandroidsample.view.main.search

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.fragment_list.*
import tech.thdev.base.view.BaseFragment
import tech.thdev.blog_kotlinandroidsample.R
import tech.thdev.blog_kotlinandroidsample.common.adapter.UserListAdapter

/**
 * Created by Taehwan on 21/07/2017.
 */

class SearchFragment : BaseFragment() {

    private lateinit var userListAdapter: UserListAdapter

    override fun getLayoutResource() = R.layout.fragment_list

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userListAdapter = UserListAdapter(context)

        recycler_view.apply {
            adapter = userListAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}