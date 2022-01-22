package com.example.daggerhilt.module

import com.example.daggerhilt.CarFunctions
import com.example.daggerhilt.CarFunctionsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ActivityModule {

    @Binds
    abstract fun bindFunction(
        carFunctionsImpl: CarFunctionsImpl
    ) : CarFunctions
}