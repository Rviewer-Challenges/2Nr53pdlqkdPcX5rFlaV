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
    fun edadVenusTierra(edadVenus: Int):Int{
        println("Edad Venus Tierra")
        return ((edadVenus * 225) / 365).toInt()
    }

    fun edadVenusMarte(edadVenus: Int):Int{
        println("Edad Venus Marte")
        return ((edadVenus * 225) / 687).toInt()
    }

    fun edadVenusMercurio(edadVenus: Int):Int{
        println("Edad Venus Mercurio")
        return ((edadVenus * 225) / 88).toInt()
    }

    //MERCIRIO
    fun edadMercurioTierra(edadMercurio: Int):Int{
        println("Edad Mercurio Tierra")
        return ((edadMercurio * 88) / 365).toInt()
    }

    fun edadMercurioMarte(edadMercurio: Int):Int{
        println("Edad Mercurio Marte")
        return ((edadMercurio * 88) / 687).toInt()
    }

    fun edadMercurioVenus(edadMercurio: Int):Int{
        println("Edad Mercurio Venus")
        return ((edadMercurio * 88) / 225).toInt()
    }
}