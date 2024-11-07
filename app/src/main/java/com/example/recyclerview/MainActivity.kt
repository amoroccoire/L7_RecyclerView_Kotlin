package com.example.recyclerview

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EdificacionAdapter
    private lateinit var viewModel: EdificacionViewModel
    private lateinit var edtFiltro: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        edtFiltro = findViewById(R.id.edtFiltro)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val repository = EdificacionRepository(applicationContext)
        viewModel = EdificacionViewModel(repository)
        viewModel.edificaciones.observe(this, Observer { edificaciones ->
            adapter = EdificacionAdapter(edificaciones)
            recyclerView.adapter = adapter
        })

        viewModel.loadEdificaciones()

        edtFiltro.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val query = s.toString().trim().lowercase()
                viewModel.filterEdificaciones(query)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}