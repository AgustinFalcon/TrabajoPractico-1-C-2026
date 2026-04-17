package com.agusstkd.ejercicioskotlin.constructores


data class Song(
    val title: String,
    val artist: String,
) {

    fun play() {
        println("Playing $title - $artist")
    }

    fun stop() {
        println("Stopping $title")
    }

}
