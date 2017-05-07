package tech.thdev.overlaysample.view.presenter

import android.provider.Settings.canDrawOverlays
import tech.thdev.base.presenter.CommonPresenter

/**
 * Created by tae-hwan on 18/12/2016.
 */

class MainPresenter : CommonPresenter<MainContract.View>(), MainContract.Presenter {

    override fun startOverlayWindowService(context: android.content.Context) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M && !canDrawOverlays(context)) {
            view?.showObtainingPermissionOverlayWindow()

        } else {
            view?.showStartOverlay()
        }
    }

    override fun onOverlayResult(context: android.content.Context) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (canDrawOverlays(context)) {
                view?.showStartOverlay()
            }
        }
    }
}