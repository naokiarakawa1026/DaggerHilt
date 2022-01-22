package com.example.daggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.daggerhilt.ui.MainFragment
import com.example.daggerhilt.util.Battery
import com.example.daggerhilt.util.Car
import com.example.daggerhilt.util.DatabaseService
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var car : Car
    @Inject lateinit var carFunctions: CarFunctionsImpl
    @Inject lateinit var databaseService : DatabaseService
    @Inject lateinit var appFragmentFactory: AppFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = car.getCarName()
        val battery = car.getBatterySize()
        val carFunc = carFunctions.doDrive()
        val addResult = carFunctions.insert()

        Log.d(TAG, "$name")
        Log.d(TAG, "$battery")
        Log.d(TAG, "$carFunc")
        Log.d(TAG, "$addResult")

        supportFragmentManager.fragmentFactory = appFragmentFactory
        supportFragmentManager.beginTransaction().replace(R.id.main_fragment_container, MainFragment::class.java, null)
            .addToBackStack("MainActivity")
            .commit()
    }

    companion object {
        const val TAG = "Hilt"
    }
}