package com.agusstkd.fasekotlin

import android.app.Application


class DesaMobileApp: Application() {

    companion object {
        lateinit var instance: DesaMobileApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}