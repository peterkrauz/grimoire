package com.peterkrauz.grimoire.common.extension

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

fun NavController.safeNavigate(
    @IdRes destinationId: Int,
    @IdRes actionId: Int,
    args: Bundle? = null,
    options: NavOptions? = null,
    extras: Navigator.Extras? = null
) {
    if (currentDestination?.id == destinationId) {
        navigate(actionId, args, options, extras)
    }
}
