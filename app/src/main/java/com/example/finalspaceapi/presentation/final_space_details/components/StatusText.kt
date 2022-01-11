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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.finalspaceapi.R
import com.example.finalspaceapi.data.remote.dto.DetailsCharacter
import com.example.finalspaceapi.ui.spacing

@Composable
fun StatusInformation(detailsCharacter: DetailsCharacter) {
    val isAlive = detailsCharacter.status.lowercase() == stringResource(id = R.string.alive)
    val isDeceased = detailsCharacter.status.lowercase() == stringResource(id = R.string.deceased)

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
                    .padding(MaterialTheme.spacing.extraSmall)
                    .size(MaterialTheme.spacing.extraSmall)
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