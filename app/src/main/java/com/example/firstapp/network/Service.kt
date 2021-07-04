package com.example.firstapp.network

import com.example.firstapp.model.SongResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface Service {
  @GET(LIST)
  suspend fun retrieveList(@Header(KEY_K) key_v: String, @Header(HOST_K) host_v: String): SongResponse
}