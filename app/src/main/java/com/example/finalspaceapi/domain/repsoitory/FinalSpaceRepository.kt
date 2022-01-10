package com.example.finalspaceapi.domain.repsoitory

import com.example.finalspaceapi.data.remote.dto.DetailsCharacter
import com.example.finalspaceapi.data.remote.dto.FinalSpaceItemDto

interface FinalSpaceRepository {

    suspend fun getFinalSpaceList(): List<FinalSpaceItemDto>

    suspend fun getCharacterDetails(id: Int): DetailsCharacter
}