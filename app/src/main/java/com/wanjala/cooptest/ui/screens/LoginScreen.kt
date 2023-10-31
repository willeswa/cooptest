package com.wanjala.cooptest.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.wanjala.cooptest.CoopViewModel
import com.wanjala.cooptest.R
import com.wanjala.cooptest.ui.theme.White
import com.wanjala.cooptest.ui.components.CoopTextInput
import com.wanjala.cooptest.ui.theme.CoopGreen

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: CoopViewModel = hiltViewModel()
) {

    var password by remember {
        mutableStateOf("")
    }

    var username by remember {
        mutableStateOf("")
    }

    var canSubmit by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(canSubmit){
        if(canSubmit){
            if(password.isBlank() || username.isBlank()){
                //show user error
                return@LaunchedEffect
            }
            viewModel.login(username, password)
            canSubmit = false
        }
    }

    Column(modifier = modifier
        .padding(16.dp)
        .fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = null)
        Spacer(modifier = modifier.padding(8.dp))
        Text(text = "Welcome to Co-op Bank", color = CoopGreen, style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold))
        Spacer(modifier = modifier.padding(16.dp))
        CoopTextInput(hasTrailingIcon = false, onTextChange = {
            username = it
        }, leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = null
            )
        },
            value = username,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        Spacer(modifier = modifier.padding(8.dp))
        CoopTextInput(hasTrailingIcon = true,
            onTextChange = {
                password = it
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = null
                )
            },
            value = password,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ))

        Spacer(modifier = modifier.padding(16.dp))
        Button(
            modifier = modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = CoopGreen
            ),
            onClick = {
                canSubmit = true
            }) {
            Text(
                modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                ,
                text = "Login", color = White)
        }
    }
}