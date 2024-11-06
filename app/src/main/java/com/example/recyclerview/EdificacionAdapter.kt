package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class EdificacionAdapter(
    private val edificaciones: List<Edificacion>
) : RecyclerView.Adapter<EdificacionAdapter.EdificacionViewHolder>() {
    class EdificacionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgEdificacion: ImageView = itemView.findViewById(R.id.imageView2)
        val titleEdificacion: TextView = itemView.findViewById(R.id.txtTitle)
        val catEdificacion: TextView = itemView.findViewById(R.id.txtCat)
        val desEdificacion: TextView = itemView.findViewById(R.id.txtDes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EdificacionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return EdificacionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return edificaciones.size
    }

    override fun onBindViewHolder(holder: EdificacionViewHolder, position: Int) {
        val edificacion = edificaciones[position]
        holder.titleEdificacion.text = edificacion.titulo
        holder.catEdificacion.text = edificacion.categoria
        holder.desEdificacion.text = edificacion.descripcion

        // Cargar la imagen
        Glide.with(holder.itemView.context)
            .load(edificacion.imagenUrl)
            .into(holder.imgEdificacion)
    }
}