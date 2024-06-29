package com.example.naturelife.data.model.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class RouteDomain(
    @PrimaryKey val date: Date,
    @ColumnInfo(name = "user_id") val userId: Int,
    @ColumnInfo(name = "route_image_path") val routeImage: String?
)