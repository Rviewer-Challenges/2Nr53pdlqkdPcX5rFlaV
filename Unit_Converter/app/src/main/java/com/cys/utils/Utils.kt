package com.cys.utils


import java.math.RoundingMode
import java.text.DecimalFormat

class Utils() {

    fun decimalFormat(decimal:Double): String {

        val df = DecimalFormat("#.##########")
        df.roundingMode = RoundingMode.UP

        return df.format(decimal)
    }
}