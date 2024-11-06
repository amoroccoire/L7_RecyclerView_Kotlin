package com.example.recyclerview

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class EdificacionRepository(private val context: Context) {
    fun getEdificacionesFromJson(): List<Edificacion> {
        val inputStream = context.resources.openRawResource(R.raw.data)
        val json = inputStream.bufferedReader().use { it.readText() }

        // Parsear el JSON directamente a una lista de Edificacion
        val listType = object : TypeToken<List<Edificacion>>() {}.type
        return Gson().fromJson(json, listType)
    }
}