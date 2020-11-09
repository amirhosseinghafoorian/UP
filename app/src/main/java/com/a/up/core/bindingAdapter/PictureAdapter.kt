package com.a.up.core.bindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:url")
fun showPic(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url)
        .optionalCircleCrop()
        .into(imageView)
}