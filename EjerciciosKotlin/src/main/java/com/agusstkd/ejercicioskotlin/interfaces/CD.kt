package com.agusstkd.ejercicioskotlin.interfaces


class CD : Reproductor, Grabadora {
    override fun play() {
        println("Puso play en el CD")
    }

    override fun stop() {
        println("Detuvo la musica en el CD")
    }

    override fun playRecorder() {
        println("Puso a grabar en el CD")
    }

    override fun stopRecorder() {
        println("Detuvo la grabacion en el CD")
    }
}