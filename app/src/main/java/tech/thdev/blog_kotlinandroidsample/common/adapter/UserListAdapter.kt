package tech.thdev.blog_kotlinandroidsample.common.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.thdev.blog_kotlinandroidsample.common.adapter.holder.UserViewHolder
import tech.thdev.blog_kotlinandroidsample.common.adapter.view_model.UserListViewModel

/**
 * Created by Taehwan on 21/07/2017.
 */

class UserListAdapter(val context: Context) : RecyclerView.Adapter<UserViewHolder>(){

    val userListViewModel = UserListViewModel()

    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
        holder?.onBindViewHolder(userListViewModel.getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            UserViewHolder(this, parent)

    override fun getItemCount() = userListViewModel.size
}