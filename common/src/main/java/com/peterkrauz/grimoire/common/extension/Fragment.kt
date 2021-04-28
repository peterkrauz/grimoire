package com.peterkrauz.grimoire.common.extension

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
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

fun Fragment.safeNavigate(
    @IdRes destinationId: Int,
    @IdRes actionId: Int,
    args: Bundle? = null,
    options: NavOptions? = null,
    extras: Navigator.Extras? = null
) {
    findNavController().safeNavigate(destinationId, actionId, args, options, extras)
}