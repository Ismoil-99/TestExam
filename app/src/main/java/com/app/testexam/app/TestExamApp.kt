package com.app.testexam.app

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.app.testexam.data.basehistory.BaseHistory


class TestExamApp:Application() {
    val database: BaseHistory by lazy { BaseHistory.getDatabase(this) }
    override fun onCreate() {
        super.onCreate()
        sharedPreferences = this.getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE)
        sharedPreferencesEditor = sharedPreferences.edit()

    }
    companion object {
        lateinit var sharedPreferences: SharedPreferences
        lateinit var sharedPreferencesEditor: SharedPreferences.Editor
    }
}