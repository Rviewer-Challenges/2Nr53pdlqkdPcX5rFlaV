package com.cys.utils


import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*
import java.util.concurrent.TimeUnit


class Utils() {

    fun decimalFormat(decimal:Double): String {

        val df = DecimalFormat("#.#####")
        df.roundingMode = RoundingMode.UP

        return df.format(decimal)
    }

    fun calculoDeDias(dayB:Int, monthB:Int, yearB:Int):Int{
        val c: Calendar = Calendar.getInstance()
        c.setTime(Date())
        var year = c[Calendar.YEAR]
        val month = c[Calendar.MONTH]
        val day = c[Calendar.DAY_OF_MONTH]
        val birtday: Calendar = GregorianCalendar(yearB, monthB, dayB)
        val now: Calendar = GregorianCalendar(year, month, day)

        val end: Long = birtday.getTimeInMillis()
        val start: Long = now.getTimeInMillis()

        val milliseconds: Long = TimeUnit.MILLISECONDS.toMillis(Math.abs(end - start))




        return (milliseconds / 86400000).toInt()
    }



}