package com.example.daggerhilt.util

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class Car @Inject constructor(
    private val battery: Battery
) {
    fun getCarName(): String {
        return "This is a Toyota"
    }

    fun getBatterySize(): String {
        val batterySize = battery.getBatterySize()
        return "The battery size is $batterySize"
    }
}