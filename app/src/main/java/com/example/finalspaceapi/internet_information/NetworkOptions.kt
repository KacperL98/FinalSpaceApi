package com.example.finalspaceapi.internet_information

sealed class NetworkOptions {
    object IsConnected : NetworkOptions()
    object IsNotConnected : NetworkOptions()
}