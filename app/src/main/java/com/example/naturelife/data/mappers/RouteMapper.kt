package com.example.naturelife.data.mappers

import com.example.naturelife.data.model.dto.RouteDomain
import com.example.naturelife.domain.model.Route
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


fun RouteDomain.toRoute() = Route(userId, date, routeImage)

fun Route.toRouteDomain() = RouteDomain(date, userId, routeImage)

fun Flow<List<RouteDomain>>.toRoutesFlow() = map { it.map { route -> route.toRoute() } }