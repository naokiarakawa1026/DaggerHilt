package com.example.daggerhilt.repository

import javax.inject.Inject

class CarRepository @Inject constructor() {
    fun addRow() : Int {
        return 101
    }
}