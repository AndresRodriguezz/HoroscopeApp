package com.example.horoscopeapp.ui.util

sealed class State<out T> {
    data class Loading(val isLoading: Boolean) : State<Nothing>()
    data class Error(val error:String): State<Nothing>()
    data class Success<out T>(val  data: T) : State<T>()
}