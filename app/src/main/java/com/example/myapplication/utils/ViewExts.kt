package com.example.myapplication.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.*
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.example.myapplication.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.DelicateCoroutinesApi
import java.io.File
import java.util.regex.Matcher
import java.util.regex.Pattern


fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}


fun View?.showSnackBar(message: String?) {
    if (this != null && message.checkNotEmpty()) {
        Snackbar.make(this, message!!, Snackbar.LENGTH_SHORT).apply {
            show()
        }
    }
}

fun String?.checkNotEmpty(): Boolean {
    return this != null && isNotEmpty() && isNotBlank()
}

fun View?.showSnackBar(message: Int, icon: Int = 0) {
    this ?: return

    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).apply {
        show()
    }
}


fun AppCompatImageView.loadImage(res: String) {
    this.let {
        Glide.with(it)
            .load(res)
            .fitCenter()
            .into(it)

    }
}
