package com.example.marvelapp.adapters.comic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.model.Comic

class ComicAdapter(private val comic: List<Comic>) : RecyclerView.Adapter<ComicViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ComicViewHolder(layoutInflater.inflate(R.layout.comic_item_view, parent, false))
    }

    override fun getItemCount(): Int = comic.size


    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val item = comic[position]
        holder.bind(item)
    }
}