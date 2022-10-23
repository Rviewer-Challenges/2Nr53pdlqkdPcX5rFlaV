package com.cys.utils
/**
 * Author: Sara Corrales Santos
 */


/**
 * This class is responsible for providing the necessary functions
 * for the conversion of times
 */
class Tiempo() {


    //SEGUNDOS
    fun segundosMinutos(segundos:Double):Double{
        println("Paso de segundos a minutos")
        return segundos / 60
    }

    fun segundosHoras(segundos: Double):Double{
        println("Paso de segundos a horas")
        return segundos / 3600
    }

    fun segundosDias(segundos: Double):Double{
        println("Paso de segundos a días ")
        return segundos / 86400
    }

    fun segundosSemanas(segundos: Double):Double{
        println("Paso de segundos a semanas")

        return segundos / 604800
    }


    //MINUTOS
    fun minutosSegundos(minutos:Double):Double{
        println("Paso de minutos a segungos")
        return minutos * 60
    }

    fun minutosHoras(minutos:Double):Double{
        println("Paso de minutos a Horas")
        return minutos / 60
    }
    fun minutosDias(minutos:Double):Double{
        println("Paso de minutos a dias")
        return minutos / 1440
    }

    fun minutosSemanas(minutos:Double):Double{
        println("Paso de minutos a semanas")
        return minutos / 10080
    }


    //HORAS
    fun horasSegundos(horas: Double):Double{
        println("Paso de horas a segungos")
        return horas * 3600
    }

    fun horasMinutos(horas: Double):Double{
        println("Paso de horas a minutos")
        return horas * 60
    }

    fun horasDias(horas: Double):Double{
        println("Paso de horas a dias")
        return horas / 24
    }

    fun horasSemanas(horas: Double):Double{
        println("Paso de horas a semanas")
        return horas / 168
    }

    //DIAS
    fun diasSegundos(dias: Double):Double{
        println("Paso de dias a segundos")
        return dias * 86400
    }

    fun diasMinutos(dias: Double):Double{
        println("Paso de dias a minutos")
        return dias * 1440
    }

    fun diasHoras(dias: Double):Double{
        println("Paso de dias a horas")
        return dias * 24
    }

    fun diasSemanas(dias: Double):Double{
        println("Paso de dias a horas")
        return dias / 7
    }


    //SEMANAS
    fun semanasSegundos(semanas: Double):Double{
        println("Paso de semanas a segundos")
        return semanas * 604800
    }

    fun semanasMinutos(semanas: Double):Double{
        println("Paso de semanas a minutos")
        return semanas * 10080
    }

    fun semanasHoras(semanas: Double):Double{
        println("Paso de semanas a horas")
        return semanas * 168
    }

    fun semanasDias(semanas: Double):Double{
        println("Paso de semanas a dias")
        return semanas * 7
    }

}