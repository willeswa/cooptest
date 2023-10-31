package com.wanjala.cooptest

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wanjala.cooptest.data.models.AuthBody
import com.wanjala.cooptest.data.service.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoopViewModel @Inject constructor(private val service: ApiService) : ViewModel() {

    val isLoggedIn = MutableStateFlow<Boolean>(false)

    suspend fun login(
        username: String,
        password: String
    ){
        viewModelScope.launch {
            try {
                val result = service.login(AuthBody(
                    username = username,
                    password = password
                ))

                isLoggedIn.value = true

                Log.d("TAG", "result: $result")
            } catch (e: Exception){
                isLoggedIn.value = false
                Log.d("TAG", "error: ${e.message}")
            }
        }
    }


    override fun onCleared() {

        super.onCleared()
    }
}