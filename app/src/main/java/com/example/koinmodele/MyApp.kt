package com.example.android_di_koin_example

import android.app.Application
import com.example.android_di_koin_example.di.networkModule
import com.example.android_di_koin_example.di.repositoryModule
import com.example.android_di_koin_example.di.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@MyApp)
            androidFileProperties()
            koin.loadModules(// module list
                listOf(vmModule,networkModule))
        }
    }
}