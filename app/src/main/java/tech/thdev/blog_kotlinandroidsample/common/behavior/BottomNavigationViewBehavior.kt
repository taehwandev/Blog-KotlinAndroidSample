package tech.thdev.blog_kotlinandroidsample.common.behavior

import android.content.Context
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet

/**
 * Created by taehwankwon on 7/26/17.
 */
class BottomNavigationViewBehavior(context: Context? = null, attributeSet: AttributeSet? = null) : VerticalViewBehavior<BottomNavigationView>(context, attributeSet) {

    var duration = 200L

    override fun slideUp(child: BottomNavigationView?) {
        child?.run {
            clearAnimation()
            animate().translationY(0f).duration = duration
        }
    }

    override fun slideDown(child: BottomNavigationView?) {
        child?.run {
            clearAnimation()
            animate().translationY(height.toFloat()).duration = duration
        }
    }
}