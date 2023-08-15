package com.example.marvelapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marvelapp.api.RetrofitService
import com.example.marvelapp.databinding.ActivityMainBinding
import com.example.marvelapp.factory.ViewModelFactory
import com.example.marvelapp.repository.RetrofitRepository
import com.example.marvelapp.viewModel.RetrofitViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: RetrofitViewModel
    private val retrofitService = RetrofitService.getInstance()


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
                Log.d("Request", "comicList: $it")
            })
            viewModel.errorMessage.observe(this, Observer {
                Log.d("Error", "errorMessage: $it")

            })
            viewModel.getAllComics()
        }

    }
}