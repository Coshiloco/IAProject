package com.example.iaproject.loggin

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

class FirebaseRelease : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.ERROR) {
            FirebaseCrashlytics.getInstance().recordException(t ?: Throwable(message))
        }
    }
}