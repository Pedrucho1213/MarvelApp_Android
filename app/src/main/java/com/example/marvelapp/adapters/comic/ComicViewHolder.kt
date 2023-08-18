package com.example.marvelapp.adapters.comic

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.databinding.ComicItemViewBinding
import com.example.marvelapp.model.Comic
import com.squareup.picasso.Picasso

class ComicViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ComicItemViewBinding.bind(view)

    fun bind(item: Comic) {
        Picasso.get()
            .load(item.murls?.get(0)?.url)
            .error(R.drawable.portrait_comic)
            .into(binding.comicImage)
        binding.txtTitle.text = item.mtitle
        binding.txtAuthor.text = item.creators?.items?.get(0)?.name ?: ""
    }
}