package com.example.compose_first

import android.app.Application
import com.example.compose_first.database.SourcesDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class myApplication  : Application(){
    override fun onCreate() {
        super.onCreate()
        SourcesDatabase.createDataBase(this)
    }

}