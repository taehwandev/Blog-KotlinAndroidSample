package tech.thdev.blog_kotlinandroidsample.view.main.search

import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.fragment_list.*
import tech.thdev.base.view.BaseFragment
import tech.thdev.blog_kotlinandroidsample.R
import tech.thdev.blog_kotlinandroidsample.common.adapter.UserListAdapter
import tech.thdev.blog_kotlinandroidsample.common.adapter.view_model.UserListViewModel
import tech.thdev.blog_kotlinandroidsample.data.source.data.search.UserSearchRepository
import tech.thdev.blog_kotlinandroidsample.view.main.search.view_model.SearchViewModel
import tech.thdev.lifecycle.extensions.inject

/**
 * Created by Taehwan on 21/07/2017.
 */

class SearchFragment : BaseFragment() {

    companion object {
        val INSTANCE: SearchFragment by lazy {
            SearchFragment()
        }
    }

    private lateinit var userListAdapter: UserListAdapter

    private lateinit var searchViewModel: SearchViewModel

    override fun getLayoutResource() = R.layout.fragment_list

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userListAdapter = UserListAdapter(context, UserListViewModel().inject(this))

        recycler_view.apply {
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
            adapter = userListAdapter
        }

        searchViewModel = SearchViewModel(UserSearchRepository, userListAdapter).inject(this)
        searchViewModel.showProgress = {

        }
        searchViewModel.hideProgress = {

        }
        searchViewModel.searchGitHubUser("seoul")
    }
}