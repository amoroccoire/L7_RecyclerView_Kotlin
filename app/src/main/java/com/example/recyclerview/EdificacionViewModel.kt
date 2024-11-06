package com.example.recyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class EdificacionViewModel(private val repository: EdificacionRepository) : ViewModel() {
    private val _edificaciones = MutableLiveData<List<Edificacion>>()
    val edificaciones: LiveData<List<Edificacion>> get() = _edificaciones

    fun loadEdificaciones() {
        _edificaciones.value = repository.getEdificacionesFromJson()
    }
}