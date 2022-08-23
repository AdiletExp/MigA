package com.example.miga.ui.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.miga.R
import com.example.miga.ui.theme.migaColors

@Composable
fun NearestPointsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(migaColors.secondaryVariant)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = stringResource(R.string.second_screen),
            fontWeight = FontWeight.Bold,
            color = migaColors.surface,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}
