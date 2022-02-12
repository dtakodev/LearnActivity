package com.kovappkoi.learnactivity.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("src")
fun setSrc(imageView: ImageView, url: String){
    Glide.with(imageView.context).load(url).into(imageView)
}