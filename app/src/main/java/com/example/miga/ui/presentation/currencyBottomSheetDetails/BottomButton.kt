package com.example.miga.ui.presentation.currencyBottomSheetDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.miga.R
import com.example.miga.ui.theme.migaColors

@Composable
fun BottomButton(
    modifier: Modifier,
    buttonTextChange: Int,
    buttonIconChange: ImageVector,
) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
        Text(text = stringResource(buttonTextChange), color = migaColors.surface)
        Icon(
            imageVector = buttonIconChange,
            contentDescription = stringResource(R.string.drop_down),
            tint = migaColors.surface
        )
    }
}