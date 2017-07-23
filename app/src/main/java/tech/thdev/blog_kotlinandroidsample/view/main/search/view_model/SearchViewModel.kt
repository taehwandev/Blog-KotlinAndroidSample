package tech.thdev.blog_kotlinandroidsample.view.main.search.view_model

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.processors.BehaviorProcessor
import io.reactivex.schedulers.Schedulers
import tech.thdev.blog_kotlinandroidsample.common.adapter.UserListAdapter
import tech.thdev.blog_kotlinandroidsample.data.source.data.search.UserSearchDataSource
import java.util.concurrent.TimeUnit

/**
 * Created by taehwankwon on 7/23/17.
 */
class SearchViewModel(val userSearchDataSource: UserSearchDataSource,
                      val adapter: UserListAdapter)
    : ViewModel() {

    lateinit var hideProgress: () -> Unit
    lateinit var showProgress: () -> Unit

    val DEFAULT_PER_PAGE = 20
    var page = 0

    init {
        adapter.userListViewModel.onClickListener = {
            position ->
            val item = adapter.userListViewModel.getItem(position)
            item.isLike = !item.isLike
            adapter.notifyItemChanged(position)
        }
    }

    val userSearchProcessor = BehaviorProcessor.createDefault("")!!

    val userSearchDisposable = userSearchProcessor
            .subscribeOn(Schedulers.io())
            .filter {
                it.isNotEmpty()
            }
            .distinctUntilChanged()
            .sample(400, TimeUnit.MILLISECONDS, true)
            .subscribe {
                userSearchDataSource.getSearchUser(it, ++page, DEFAULT_PER_PAGE)
                        .observeOn(Schedulers.io())
                        .flatMapIterable {
                            it
                        }
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe { showProgress() }
                        .doOnComplete {
                            hideProgress()
                            adapter.notifyDataSetChanged()
                        }
                        .observeOn(Schedulers.io())
                        .subscribe({
                            adapter.userListViewModel.addItem(it)
                        },{
                            it.printStackTrace()
                        })
            }!!

    fun searchGitHubUser(name: String) {
        userSearchProcessor.onNext(name)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        userSearchDisposable.takeIf { !it.isDisposed }?.dispose()
    }
}