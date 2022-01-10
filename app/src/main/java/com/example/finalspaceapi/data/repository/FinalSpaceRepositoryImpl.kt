package com.example.finalspaceapi.data.repository

import com.example.finalspaceapi.data.remote.FinalSpaceApi
import com.example.finalspaceapi.data.remote.dto.DetailsCharacter
import com.example.finalspaceapi.data.remote.dto.FinalSpaceItemDto
import com.example.finalspaceapi.domain.repsoitory.FinalSpaceRepository
import javax.inject.Inject

class FinalSpaceRepositoryImpl @Inject constructor(
    private val api: FinalSpaceApi
) : FinalSpaceRepository {
    override suspend fun getFinalSpaceList(): List<FinalSpaceItemDto> {
        return api.getFinalSpaceList()
    }

    override suspend fun getCharacterDetails(id: Int): DetailsCharacter {
        return api.getCharacterDetails(id)
    }

}