package com.agusstkd.ejercicioskotlin.interfaces.comunicacion_entre_clases

fun main() {
    val claseA = ClaseA()
    claseA.iniciarComunicacion()
    claseA.borrar()
}



class ClaseB(private val comunicador: Comunicador) {
    var message = ""

    fun realizarAccion() {
        message = "¡ESTA ACCION ES REALIZADA DESDE LA CLASE B!"
        comunicador.enviarMensaje(mensaje = message)
    }

    fun borrar() {
        message = ""
        comunicador.borrarMensaje()
    }
}

class ClaseA : Comunicador {
    override fun enviarMensaje(mensaje: String) {
        println("ClaseA recibio: $mensaje")
    }

    fun iniciarComunicacion() {
        val claseb = ClaseB(comunicador = this)
        claseb.realizarAccion()
    }

    fun borrar() {
        val claseb = ClaseB(comunicador = this)
        claseb.borrar()
    }

    override fun borrarMensaje() {
        println("Borro el mensaje")
    }
}

interface Comunicador {
    fun enviarMensaje(mensaje: String)
    fun borrarMensaje()
}