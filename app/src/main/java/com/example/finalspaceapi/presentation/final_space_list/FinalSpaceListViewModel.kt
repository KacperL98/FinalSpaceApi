package com.example.finalspaceapi.presentation.final_space_list

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalspaceapi.common.Resource
import com.example.finalspaceapi.data.remote.dto.FinalSpaceItemDto
import com.example.finalspaceapi.domain.use_case.get_single_item.GetSingleItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FinalSpaceListViewModel @Inject constructor(
    private val getSingleItem: GetSingleItem
) : ViewModel() {

    private val _state = mutableStateOf(FinalSpaceListState())
    val state: State<FinalSpaceListState> = _state

    private val _isRefreshing = MutableStateFlow(false)

    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    init {
        getListCharacter()
    }

    private fun getListCharacter() {
        getSingleItem().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value =
                        FinalSpaceListState(finalSpace = (result.data as List<FinalSpaceItemDto>),
                        isLoading = false)
                }
                is Resource.Error -> {
                    _state.value = FinalSpaceListState(
                        error = result.message ?: "An unexpected error occured",
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    _state.value = FinalSpaceListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun refresh() {
        viewModelScope.launch {
            _isRefreshing.emit(true)
            delay(2000)
            _isRefreshing.emit(false)
        }
    }
}
