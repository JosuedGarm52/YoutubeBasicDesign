package com.example.mybasicex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterEjemplo(val xyz: (ejemplo) -> Unit) : RecyclerView.Adapter<AdapterEjemplo.ViewHolder>() {
    class ViewHolder(item_ejemplo: View, val xyz: (ejemplo) -> Unit) : RecyclerView.ViewHolder(item_ejemplo) {
        val tvItem1 = item_ejemplo.findViewById<TextView>(R.id.tvItem1)
        val tvItem2 = item_ejemplo.findViewById<TextView>(R.id.tvItem2)

        fun bind(KEjemplo: ejemplo){
            tvItem1.text = KEjemplo.ejemplo1
            tvItem2.text = KEjemplo.ejemplo2

            itemView.setOnClickListener{
                xyz(KEjemplo)
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
        holder.bind(Singleton.singEjemplo[position])

        holder.itemView.setOnClickListener{
            xyz(Singleton.singEjemplo[position])
        }
    }

    override fun getItemCount(): Int {
        return Singleton.singEjemplo.size
    }
}