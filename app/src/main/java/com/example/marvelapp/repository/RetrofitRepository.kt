package com.example.marvelapp.repository

import com.example.marvelapp.api.RetrofitService

class RetrofitRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllComics(timestamp: String, apiKey: String, hash: String) =
        retrofitService.getAllComics(timestamp, apiKey, hash)
}