package com.example.miga.ui.presentation.bottomSheetUI

import android.util.Log
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.example.miga.ui.theme.bottomSheetShape
import com.example.miga.ui.theme.migaColors
import kotlinx.coroutines.launch


@ExperimentalComposeUiApi
@Composable
fun EditTextComposable(modifier: Modifier, value: Double, icon: ImageVector, visible: Boolean) {
    val focusManager = LocalFocusManager.current
    val valueCurrency = remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    Log.d("TAG", "EditTextComposable: $value")

    if (!visible) {
        LaunchedEffect(key1 = "ClearEditText") {
            coroutineScope.launch {
                valueCurrency.value = ""
            }
        }
    }

    TextField(value = valueCurrency.value,
        onValueChange = { valueCurrency.value = it },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = migaColors.onSecondary,
            focusedIndicatorColor = migaColors.onPrimary,
            unfocusedIndicatorColor = migaColors.onPrimary,
            disabledIndicatorColor = migaColors.onPrimary,
            cursorColor = migaColors.primary),
        singleLine = true, leadingIcon = {
            Icon(imageVector = icon,
                contentDescription = "", tint = migaColors.onBackground)
        }, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ), keyboardActions = KeyboardActions(onDone = {
            focusManager.clearFocus()
        }), modifier = modifier,
        shape = bottomSheetShape,
        textStyle = TextStyle(color = migaColors.primary, fontSize = 20.sp))
}