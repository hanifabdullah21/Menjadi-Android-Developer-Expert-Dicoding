package com.singpaulee.made_dicoding.helper

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object HelperClass {

    /** This function to get year from date
     * with format yyyy-MM-dd
     *
     * @return year (ex:2019)
     * */
    @SuppressLint("SimpleDateFormat")
    fun getYearFromDate(dateString: String): String {
        val formatSdf = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(formatSdf)
        val date = sdf.parse(dateString)
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar.get(Calendar.YEAR).toString()
    }

    /** This function to convert runtime minute to duration
     *
     * @return duration (ex:2j 5m)
     * */
    fun convertDuration(runtime: Int?): String {
        runtime?.let {
            val hour = (runtime / 60)
            val minute = runtime % 60
            return "${hour}j ${minute}m"
        }
        return "-"
    }
}