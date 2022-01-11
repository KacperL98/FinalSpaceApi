package com.example.finalspaceapi.presentation.final_space_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.finalspaceapi.R
import com.example.finalspaceapi.data.remote.dto.DetailsCharacter
import com.example.finalspaceapi.ui.spacing

@Composable
fun GenderText(detailsCharacter: DetailsCharacter) {
    Row(
        modifier = Modifier.padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Text(
            text = detailsCharacter.species,
            style = MaterialTheme.typography.body2
        )
    }
}
@Composable
fun GenderImage(detailsCharacter: DetailsCharacter) {
    val isMale = detailsCharacter.gender.lowercase() == stringResource(id = R.string.male)
    val isFemale = detailsCharacter.gender.lowercase() == stringResource(id = R.string.female)
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.extraSmall, MaterialTheme.spacing.default),
        horizontalArrangement = Arrangement.End
    ) {
        Image(
            modifier = Modifier.padding(MaterialTheme.spacing.extraSmall),
            painter = painterResource(
                id = when {
                    isMale -> R.drawable.ic_baseline_male_24
                    isFemale -> R.drawable.ic_baseline_female_24
                    else -> R.drawable.ic_baseline_check_box_outline_blank_24
                }
            ),
            contentDescription = null,
        )
    }
}