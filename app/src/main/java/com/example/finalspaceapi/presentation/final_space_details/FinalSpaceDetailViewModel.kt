package com.example.finalspaceapi.presentation.final_space_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalspaceapi.common.Constants
import com.example.finalspaceapi.common.Resource
import com.example.finalspaceapi.domain.use_case.get_details_character.GetCharacterDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FinalSpaceDetailViewModel @Inject constructor(
    private val getDetailsItemCharacter: GetCharacterDetails,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(FinalSpaceDetailsState())
    val state: State<FinalSpaceDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.ID_CHARACTER)?.let {
            getDetailsCharacter(it.toInt())
        }
    }

    private fun getDetailsCharacter(id: Int) {
        getDetailsItemCharacter(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = FinalSpaceDetailsState(detailsCharacter = result.data)
                }
                is Resource.Error -> {
                    _state.value = FinalSpaceDetailsState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = FinalSpaceDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}