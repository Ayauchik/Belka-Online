package com.plcoding.graphqlcountriesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domains.domain.use_case.GetSubsPingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubsPingViewModel @Inject constructor(
    private val getSubsPingUseCase: GetSubsPingUseCase
) : ViewModel() {

    private val _pingState = MutableStateFlow("Loading...") // Initial loading state
    val pingState = _pingState

    init {
        viewModelScope.launch {
            getSubsPingUseCase.execute()
                .collect { pingResponse ->
                    // Update the state with the received pingResponse
                    _pingState.value = pingResponse
                }
        }
    }
}
