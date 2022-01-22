package com.example.daggerhilt.module

import android.content.Context
import com.example.daggerhilt.CarFunctions
import com.example.daggerhilt.CarFunctionsImpl
import com.example.daggerhilt.qualifier.ApiKey
import com.example.daggerhilt.qualifier.DatabaseName
import com.example.daggerhilt.repository.CarRepository
import com.example.daggerhilt.util.DatabaseService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {
    // @Bindsを使用しhないため、abstractは不要である

    @ActivityScoped
    @Provides
    fun provideCarRepository(
        @DatabaseName databaseName: String,
        @ApiKey apiKey: String
    ): CarRepository {
        return CarRepository(databaseName, apiKey)
    }

    @ActivityScoped
    @Provides
    fun provideCarFunctionsImpl(
        carRepository: CarRepository
    ): CarFunctions {
        return CarFunctionsImpl(carRepository)
    }

    @ActivityScoped
    @Provides
    fun provideDatabaseService(@ActivityContext context: Context) : DatabaseService {
        return DatabaseService(context)
    }

//    @Binds
//    abstract fun bindFunction(
//        carFunctionsImpl: CarFunctionsImpl
//    ): CarFunctions
}