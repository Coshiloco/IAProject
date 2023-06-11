// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    id("com.google.dagger.hilt.android") version "2.46.1" apply false
}
buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
       //noinspection UseTomlInstead
       classpath("com.google.gms:google-services:4.3.15")
       //noinspection UseTomlInstead
       classpath("com.android.tools.build:gradle:8.2.0-alpha07")
       //noinspection UseTomlInstead
       classpath("com.google.firebase:firebase-crashlytics-gradle:2.9.5")
       //noinspection UseTomlInstead
       classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
    }
}
true // Needed to make the Suppress annotation work for the plugins block

