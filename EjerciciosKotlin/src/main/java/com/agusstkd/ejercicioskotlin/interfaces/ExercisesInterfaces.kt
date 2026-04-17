package com.agusstkd.ejercicioskotlin.interfaces

fun main() {
    val cd = CD()
    cd.play()
    cd.playRecorder()
    println("----------")
    cd.stop()
    cd.stopRecorder()
    println("----------")
    println("----------")
    println("----------")
    println("----------")
    println("----------")
    println("----------")

    val cassete = Cassete("Compilado")
    cassete.play()
    cassete.playRecorder()
    println("----------")
    cassete.stop()
    cassete.stopRecorder()

}
