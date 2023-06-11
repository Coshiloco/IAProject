package com.example.iaproject

import android.app.Application
import com.example.iaproject.loggin.FirebaseDebug
import com.example.iaproject.loggin.FirebaseRelease
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import kotlin.system.exitProcess

@HiltAndroidApp
class AiProject: Application() {
    override fun onCreate() {
        super.onCreate()

        configureLogging()
        handleUncaughtExceptions()
    }

    private fun configureLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.plant(FirebaseDebug()) // TODO: Remove this line when there is no need to upload debug logs to Firebase
        } else {
            Timber.plant(FirebaseRelease())
        }
    }

    private fun handleUncaughtExceptions() {
        Thread.setDefaultUncaughtExceptionHandler { _, paramThrowable ->
            Timber.e(paramThrowable)
            exitProcess(1)
        }
    }
}