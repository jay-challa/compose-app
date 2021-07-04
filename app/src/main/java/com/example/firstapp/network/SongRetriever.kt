package com.example.firstapp.network

import com.example.firstapp.model.SongResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


class SongRetriever {
  private val service: Service

  companion object {
    //1
    const val BASE_URL = BASEURL
  }

  init {
    // 2
      val interceptor = HttpLoggingInterceptor()
      interceptor.level = HttpLoggingInterceptor.Level.BODY
      val client = OkHttpClient.Builder()
          .addInterceptor(interceptor).build()
      val retrofit = Retrofit.Builder()
          .client(client)
          // 1
          .baseUrl(BASE_URL)
          //3
          .addConverterFactory(GsonConverterFactory.create())
          .build()
      //4
      service = retrofit.create(Service::class.java)
  }

  suspend fun getList(map: Map<String,String>): SongResponse  {
    return service.retrieveList(map[KEY_K]!!,map[HOST_K]!!)
  }
}