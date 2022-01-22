package com.example.daggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.daggerhilt.util.Battery
import com.example.daggerhilt.util.Car
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var car : Car

    @Inject
    lateinit var carFunctions: CarFunctions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = car.getCarName()
        val battery = car.getBatterySize()
        val carFunc = carFunctions.doDrive()

        Log.d(TAG, "$name")
        Log.d(TAG, "$battery")
        Log.d(TAG, "$carFunc")
    }

    companion object {
        const val TAG = "Hilt"
    }
}