package com.peterkrauz.grimoire.common.extension

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.peterkrauz.grimoire.common.snackbar.SnackBarType

fun Fragment.snackBar(
    message: Int,
    type: SnackBarType = SnackBarType.DEFAULT
) {
    Snackbar.make(
        requireView(),
        message,
        Snackbar.LENGTH_LONG
    ).apply {
        view.setBackgroundResource(type.backgroundRes)
    }.show()
}