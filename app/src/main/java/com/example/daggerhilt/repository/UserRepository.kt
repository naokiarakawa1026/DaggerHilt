package com.example.daggerhilt.repository

interface UserRepository {
    fun getDatabaseName() : String

    fun getUserList () : List<String>
}