package com.example.firstapp

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.M)
fun isNetworkConnected(context: Context): Boolean {
    //1
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    //2
    val activeNetwork = connectivityManager.activeNetwork
    //3
    val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
    //4
    return networkCapabilities != null &&
            networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}



enum class Type {
    COVER,
    HORIZONTAL,
    VERTICAL
}