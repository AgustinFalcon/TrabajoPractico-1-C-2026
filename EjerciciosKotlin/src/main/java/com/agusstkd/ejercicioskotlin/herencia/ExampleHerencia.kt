package com.agusstkd.ejercicioskotlin.herencia

fun main() {
    val perro: Perro = Perro("Firulais", 12, "Callejero")
    perro.hacerSonido()

    val gato = Gato("Michifus", 15, CatColors.YELLOW)
    gato.hacerSonido()
}


open class Animal(val nombre: String, val edad: Int) {
    open fun hacerSonido() {
        println("Tu mascota: $nombre esta haciendo un sonido")
    }
}


class Perro(nombre: String, edad: Int, val raza: String): Animal(nombre = nombre, edad = edad) {
    override fun hacerSonido() {
        println("Tu $nombre $raza hace ¡Guau Guau!")
    }
}


class Gato(nombre: String, edad: Int, val color: CatColors): Animal(nombre = nombre, edad = edad) {
    override fun hacerSonido() {
        val nameColor = when(color) {
            CatColors.BLUE -> "negro"
            CatColors.YELLOW -> "rubio"
            CatColors.RED -> "naranjoso"
            CatColors.WHITE -> "blanco"
            CatColors.GREEN -> "verde"
        }

        println("$nombre color $nameColor esta maullando")
    }
}