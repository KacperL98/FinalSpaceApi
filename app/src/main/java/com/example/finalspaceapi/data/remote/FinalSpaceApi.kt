package com.example.finalspaceapi.data.remote

import com.example.finalspaceapi.data.remote.dto.DetailsCharacter
import com.example.finalspaceapi.data.remote.dto.FinalSpaceItemDto
import retrofit2.http.GET
import retrofit2.http.Query

interface FinalSpaceApi {

    @GET("/api/v0/character")
    suspend fun getFinalSpaceList(): List<FinalSpaceItemDto>

    @GET("/api/v0/character/{id}")
    suspend fun getCharacterDetails(@Query("id") id: Int): DetailsCharacter

}