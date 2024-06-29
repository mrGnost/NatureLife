package com.example.naturelife.data.repository

import com.example.naturelife.data.dao.RoutesDao
import com.example.naturelife.data.mappers.toRouteDomain
import com.example.naturelife.data.mappers.toRoutesFlow
import com.example.naturelife.domain.model.Route
import com.example.naturelife.domain.repository.DatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    val dao: RoutesDao
) : DatabaseRepository {
    override suspend fun getRoutes(): Flow<List<Route>> = withContext(Dispatchers.IO) {
        dao.getRoutes().toRoutesFlow()
    }

    override suspend fun addRoute(route: Route) = withContext(Dispatchers.IO) {
        dao.insertRoutes(route.toRouteDomain())
    }
}