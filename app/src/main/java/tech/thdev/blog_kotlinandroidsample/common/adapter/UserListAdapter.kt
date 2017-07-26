package tech.thdev.blog_kotlinandroidsample.common.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.thdev.blog_kotlinandroidsample.common.adapter.holder.PhotoViewHolder
import tech.thdev.blog_kotlinandroidsample.common.adapter.view_model.UserListViewModel

/**
 * Created by Taehwan on 21/07/2017.
 */

class UserListAdapter(val context: Context, val userListViewModel: UserListViewModel) : RecyclerView.Adapter<PhotoViewHolder>(){

    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        holder?.onBindViewHolder(userListViewModel.getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            PhotoViewHolder(this, parent)

    override fun getItemCount() = userListViewModel.size
}