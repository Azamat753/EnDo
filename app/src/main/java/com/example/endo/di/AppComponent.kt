package com.example.endo.di

import com.example.db.di.DBModule
import com.example.network.di.NetworkModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module(
    includes = [
        DBModule::class,
        NetworkModule::class,
        ApplicationModule::class,
    ]
)
interface AppAggregatorModule