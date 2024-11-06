package com.example.recyclerview

import com.google.gson.annotations.SerializedName

data class Edificacion(
    @SerializedName("url") val imagenUrl: String,
    val titulo: String,
    val categoria: String,
    val descripcion: String
)
