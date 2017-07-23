package tech.thdev.blog_kotlinandroidsample.view.main.like

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.fragment_list.*
import tech.thdev.base.view.BaseFragment
import tech.thdev.blog_kotlinandroidsample.R
import tech.thdev.blog_kotlinandroidsample.common.adapter.UserListAdapter
import tech.thdev.blog_kotlinandroidsample.data.source.data.search.UserSearchRepository
import tech.thdev.blog_kotlinandroidsample.view.main.like.view_model.LikeViewModel

/**
 * Created by Taehwan on 21/07/2017.
 */

class LikeFragment : BaseFragment() {

    companion object {
        val INSTANCE: LikeFragment by lazy {
            LikeFragment()
        }
    }

    private lateinit var userListAdapter: UserListAdapter

    private lateinit var likeViewModel: LikeViewModel

    override fun getLayoutResource() = R.layout.fragment_list

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userListAdapter = UserListAdapter(context)

        recycler_view.apply {
            adapter = userListAdapter
            layoutManager = LinearLayoutManager(context)
        }

        likeViewModel = LikeViewModel(UserSearchRepository, userListAdapter)
        likeViewModel.showProgress = {

        }
        likeViewModel.hideProgress = {

        }
        likeViewModel.searchGitHubUser("taehwandev")
    }
}