package com.example.marvelapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelapp.adapters.comic.ComicAdapter
import com.example.marvelapp.api.RetrofitService
import com.example.marvelapp.databinding.ActivityMainBinding
import com.example.marvelapp.factory.ViewModelFactory
import com.example.marvelapp.model.Comic
import com.example.marvelapp.repository.RetrofitRepository
import com.example.marvelapp.viewModel.RetrofitViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: RetrofitViewModel
    private val retrofitService = RetrofitService.getInstance()
    private lateinit var adapter: ComicAdapter
    private var comics = mutableListOf<Comic>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnGetData.setOnClickListener {
            viewModel =
                ViewModelProvider(this, ViewModelFactory(RetrofitRepository(retrofitService))).get(
                    RetrofitViewModel::class.java
                )

            viewModel.comicList.observe(this, Observer {
                comics = it.data?.mresults as MutableList<Comic>
                initRecyclerView()
                Log.d("Request", "comicList: $it")
            })
            viewModel.errorMessage.observe(this, Observer {
                Log.d("Error", "errorMessage: $it")

            })
            viewModel.getAllComics()
        }

    }

    private fun initRecyclerView() {
        adapter = ComicAdapter(comics)
        binding.rvComics.layoutManager = LinearLayoutManager(this)
        binding.rvComics.adapter = adapter
    }
}