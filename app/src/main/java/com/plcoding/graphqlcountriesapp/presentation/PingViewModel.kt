package com.plcoding.graphqlcountriesapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domains.domain.use_case.GetPingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PingViewModel @Inject constructor(
    private val getPingUseCase: GetPingUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PingState())
    val state =_state.asStateFlow()

    init {
        Log.d("PingViewModel", "ViewModel initialized")
        viewModelScope.launch {
            _state.update { it.copy(
                isLoading = true
            ) }
            _state.update { it.copy(
                ping  = getPingUseCase.execute(),
                isLoading = false
            ) }
        }
    }

    data class PingState(
        val ping: String? = null,
        val isLoading: Boolean = false,
    )
}
/*package com.plcoding.graphqlcountriesapp.presentation
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.graphqlcountriesapp.domain.GetPingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PingViewModel @Inject constructor(
    private val getPingUseCase: GetPingUseCase
) : ViewModel() {

    private val _state = MutableStateFlow("Loading...") // Initial loading state
    val state = _state

    init {
        viewModelScope.launch {
            getPingUseCase.execute()
                .onEach { pingResponse ->
                    // Update the state with the received pingResponse
                    _state.value = pingResponse
                }
                .collect() // Collect the Flow, this will start receiving updates
        }
    }
}*/
