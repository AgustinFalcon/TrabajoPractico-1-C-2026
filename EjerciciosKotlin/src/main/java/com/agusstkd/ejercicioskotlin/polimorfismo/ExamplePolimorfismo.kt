package com.agusstkd.ejercicioskotlin.polimorfismo


fun main() {
    val perro: Animal = Dog("Jorge") // Tipo perro
    //perro.doSound()

    val cat: Animal = Cat("PepitoLopez")
    //cat.doSound()

    var animal: Animal? = null
    val input = readln()
    animal = getAnimalByText(input)
    animal.doSound()
}

fun getAnimalByText(input: String): Animal {
    return when(input) {
        "perro" -> Dog("Firulais")
        "gato" -> Cat("Michifus")
        else -> {
            Animal("No creado")
        }
    }
}


open class Animal(val nombre: String, val segundoNombre: String = "Jorge") {
    open fun doSound() {
        println("El animal $nombre hace un sonido")
    }
}

class Dog(nombre: String): Animal(nombre = nombre) {
    override fun doSound() {
        println("El perro $nombre hace ¡Guau!")
    }
}

class Cat(nombre: String): Animal(nombre = nombre) {
    override fun doSound() {
        println("El gato $nombre hace ¡Miau!")
    }
}
