package com.example.finalspaceapi.presentation.final_space_details

import com.example.finalspaceapi.data.remote.dto.DetailsCharacter


data class FinalSpaceDetailsState(
    val isLoading: Boolean = false,
    val detailsCharacter: DetailsCharacter? = null,
    val error: String = ""
)