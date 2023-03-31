package com.example.myapplication.utils

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.myapplication.R

object ProgressDialogUtil {
    private var dialog: Dialog? = null
    fun showProgressDialog(context: Context) {
        try {
            if (dialog == null) {
                dialog = Dialog(context)
                dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog?.setContentView(R.layout.layout_loading_dialog)
                dialog?.window?.setBackgroundDrawable(
                    ColorDrawable(
                        ContextCompat.getColor(
                            context,
                            android.R.color.transparent
                        )
                    )
                )
                dialog?.setCancelable(false)
            }
            dialog?.show()
        } catch (e: Exception) {
            Log.e(">showProgressDialog>", e.localizedMessage)
        }
    }

    fun hideProgressDialog() {
        try {
            if (dialog != null) {
                if (dialog!!.isShowing) {
                    dialog?.dismiss()
                }
                dialog = null
            }
        } catch (e: Exception) {
            Log.e(">hideProgressDialog>", e.localizedMessage)
        }
    }
}