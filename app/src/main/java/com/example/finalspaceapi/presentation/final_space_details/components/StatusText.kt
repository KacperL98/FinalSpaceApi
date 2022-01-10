package com.example.finalspaceapi.presentation.final_space_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.finalspaceapi.data.remote.dto.DetailsCharacter

@Composable
fun StatusInformation(detailsCharacter: DetailsCharacter) {
    val isAlive = detailsCharacter.status.lowercase() == "alive"
    val isDeceased = detailsCharacter.status.lowercase() == "deceased"

    Column(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(
                        when {
                            isAlive -> Color.Green
                            isDeceased -> Color.Red
                            else -> Color.Gray
                        }
                    )
            )
            Text(
                text = detailsCharacter.status,
                style = MaterialTheme.typography.body2
            )

        }
    }
}