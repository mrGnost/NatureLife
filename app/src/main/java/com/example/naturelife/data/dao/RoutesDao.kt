package com.example.naturelife.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.naturelife.data.model.dto.RouteDomain
import kotlinx.coroutines.flow.Flow

@Dao
interface RoutesDao {
    @Insert
    fun insertRoutes(vararg routes: RouteDomain)

    @Query("SELECT * FROM RouteDomain")
    fun getRoutes(): Flow<List<RouteDomain>>
}