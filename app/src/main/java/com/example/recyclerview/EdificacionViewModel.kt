package com.example.recyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class EdificacionViewModel(private val repository: EdificacionRepository) : ViewModel() {
    private val _edificaciones = MutableLiveData<List<Edificacion>>()
    val edificaciones: LiveData<List<Edificacion>> get() = _edificaciones

    private var fullList: List<Edificacion> = listOf()  // Guardamos la lista completa

    fun loadEdificaciones() {
        fullList = repository.getEdificacionesFromJson()  // Cargar los datos completos
        _edificaciones.value = fullList
    }

    fun filterEdificaciones(query: String) {
        if (query.isEmpty()) {
            _edificaciones.value = fullList
        } else {
            val filteredList = fullList.filter { edificacion ->
                edificacion.titulo.lowercase().contains(query) ||
                        edificacion.descripcion.lowercase().contains(query) ||
                        edificacion.categoria.lowercase().contains(query)
            }
            _edificaciones.value = filteredList
        }
    }
}