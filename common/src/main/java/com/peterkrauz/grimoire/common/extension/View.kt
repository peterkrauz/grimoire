package com.peterkrauz.grimoire.common.extension

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View

@SuppressLint("ClickableViewAccessibility")
fun View.captureTouchEventsFrom(vararg view: View) {
    val dropDownTouchListener = View.OnTouchListener { _, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN,
            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> {
                dispatchTouchEvent(event)
                true
            }
            else -> false
        }
    }

    view.forEach { it.setOnTouchListener(dropDownTouchListener) }
}