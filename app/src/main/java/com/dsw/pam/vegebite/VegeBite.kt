package com.dsw.pam.vegebite

import android.app.Application
import com.dsw.pam.vegebite.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class VegeBite: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@VegeBite)
            modules(appModule)
            androidLogger()
        }
    }
}