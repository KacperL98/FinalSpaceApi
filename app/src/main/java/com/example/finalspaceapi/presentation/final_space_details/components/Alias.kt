package com.example.finalspaceapi.presentation.final_space_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.finalspaceapi.data.remote.dto.DetailsCharacter

@Composable
fun AliasDetails(detailsCharacter: DetailsCharacter) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        Text(text = "Alias", fontWeight = FontWeight.Bold )
        Text(
            text = detailsCharacter.alias.toString()
                .replace("[\\[\\]^,\"]+".toRegex(), "\n\n"),
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic,
        )
    }
}