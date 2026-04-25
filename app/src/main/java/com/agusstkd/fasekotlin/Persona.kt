package com.agusstkd.fasekotlin

import java.io.Serializable

data class Persona(
    val name: String,
    val pass: String,
    val color: Colors
): Serializable
