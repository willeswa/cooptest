package com.wanjala.cooptest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoopTextInput(
    modifier: Modifier = Modifier,
    hasTrailingIcon: Boolean,
    onTextChange: (String) -> Unit,
    leadingIcon: @Composable () -> Unit,
    value: String,
    keyboardOptions: KeyboardOptions
) {

    if (hasTrailingIcon) {
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth(),
            value = value,
            onValueChange = {
                onTextChange(it)
            },
            keyboardOptions = keyboardOptions,
            trailingIcon = {},
            leadingIcon = {leadingIcon()},

        )
    } else {
        OutlinedTextField(
            modifier = modifier.fillMaxWidth(),
            value = value,
            onValueChange = {
                onTextChange(it)
            },
            keyboardOptions = keyboardOptions,
            leadingIcon = {leadingIcon()}
        )
    }
}