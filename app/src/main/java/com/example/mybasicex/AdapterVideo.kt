package com.example.mybasicex

import android.graphics.BitmapFactory
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterVideo(val xyz: (video) -> Unit) : RecyclerView.Adapter<AdapterVideo.ViewHolder>() {
    class ViewHolder(item_ejemplo: View, val xyz: (video) -> Unit) : RecyclerView.ViewHolder(item_ejemplo) {
        val tvTitulo = item_ejemplo.findViewById<TextView>(R.id.tvTitulo)
        val tvCanal = item_ejemplo.findViewById<TextView>(R.id.tvCanal)
        val tvFecha = item_ejemplo.findViewById<TextView>(R.id.tvFecha)
        val tvDuracion = item_ejemplo.findViewById<TextView>(R.id.tvDuracion)
        val imvMiniatura = item_ejemplo.findViewById<ImageView>(R.id.imvMiniatura)

        fun bind(data: video){
            tvTitulo.text = data.Titulo
            tvCanal.text = data.Canal
            tvFecha.text = data.FechaSubida
            tvDuracion.text = data.Duracion.toString()
            imvMiniatura.setImageResource(R.drawable.avatarimg2)

            itemView.setOnClickListener{
                xyz(data)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.fg_item_ex,parent,false)
        return ViewHolder(item,xyz)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(Singleton.listaVideos[position])

        holder.itemView.setOnClickListener{
            xyz(Singleton.listaVideos[position])
        }
    }

    override fun getItemCount(): Int {
        return Singleton.listaVideos.size
    }
}