package com.agusstkd.ejercicioskotlin.interfaces

class Cassete(val name: String): Reproductor, Grabadora {

    override fun play() {
        println("Play $name")
    }

    override fun stop() {
        println("Stop $name")
    }

    override fun playRecorder() {
        println("Grabar $name")
    }

    override fun stopRecorder() {
        println("Detener $name")
    }

}