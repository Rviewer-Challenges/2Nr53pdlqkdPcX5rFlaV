package com.cys.utils
/**
 * Author: Sara Corrales Santos
 */


/**
 * This Class is responsible for providing the necessary functions
 * for the calculation of ages on other planets
 */
class Edad() {

    //TIERRA
    fun edadTierraMarte(edadTierra: Double): Double {
        println("Edad Tierra Marte")
        return (edadTierra / 687).toDouble()
    }

    fun edadTierraVenus(edadTierra: Double):Double{
        println("Edad Tierra Venus")
        return (edadTierra / 225).toDouble()
    }

    fun edadTierraMercurio(edadTierra: Double):Double{
        println("Edad Tierra Mercurio")
        return (edadTierra / 88).toDouble()
    }
}