package com.example.githubrepos.common

import java.text.SimpleDateFormat
import java.util.*

fun getLastMonthQuery() : String {
    val cal = Calendar.getInstance()
    cal.add(Calendar.DATE, -30)
    val dateBefore30Days = cal.time

    val currentDate: String =
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(dateBefore30Days)
    return ("created:>$currentDate")
}