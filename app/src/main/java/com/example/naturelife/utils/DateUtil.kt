package com.example.naturelife.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

object DateUtil {
    private val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy", Locale("ru"))
    private val calendar = Calendar.getInstance()

    fun Date.toDateString(): String = simpleDateFormat.format(this)
}