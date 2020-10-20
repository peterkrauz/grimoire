package com.peterkrauz.grimoire.common.snackbar

import androidx.annotation.DrawableRes
import com.peterkrauz.grimoire.common.R

enum class SnackBarType(@DrawableRes val backgroundRes: Int) {
    ERROR(R.drawable.bg_snackbar_error),
    SUCCESS(R.drawable.bg_snackbar_success),
    DEFAULT(R.drawable.bg_snackbar_default)
}
