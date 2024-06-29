package com.example.naturelife.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.naturelife.data.model.dto.RouteDomain
import javax.inject.Singleton

@Database(entities = [RouteDomain::class], version = 1)
@TypeConverters(Converters::class)
@Singleton
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): RoutesDao
}