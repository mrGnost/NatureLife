package com.example.naturelife.data.di

import com.example.naturelife.data.repository.DatabaseRepositoryImpl
import com.example.naturelife.domain.repository.DatabaseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BindsModule {
    @Binds
    fun bindDatabaseRepository(repository: DatabaseRepositoryImpl): DatabaseRepository
}