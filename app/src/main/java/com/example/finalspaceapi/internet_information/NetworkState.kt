package com.example.finalspaceapi.internet_information

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

val Context.currentConnectivityState: NetworkOptions
    get() {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return getCurrentConnectivityState(connectivityManager)
    }

 fun getCurrentConnectivityState(
    connectivityManager: ConnectivityManager
): NetworkOptions {
    val connected = connectivityManager.allNetworks.any { network ->
        connectivityManager.getNetworkCapabilities(network)
            ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            ?: false
    }

    return if (connected) NetworkOptions.IsConnected else NetworkOptions.IsNotConnected
}