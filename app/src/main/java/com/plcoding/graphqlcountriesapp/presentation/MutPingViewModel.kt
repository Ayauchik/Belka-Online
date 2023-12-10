package com.plcoding.graphqlcountriesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domains.domain.use_case.GetMutPingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MutPingViewModel @Inject constructor(
    private val getMutPingUseCase: GetMutPingUseCase
) : ViewModel() {

    private val _pingMessage = MutableStateFlow("No data") // Initial state
    val pingMessage = _pingMessage.asStateFlow()

    fun executePingMutation() {
        viewModelScope.launch {
            getMutPingUseCase.executePingMutation().collect { result ->
                _pingMessage.value = result
            }
        }
    }
}
