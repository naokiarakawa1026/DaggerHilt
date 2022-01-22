package com.example.daggerhilt

import com.example.daggerhilt.repository.CarRepository
import javax.inject.Inject

class CarFunctionsImpl @Inject constructor(private val carRepository: CarRepository): CarFunctions {

    override fun doDrive(): String {
        return "Car can drive"
    }

    fun insert() : Int {
        return carRepository.addRow()
    }
}