package com.wisnuwahyudi.aplikasikuis.kategorisoal.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {
    companion object{
        val baseUrl = "http://192.168.1.4/eurekatest/"
          fun getNetwork() : IService {
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build()

              return retrofit.create(IService::class.java)
          }
    }
}