package com.threed.supply.libs.util

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import com.threed.supply.app.di.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class ToastManager @Inject constructor(private val context: Context) {

    fun show(@StringRes messageId: Int) {
        Toast.makeText(context, messageId, Toast.LENGTH_LONG).show()
    }

    fun show(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}