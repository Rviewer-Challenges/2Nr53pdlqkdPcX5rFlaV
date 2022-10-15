package com.cys.utils

class Edad() {

    //TIERRA
    fun edadTierraMarte(edadTierra: Int):Int{
        println("Edad Tierra Marte")
        return ((edadTierra * 365) / 687).toInt()
    }

    fun edadTierraVenus(edadTierra: Int):Int{
        println("Edad Tierra Venus")
        return ((edadTierra * 365) / 225).toInt()
    }

    fun edadTierraMercurio(edadTierra: Int):Int{
        println("Edad Tierra Mercurio")
        return ((edadTierra * 365) / 88).toInt()
    }


    //MARTE
    fun edadMarteTierra(edadMarte: Int):Int{
        println("Edad Marte Tierra")
        return ((edadMarte * 687) / 365).toInt()
    }

    fun edadMarteVenus(edadMarte: Int):Int{
        println("Edad Marte Venus")
        return ((edadMarte * 687) / 225).toInt()
    }

    fun edadMarteMercurio(edadMarte: Int):Int{
        println("Edad Marte Mercurio")
        return ((edadMarte * 687) / 88).toInt()
    }


    //VENUS


    //MERCIRIO
}