package com.foltran.deeplinknavigationsample

import android.app.Application
import com.foltran.deeplinknavigationsample.module.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class MainApplication: Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin()
    }

    private fun startKoin() {
        if (GlobalContext.getOrNull() == null) {
            org.koin.core.context.startKoin {
                androidLogger()
                androidContext(this@MainApplication)
                modules(AppModule.modules)
            }
        }
    }
}