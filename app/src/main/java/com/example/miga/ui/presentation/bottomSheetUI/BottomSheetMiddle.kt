package com.example.miga.ui.presentation.bottomSheetUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.miga.R
import com.example.miga.ui.theme.migaColors

@Composable
internal fun BottomSheetMiddle(textNumber: Double) {
    Text(text = stringResource(R.string.according_to_the_course),
        modifier = Modifier.padding(start = 10.dp),
        color = migaColors.onBackground)
    Text(text = textNumber.toString(),
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        color = migaColors.primary, modifier = Modifier.padding(start = 10.dp))
    Row(modifier = Modifier.padding(start = 30.dp,
        top = 10.dp,
        end = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = stringResource(R.string.buy),
            modifier = Modifier
                .weight(1f)
                .padding(end = 15.dp),
            textAlign = TextAlign.Center,
            color = migaColors.onBackground)
        Text(text = stringResource(R.string.is_required),
            modifier = Modifier
                .weight(1f)
                .padding(start = 15.dp),
            textAlign = TextAlign.Center,
            color = migaColors.onBackground)
    }
}