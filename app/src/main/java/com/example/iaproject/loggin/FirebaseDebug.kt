package com.example.iaproject.loggin

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

class FirebaseDebug : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {

        val crashlytics = FirebaseCrashlytics.getInstance()

        when(priority) {

            Log.WARN -> {
                crashlytics.log(message)
            }

            Log.ERROR -> {
                crashlytics.recordException(t ?: Throwable(message))
            }

            else -> {

            }
        }
    }
}