package com.udea.sebastian.osorios.deals.model.server

import com.google.gson.GsonBuilder
import com.udea.sebastian.osorios.deals.model.Deals
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {


    @GET("/getOffers")
    fun getFeedDeals(@Query("API_KEY") apiKey: String, @Query("format") format : String): Call<Deals>

    companion object{
        val urlApi = "http://feed.linkmydeals.com"

        fun create(): ApiService {
            val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()



            val retrofit = Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}