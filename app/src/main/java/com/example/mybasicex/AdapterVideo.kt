package com.example.mybasicex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterVideo(val xyz: (video) -> Unit) : RecyclerView.Adapter<AdapterVideo.ViewHolder>() {
    class ViewHolder(item_ejemplo: View, val xyz: (video) -> Unit) : RecyclerView.ViewHolder(item_ejemplo) {
        val tvItem1 = item_ejemplo.findViewById<TextView>(R.id.tvCanal)
        val tvItem2 = item_ejemplo.findViewById<TextView>(R.id.tvTitulo)

        fun bind(data: video){
            tvItem1.text = data.Titulo

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