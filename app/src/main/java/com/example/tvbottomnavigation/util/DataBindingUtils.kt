package com.example.tvbottomnavigation.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class DataBindingUtils {
    companion object {
        @JvmStatic
        @BindingAdapter("android:loadImage")
        fun loadImage(imageView: ImageView, url: String?) {
            if(url != null)
                Glide
                    .with(imageView.context)
                    .load(url)
//                    .centerCrop()
                    .into(imageView)
        }
    }
}