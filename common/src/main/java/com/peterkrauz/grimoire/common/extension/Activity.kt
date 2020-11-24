package com.peterkrauz.grimoire.common.extension

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.peterkrauz.grimoire.common.snackbar.SnackBarType

fun AppCompatActivity.snackBar(
    hostView: View,
    message: Int,
    type: SnackBarType
) {
    Snackbar.make(
        hostView,
        message,
        Snackbar.LENGTH_SHORT
    ).apply {
        view.setBackgroundResource(type.backgroundRes)
    }.show()
}