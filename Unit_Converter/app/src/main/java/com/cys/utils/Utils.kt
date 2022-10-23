package com.cys.utils
/**
 * Author:Sara Corrales Santos
 */
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.abs

/**
 * This Class contains useful methods of common form
 */
class Utils() {

    //This function is responsible for formatting the decimals.
    fun decimalFormat(decimal:Double): String {
        val df = DecimalFormat("#.#####")
        df.roundingMode = RoundingMode.UP
        return df.format(decimal)
    }


    //This function is responsible for calculating the days between two dates.
    fun calculoDeDias(dayB:Int, monthB:Int, yearB:Int):Int{
        val c: Calendar = Calendar.getInstance()
        c.setTime(Date())
        var year = c[Calendar.YEAR]
        val month = c[Calendar.MONTH]
        val day = c[Calendar.DAY_OF_MONTH]
        val birthday: Calendar = GregorianCalendar(yearB, monthB, dayB)
        val now: Calendar = GregorianCalendar(year, month, day)

        val end: Long = birthday.timeInMillis
        val start: Long = now.timeInMillis

        val milliseconds: Long = TimeUnit.MILLISECONDS.toMillis(abs(end - start))
        return if (end <= start){
            (milliseconds / 86400000).toInt()
        }else{
            0
        }

    }

}