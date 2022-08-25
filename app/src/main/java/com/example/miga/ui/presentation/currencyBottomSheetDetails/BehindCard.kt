package com.example.miga.ui.presentation.currencyBottomSheetDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.miga.R
import com.example.miga.ui.theme.migaColors

@Composable
fun BehindCard(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(R.string.book_the_amount_or_course),
            modifier = Modifier.padding(10.dp),
            color = migaColors.primary)
        Text(text = stringResource(R.string.license_data),
            Modifier.padding(10.dp),
            color = migaColors.primary)
    }
}