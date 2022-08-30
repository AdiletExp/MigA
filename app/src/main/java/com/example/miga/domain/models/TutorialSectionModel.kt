package com.example.miga.domain.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class TutorialSectionModel(
    val title: String,
    val action: @Composable (() -> Unit)? = null,
    val description: String,
    val tags: List<String> = listOf(),
    val tagColor: Color = Color.Green,
    var expanded: Boolean = false
)
