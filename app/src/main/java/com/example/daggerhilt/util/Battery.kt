package com.example.daggerhilt.util

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class Battery @Inject constructor() {
    fun getBatterySize() : Int {
        return 12
    }
}