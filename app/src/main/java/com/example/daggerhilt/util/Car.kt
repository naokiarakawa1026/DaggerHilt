package com.example.daggerhilt.util

import javax.inject.Inject

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