package com.example.daggerhilt.repository

import com.example.daggerhilt.qualifier.DatabaseName
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    @DatabaseName private val databaseName: String
    ) : UserRepository {

    override fun getDatabaseName(): String {
        return databaseName
    }

    override fun getUserList(): List<String> {
        return listOf("David", "Sita", "Rita")
    }
}