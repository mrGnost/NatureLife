package com.example.naturelife

import android.app.Application
import com.example.naturelife.di.AppComponent
import com.example.naturelife.di.DaggerAppComponent

class App : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().context(applicationContext).build()
    }
}