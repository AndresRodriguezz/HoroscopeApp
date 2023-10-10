package com.example.horoscopeapp.ui.detail

import androidx.lifecycle.ViewModel
import com.example.horoscopeapp.ui.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(): ViewModel() {

    private var _state = MutableStateFlow<State<Unit>>(State.Loading(false))
    val state: StateFlow<State<Unit>> = _state
}