package com.example.marvelapp.api

import com.example.marvelapp.environment.Env
import com.example.marvelapp.model.ComicDataWrapper
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.math.BigInteger
import java.security.MessageDigest
import retrofit2.http.Query
import java.time.Instant

interface RetrofitService {
    @GET("comics")
    fun getAllComics(
        @Query("ts") timestamp: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("format") format: String = "comic",
        @Query("formatType") formatType: String = "comic",
        @Query("dateDescriptor") dateDescriptor: String = "lastWeek",
        @Query("limit") limit: Int = 5
    ): Call<ComicDataWrapper>

    companion object {
        private var retrofitService: RetrofitService? = null
        var publicKey = Env.PUBLIC_KEY
        var privateKey = Env.PRIVATE_KEY
        var ts = Instant.now().epochSecond.toString()

        fun calculateMD5Hash(ts: String, privateKey: String, publicKey: String): String {
            val input = ts + privateKey + publicKey
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray()))
                .toString(16)
                .padStart(32, '0')
        }

        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(Env.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}