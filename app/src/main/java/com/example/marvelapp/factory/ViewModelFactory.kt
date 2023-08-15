package com.example.marvelapp.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marvelapp.repository.RetrofitRepository
import com.example.marvelapp.viewModel.RetrofitViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory constructor(private val repository: RetrofitRepository) : ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RetrofitViewModel::class.java)) {
            try {
                return RetrofitViewModel(this.repository) as T
            } catch (e: ClassCastException) {
                throw ClassCastException("Error casting to RetrofitViewModel")
            }
        }
        throw IllegalArgumentException("ViewModel Not Found")
    }

}