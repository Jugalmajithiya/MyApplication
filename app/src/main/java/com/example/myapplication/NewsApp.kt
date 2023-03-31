package com.example.myapplication

import android.app.Application


lateinit var instanceApp: NewsApp

class NewsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        instanceApp = this
    }
}