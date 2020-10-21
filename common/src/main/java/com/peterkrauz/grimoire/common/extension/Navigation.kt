package com.peterkrauz.grimoire.common.extension

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController

fun NavController.safeNavigate(
    @IdRes destinationId: Int,
    @IdRes actionId: Int,
    args: Bundle? = null
) {
    if (currentDestination?.id == destinationId) {
        navigate(actionId, args)
    }
}
