package com.example.miga.ui.presentation.navigationUI

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.miga.R
import com.example.miga.ui.theme.migaColors

@Composable
internal fun Drawer(modifier: Modifier = Modifier, onDestinationClicked: (route: String) -> Unit) {
    Column(modifier
        .fillMaxSize()
        .padding(top = 16.dp)
        .verticalScroll(rememberScrollState())) {
        Row(modifier = Modifier.padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.ic_hu_tao),
                contentDescription = stringResource(R.string.app_icon),
                Modifier.weight(1f)
            )
            Text(text = stringResource(R.string.mark_name),
                modifier = Modifier.weight(3f),
                textAlign = TextAlign.Center,
                color = migaColors.onBackground)
        }
        Divider(Modifier
            .fillMaxWidth()
            .padding(top = 5.dp), color = migaColors.primary)

        screens.forEach { screen ->
            Spacer(Modifier.height(8.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(migaColors.background),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = screen.icon,
                    contentDescription = "",
                    tint = migaColors.primary,
                    modifier = Modifier.padding(start = 16.dp, end = 30.dp))
                Text(text = screen.title,
                    modifier = Modifier
                        .weight(4f)
                        .clickable { onDestinationClicked(screen.route) },
                    color = migaColors.primary,
                    textAlign = TextAlign.Start
                )
                Icon(imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "",
                    tint = migaColors.primary,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}