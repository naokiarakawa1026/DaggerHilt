package com.example.daggerhilt.module

import android.content.Context
import com.example.daggerhilt.qualifier.ApiKey
import com.example.daggerhilt.qualifier.DatabaseName
import com.example.daggerhilt.util.DatabaseService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @DatabaseName
    @Provides
    fun provideDatabaseName() : String {
        return "local.db"
    }

    @Singleton
    @ApiKey
    @Provides
    fun provideApiKey() : String {
        return "aaaaaaaaaaaaaaaaaaaa"
    }

    @Singleton
    @Provides
    fun provideDatabaseService(@ApplicationContext context: Context) : DatabaseService {
        return DatabaseService(context)
    }
}