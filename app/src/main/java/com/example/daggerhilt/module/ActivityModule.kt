package com.example.daggerhilt.module

import com.example.daggerhilt.CarFunctions
import com.example.daggerhilt.CarFunctionsImpl
import com.example.daggerhilt.repository.CarRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {
    // @Bindsを使用しhないため、abstractは不要である

    @Provides
    fun provideCarRepository(): CarRepository {
        return CarRepository()
    }

    @Provides
    fun provideCarFunctionsImpl(
        carRepository: CarRepository
    ) : CarFunctions {
        return CarFunctionsImpl(carRepository)
    }

//    @Binds
//    abstract fun bindFunction(
//        carFunctionsImpl: CarFunctionsImpl
//    ): CarFunctions
}