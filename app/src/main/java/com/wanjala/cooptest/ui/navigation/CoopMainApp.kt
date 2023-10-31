package com.wanjala.cooptest.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.wanjala.cooptest.R
import com.wanjala.cooptest.ui.screens.DashboardScreen
import com.wanjala.cooptest.ui.screens.LoginScreen

@Composable
fun CoopMainApp(
    modifier: Modifier = Modifier
){
    val isLoggedIn by remember {
        mutableStateOf(false)
    }

   Box(modifier = modifier.fillMaxSize()) {
       Image(
           modifier = modifier.fillMaxSize(),
           contentScale = ContentScale.Crop,
           painter = painterResource(id = R.drawable.asset_1), contentDescription = null)
       Column {
           if(isLoggedIn){
               DashboardScreen()
           } else {
               LoginScreen()
           }
       }
   }
}