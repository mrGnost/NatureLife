package com.example.naturelife.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class PeriodicWeatherWorker(ctx: Context, params: WorkerParameters) : CoroutineWorker(ctx, params) {
    override suspend fun doWork(): Result {
        TODO("Not yet implemented")
    }

    companion object {
        const val TAG = "PeriodicWeatherWorker"
    }
}