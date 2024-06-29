package com.example.naturelife.domain.repository

import com.example.naturelife.domain.model.Route
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {
    suspend fun getRoutes(): Flow<List<Route>>

    suspend fun addRoute(route: Route)
}