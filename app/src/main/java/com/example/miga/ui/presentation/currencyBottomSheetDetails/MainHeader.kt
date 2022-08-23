package com.example.miga.ui.presentation.currencyBottomSheetDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.miga.R
import com.example.miga.ui.theme.migaColors

@Composable
fun MainHeader(modifier: Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = modifier,
            Arrangement.Center,
            Alignment.CenterVertically) {
            Column(modifier = Modifier
                .weight(1f),
                Arrangement.Center,
                Alignment.CenterHorizontally) {
                Text(text = stringResource(R.string.course),
                    fontSize = 30.sp,
                    color = migaColors.surface)
                Text(text = "Золотые \n слитки", textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 20.dp),
                    fontSize = 14.sp, color = migaColors.surface)
            }
            Column(modifier = Modifier
                .weight(1f),
                Arrangement.Center,
                Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = R.drawable.ic_hu_tao),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(corner = CornerSize(50.dp))))
            }
            Column(modifier = Modifier
                .weight(1f),
                Arrangement.Center,
                Alignment.CenterHorizontally) {
                Text(text = stringResource(R.string.currency),
                    fontSize = 30.sp,
                    color = migaColors.surface)
                Text(text = "Национального \nбанка РК",
                    modifier = Modifier.padding(top = 20.dp),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = migaColors.surface)
            }
        }
        Text(text = stringResource(R.string.now_data),
            modifier = Modifier.padding(top = 20.dp),
            fontSize = 14.sp,
            color = migaColors.surface)
    }
}