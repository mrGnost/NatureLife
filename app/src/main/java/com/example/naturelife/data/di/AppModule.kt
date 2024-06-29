package com.example.naturelife.data.di

import android.content.Context
import androidx.room.Room
import com.example.naturelife.data.dao.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "your_db_name"
    ).build()

    @Singleton
    @Provides
    fun provideDao(db: AppDatabase) = db.userDao()
}