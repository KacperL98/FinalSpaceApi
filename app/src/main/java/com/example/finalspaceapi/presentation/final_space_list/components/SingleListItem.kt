package com.example.finalspaceapi.presentation.final_space_list.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.finalspaceapi.data.remote.dto.FinalSpaceItemDto
import com.example.finalspaceapi.ui.spacing
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun SingleListItem(
    finalSpaceItemDto: FinalSpaceItemDto,
    onItemClick: (FinalSpaceItemDto) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onItemClick(finalSpaceItemDto) }

    )
    { CardItem(finalSpaceItemDto) }
}

@Composable
fun CardItem(finalSpaceItemDto: FinalSpaceItemDto) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(MaterialTheme.spacing.default, color = Color.Black),
        shape = RoundedCornerShape(MaterialTheme.spacing.extraLarge),
        elevation = MaterialTheme.spacing.extraSmall,
    ) {
        Row(modifier = Modifier.height(intrinsicSize = IntrinsicSize.Max)) {
            ImageCharacter(finalSpaceItemDto)
            ShortDescriptionCharacter(finalSpaceItemDto)
        }
    }
}

@Composable
fun ImageCharacter(finalSpaceItemDto: FinalSpaceItemDto) {
    Card(
        shape = RoundedCornerShape(MaterialTheme.spacing.large),
        modifier = Modifier
            .size(MaterialTheme.spacing.extraLargeX),
        elevation = MaterialTheme.spacing.small
    ) {
        GlideImage(
            imageModel = finalSpaceItemDto.imgUrl,
            contentScale = ContentScale.Crop,
            circularReveal = CircularReveal(duration = 250),
        )
    }
}

@Composable
fun ShortDescriptionCharacter(finalSpaceItemDto: FinalSpaceItemDto) {
    val isAlive = finalSpaceItemDto.status.lowercase() == "alive"
    val isDeceased = finalSpaceItemDto.status.lowercase() == "deceased"

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(PaddingValues(16.dp)),
        verticalArrangement = Arrangement.Top,
    ) {
        Text(finalSpaceItemDto.name, fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
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
                text = finalSpaceItemDto.status,
                style = MaterialTheme.typography.body2
            )
        }
    }
}