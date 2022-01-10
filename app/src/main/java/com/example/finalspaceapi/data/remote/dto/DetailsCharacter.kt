package com.example.finalspaceapi.data.remote.dto


import com.google.gson.annotations.SerializedName

data class DetailsCharacter(
    @SerializedName("abilities")
    val abilities: List<String>,
    @SerializedName("alias")
    val alias: List<String>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("hair")
    val hair: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("img_url")
    val imgUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String
)