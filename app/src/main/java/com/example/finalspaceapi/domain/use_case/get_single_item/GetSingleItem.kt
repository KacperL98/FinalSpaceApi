package com.example.finalspaceapi.domain.use_case.get_single_item

import com.example.finalspaceapi.common.Resource
import com.example.finalspaceapi.data.remote.dto.FinalSpaceItemDto
import com.example.finalspaceapi.domain.repsoitory.FinalSpaceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSingleItem @Inject constructor(
    private val repository: FinalSpaceRepository
) {

    operator fun invoke(): Flow<Resource<List<FinalSpaceItemDto>>> = flow {
        try {
            emit(Resource.Loading<List<FinalSpaceItemDto>>())
            val character = repository.getFinalSpaceList()
            emit(Resource.Success<List<FinalSpaceItemDto>>(character))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<FinalSpaceItemDto>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<FinalSpaceItemDto>>("Couldn't reach server. Check your internet connection."))
        }
    }
}