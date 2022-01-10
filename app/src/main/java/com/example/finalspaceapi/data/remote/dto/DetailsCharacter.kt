package com.example.finalspaceapi.data.remote.dto


import com.google.gson.annotations.SerializedName

data class DetailsCharacter(
    @SerializedName("abilities")
    val abilities: List<String>,
    @SerializedName("alias")
    val alias: List<String>,
    val gender: String,
    val hair: String,
    val id: Int,
    @SerializedName("img_url")
    val imgUrl: String,
    val name: String,
    val origin: String,
    val species: String,
    val status: String
)