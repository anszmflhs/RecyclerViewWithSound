package com.example.listbuah

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BuahAdapter (val namaBuah : Array<String>, val gambarBuah : Array<Int>, val suaraBuah : Array<Int>) : RecyclerView.Adapter<BuahAdapter.ViewHolder>() {
    class ViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        val txtBuah = view.findViewById<TextView>(R.id.txt_buah)
        val imgBuah = view.findViewById<ImageView>(R.id.img_buah)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_buah, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtBuah.text = namaBuah[position]
        holder.imgBuah.setImageResource(gambarBuah[position])
        holder.itemView.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(holder.itemView.context,suaraBuah[position])
            mediaPlayer.start()
        }
    }

    override fun getItemCount(): Int {
        return namaBuah.size
    }
}