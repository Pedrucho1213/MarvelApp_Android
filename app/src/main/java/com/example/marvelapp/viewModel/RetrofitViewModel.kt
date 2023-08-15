package com.example.marvelapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelapp.api.RetrofitService
import com.example.marvelapp.model.ComicDataWrapper
import com.example.marvelapp.repository.RetrofitRepository
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class RetrofitViewModel(private val repository: RetrofitRepository) : ViewModel() {

    val comicList: MutableLiveData<ComicDataWrapper> = MutableLiveData()
    val errorMessage = MutableLiveData<String>()

    fun getAllComics() {
        val timestamp = RetrofitService.ts
        val publicKey = RetrofitService.publicKey
        val privateKey = RetrofitService.privateKey
        val hash = RetrofitService.calculateMD5Hash(timestamp, privateKey, publicKey)

        val response = repository.getAllComics(timestamp, publicKey, hash)
        response.enqueue(object : Callback<ComicDataWrapper> {
            override fun onResponse(
                call: Call<ComicDataWrapper>,
                response: Response<ComicDataWrapper>
            ) {
                comicList.postValue(response.body())
            }

            override fun onFailure(call: Call<ComicDataWrapper>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}