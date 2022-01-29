package com.example.composedemo

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ComposeDemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ComposeDemoApplication)
            androidLogger(
                // Riga di workaround per kotlin 1.6
                // che causa errore e l'app non parte
                (if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            )
            modules(myAppModule)
        }

    }
}