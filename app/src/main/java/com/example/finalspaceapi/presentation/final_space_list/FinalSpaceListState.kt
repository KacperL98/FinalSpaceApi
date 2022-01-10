package com.example.finalspaceapi.presentation.final_space_list

import com.example.finalspaceapi.data.remote.dto.FinalSpaceItemDto

data class FinalSpaceListState(
    val isLoading: Boolean = false,
    val finalSpace: List<FinalSpaceItemDto> = emptyList(),
    val error: String = ""
)