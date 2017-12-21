package com.kevicsalazar.sample.culqi.utils

import android.content.Context
import android.support.v7.app.AlertDialog

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */

fun Context.alert(title: String, message: String,
                  init: (AlertDialog.Builder.() -> Unit)? = null)
        = AlertDialog.Builder(this).apply {
    setTitle(title)
    setMessage(message)
    setPositiveButton("OK", {
        dialog, _ ->
        dialog.dismiss()
    })
    init?.let { init() }
}