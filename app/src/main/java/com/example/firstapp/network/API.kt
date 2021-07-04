package com.example.firstapp.network

const val BASEURL  = "https://shazam.p.rapidapi.com/songs/"
const val LIST = "list-artist-top-tracks?id=40008598&locale=en-US"

const val KEY_K = "x-rapidapi-key"
const val HOST_K = "x-rapidapi-host"

const val KEY_V = "b397a1e05cmsh4094756db9b8521p11c494jsne7ce7c273b19"
const val HOST_V = "shazam.p.rapidapi.com"

fun getHeader(): MutableMap<String, String> {
    var map = mutableMapOf<String, String>()
    map[KEY_K] = KEY_V
    map[HOST_K] = HOST_V
    return map
}
