package com.cys.utils

import java.lang.Math.pow

class Longitud(){

    //KILÓMETROS
    fun kilometrosMilimetros(kilometros: Double):Double{
        println("Paso de kilómetros a milímetros")
        return kilometros * 1000000
    }

    fun kilometrosCentimetros(kilometros: Double):Double{
        println("Paso de kilómetros a centímetros")
        return kilometros * 100000
    }

    fun kilometrosDecimetros(kilometros: Double):Double{
        println("Paso de kilómetros a decímetros")
        return kilometros * 10000
    }

    fun kilometrosMetros(kilometros: Double):Double{
        println("Paso de kilómetros a metros")
        return kilometros * 1000
    }


    //METROS
    fun metrosKilometros(metros: Double):Double{
        println("Paso de metros a kilómetros")
        return metros / 1000
    }

    fun metrosCentimetros(metros: Double):Double{
        println("Paso de metros a centímetros")
        return metros * 100
    }

    fun metrosDecimetros(metros: Double):Double{
        println("Paso de metros a decímetros")
        return metros * 10
    }

    fun metrosMilimetros(metros: Double):Double{
        println("Paso de metros a milímetros")
        return metros * 1000
    }

    //DECÍMRTROS
    fun decimetrosKilometros(decimetros: Double):Double{
        println("Paso de decímetros a kilómetros")
        return decimetros / 10000
    }

    fun decimetrosMetros(decimetros: Double):Double{
        println("Paso de decímetros a metros")
        return decimetros / 10
    }

    fun decimetrosCentimetros(decimetros: Double):Double{
        println("Paso de decímetros a centimetros")
        return decimetros * 10
    }

    fun decimetrosMilimetros(decimetros: Double):Double{
        println("Paso de decímetros a milímetros")
        return decimetros * 100
    }


    //CENTÍMETROS
    fun centimetrosKilometros(centimetros: Double):Double{
        println("Paso de centimetros a kilometros")
        return centimetros / 100000
    }

    fun centimetrosMetros(centimetros: Double):Double{
        println("Paso de centimetros a kilometros")
        return centimetros / 100
    }

    fun centimetrosDecimetros(centimetros: Double):Double{
        println("Paso de centimetros a decimetros")
        return centimetros / 10
    }

    fun centimetrosMilimetros(centimetros: Double):Double{
        println("Paso de centimetros a milímetros")
        return centimetros * 10
    }

    //MILÍMETROS
    fun milimetrosKilometros(milimetros: Double):Double{
        println("Paso de milímetros a kilómetros")
        return milimetros / 1000000
    }
    fun milimetrosCentimetros(milimetros: Double):Double{
        println("Paso de milímetros a centimetros")
        return milimetros / 10
    }

    fun milimetrosDecimetros(milimetros: Double):Double{
        println("Paso de milímetros a decimetros")
        return milimetros / 100
    }

    fun milimetrosMetros(milimetros: Double):Double{
        println("Paso de milímetros a metros")
        return milimetros / 1000
    }

}