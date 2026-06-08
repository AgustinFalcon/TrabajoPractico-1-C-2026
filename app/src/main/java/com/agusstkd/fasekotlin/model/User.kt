package com.agusstkd.fasekotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "nombre")
    val name: String,

    @ColumnInfo(name = "descripcion")
    val description: String,

    @ColumnInfo(name = "edad")
    val age: Int,

) : Serializable