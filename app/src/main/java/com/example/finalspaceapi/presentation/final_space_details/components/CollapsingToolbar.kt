package com.example.finalspaceapi.presentation.final_space_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalspaceapi.R
import com.example.finalspaceapi.data.remote.dto.DetailsCharacter
import com.example.finalspaceapi.navigation.Screen
import com.example.finalspaceapi.ui.spacing
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
internal fun CollapsingToolbar(detailsCharacter: DetailsCharacter, navController: NavController) {
    val state = rememberCollapsingToolbarScaffoldState()
    CollapsingToolbarScaffold(
        modifier = Modifier
            .fillMaxSize(),
        state = state,
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        toolbar = {
            val textSize = (18 + (30 - 18) * state.toolbarState.progress).sp

            Box(
                modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .fillMaxWidth()
                    .height(MaterialTheme.spacing.othersX)
                    .pin()
            )
            Text(
                text = detailsCharacter.name,
                modifier = Modifier
                    .road(Alignment.CenterStart, Alignment.BottomEnd)
                    .padding(
                        MaterialTheme.spacing.others,
                        MaterialTheme.spacing.medium,
                        MaterialTheme.spacing.medium,
                        MaterialTheme.spacing.medium
                    ),
                color = Color.White,
                fontSize = textSize
            )

            Image(
                modifier = Modifier
                    .pin()
                    .padding(16.dp)
                    .clickable { navController.navigate(Screen.SpaceListScreen.route) },
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                contentDescription = null
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            item {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colors.primary)
                        .padding(24.dp)
                ) {
                    GlideImage(
                        imageModel = detailsCharacter.imgUrl,
                        contentScale = ContentScale.Crop,
                        circularReveal = CircularReveal(duration = 250),
                        modifier = Modifier
                            .clip(CircleShape)

                    )
                    Spacer(modifier = Modifier.padding(MaterialTheme.spacing.small))
                }
                GenderImage(detailsCharacter)
            }
            item {
                CharacterDetailsRow(
                    label = "Status",
                    separator = {
                        StatusInformation(detailsCharacter)
                    }
                )
                CharacterDetailsRow(
                    label = "Gender",
                    separator = {
                        GenderText(detailsCharacter)
                    }
                )
            }

            item {

                CharacterDetailsRow(
                    label = "Abilities",
                    separator = {
                        Image(
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable { navController.navigate(Screen.SpaceListScreen.route) },
                            painter = painterResource(id = R.drawable.ic_baseline_star_24),
                            contentDescription = null
                        )
                    }
                )

                Spacer(modifier = Modifier.height(15.dp))
                LazyRow(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(detailsCharacter.abilities) {
                        Abilities(tag = it)
                    }
                }
            }
            item {
                AliasDetails(detailsCharacter)
            }
        }
    }
}