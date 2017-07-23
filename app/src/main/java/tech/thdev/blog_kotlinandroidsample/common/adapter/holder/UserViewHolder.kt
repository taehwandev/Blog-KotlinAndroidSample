package tech.thdev.blog_kotlinandroidsample.common.adapter.holder

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_user_info.view.*
import tech.thdev.blog_kotlinandroidsample.R
import tech.thdev.blog_kotlinandroidsample.common.adapter.UserListAdapter
import tech.thdev.blog_kotlinandroidsample.data.UserItem

/**
 * Created by Taehwan on 21/07/2017.
 */

class UserViewHolder(val adapter: UserListAdapter,
                     parent: ViewGroup?) :
        RecyclerView.ViewHolder(LayoutInflater.from(adapter.context).inflate(R.layout.item_user_info, parent, false)) {

    init {
        itemView.setOnClickListener {
            adapter.userListViewModel.onClickListener(adapterPosition)
        }
    }

    @SuppressLint("RestrictedApi")
    fun onBindViewHolder(item: UserItem) {
        itemView.run {
            Glide.with(adapter.context)
                    .load(item.avatar_url)
                    .into(circle_iv_user)
            tv_user_name.text = item.login
            checkbox.isChecked = item.isLike
        }
    }
}