package xyz.teamgravity.explosionfab

import android.view.View
import android.view.animation.Animation

fun View.startAnimation(animation: Animation, onEndListener: () -> Unit) {
    animation.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) = Unit

        override fun onAnimationEnd(animation: Animation?) {
            onEndListener()
        }

        override fun onAnimationRepeat(animation: Animation?) = Unit
    })

    this.startAnimation(animation)
}