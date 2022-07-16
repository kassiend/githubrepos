package com.example.githubrepos.common

import java.text.SimpleDateFormat
import java.util.*

fun getLastMonthQuery() : String {
    val currentDate: String =
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    return ("created:<$currentDate")
}