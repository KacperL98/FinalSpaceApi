package com.example.finalspaceapi.presentation.final_space_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalspaceapi.common.Resource
import com.example.finalspaceapi.data.remote.dto.FinalSpaceItemDto
import com.example.finalspaceapi.domain.use_case.get_single_item.GetSingleItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FinalSpaceListViewModel @Inject constructor(
    private val getSingleItem: GetSingleItem
) : ViewModel() {

    private val _state = mutableStateOf(FinalSpaceListState())
    val state: State<FinalSpaceListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getSingleItem().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value =
                        FinalSpaceListState(finalSpace = (result.data as List<FinalSpaceItemDto>))
                }
                is Resource.Error -> {
                    _state.value = FinalSpaceListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = FinalSpaceListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}