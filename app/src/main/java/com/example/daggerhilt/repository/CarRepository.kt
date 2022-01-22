package com.example.daggerhilt.repository

import com.example.daggerhilt.qualifier.ApiKey
import com.example.daggerhilt.qualifier.DatabaseName
import javax.inject.Inject

class CarRepository @Inject constructor(
    @DatabaseName private val databaseName: String,
    @ApiKey private val apiKey : String
) {
    fun addRow() : Int {
        return 101
    }

    fun getDatabaseName() : String {
        return databaseName
    }

    fun getApiKey() : String {
        return apiKey
    }
}