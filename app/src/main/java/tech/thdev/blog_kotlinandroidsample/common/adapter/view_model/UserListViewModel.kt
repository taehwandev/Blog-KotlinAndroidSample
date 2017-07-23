package tech.thdev.blog_kotlinandroidsample.common.adapter.view_model

import android.arch.lifecycle.ViewModel
import tech.thdev.blog_kotlinandroidsample.data.UserItem

/**
 * Created by taehwankwon on 7/23/17.
 */
class UserListViewModel : ViewModel() {

    val list = mutableListOf<UserItem>()

    val size: Int
        get() = list.size

    lateinit var onClickListener: (Int) -> Unit

    fun getItem(position: Int) = list[position]

    fun addItem(item: UserItem) = list.add(item)
}