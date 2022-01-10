package com.example.finalspaceapi.domain.use_case.get_details_character

import com.example.finalspaceapi.common.Resource
import com.example.finalspaceapi.data.remote.dto.DetailsCharacter
import com.example.finalspaceapi.domain.repsoitory.FinalSpaceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacterDetails @Inject constructor(
    private val repository: FinalSpaceRepository
) {
    operator fun invoke(id: Int): Flow<Resource<DetailsCharacter>> = flow {
        try {
            emit(Resource.Loading<DetailsCharacter>())
            val coin = repository.getCharacterDetails(id)
            emit(Resource.Success<DetailsCharacter>(coin))
        } catch (e: HttpException) {
            emit(
                Resource.Error<DetailsCharacter>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<DetailsCharacter>("Couldn't reach server. Check your internet connection."))
        }
    }
}