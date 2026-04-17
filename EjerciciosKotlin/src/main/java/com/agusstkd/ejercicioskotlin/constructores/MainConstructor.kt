package com.agusstkd.ejercicioskotlin.constructores

fun main() {
    /*var pepe: Pepe? = null

    pepe = Pepe()
    //pepe.setName("Pepe")
    println(pepe)

    pepe.toString()*/

    val nombre = readln()

    val song1 = Song(
        title = "Camisa Negra",
        artist = "Juanes"
    )

    val song2 = Song(
        title = "Is this love",
        artist = "Bob Marley"
    )

    val song3 = Song(
        title = "Billie Jean",
        artist = "Michael Jackson"
    )


    song1.play()
    song2.play()
    song3.play()

    println("-----------------$nombre------------------")
    println("-----------------$nombre-------------------")
    println("-----------------$nombre-------------------")

    song1.stop()
    song2.stop()
    song3.stop()
}


class Pepe() {
    var nombre: String = ""

    init {
        nombre = "PEPE"
    }

    /*constructor(
        nombre: String

    ) {
        this.nombre = nombre
    }*/

    fun getName(): String {
        return nombre
    }

    fun setName(name: String) {
        this.nombre = name
    }

    override fun toString(): String {
        return "Pepe(nombre=$nombre)"
    }
}
