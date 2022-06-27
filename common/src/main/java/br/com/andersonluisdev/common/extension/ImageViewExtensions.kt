package br.com.andersonluisdev.common.extension

import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun ImageView.disable(@DrawableRes drawable: Int){
    setImageResource(drawable)
    isClickable = false
}

fun ImageView.enable(@DrawableRes drawable: Int){
    setImageResource(drawable)
    isClickable = true
}

fun ImageView.setUrlImage(url: String?, viewGroup: ViewGroup) {
    Glide.with(viewGroup)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}
