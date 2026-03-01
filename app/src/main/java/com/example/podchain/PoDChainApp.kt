package com.example.podchain

import android.app.Application
import com.google.firebase.Firebase
import com.google.firebase.initialize

class PoDChainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize Firebase
        Firebase.initialize(this)
    }
}