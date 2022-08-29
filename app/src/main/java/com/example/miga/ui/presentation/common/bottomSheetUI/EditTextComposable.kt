package com.example.miga.ui.presentation.common.bottomSheetUI

import android.util.Log
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
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
fun EditTextComposable(
    modifier: Modifier,
    variableValue: MutableState<Number>,
    icon: ImageVector,
    visible: Boolean,
    valueStatic: MutableState<Number>,
) {
    val focusManager = LocalFocusManager.current
    val coroutineScope = rememberCoroutineScope()
    val valueString = remember { mutableStateOf("") }

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Log.d("Set15", "EditTextComposable: Work" + valueString.value)
    //  Log.d("Set15", "EditTextComposable: Check$valueCheck")

    if (!visible) {
        LaunchedEffect(key1 = "ClearEditText") {
            coroutineScope.launch {
                valueString.value = ""
            }
        }
    }

    TextField(value = valueString.value,
        onValueChange = { it ->
            if (it.length in 1..6) {
                valueString.value = it.filter { it.isDigit() }
                variableValue.value = it.length
                valueStatic.value = valueString.value.toInt()
            }
            if (it.isEmpty()) {
                valueString.value = ""
            }
            if (isPressed) {
                valueString.value = ""
            }
        },
        interactionSource = interactionSource,
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
        textStyle = TextStyle(color = migaColors.primary, fontSize = 20.sp),
        placeholder = {Text(text = valueStatic.value.toString()) })
}