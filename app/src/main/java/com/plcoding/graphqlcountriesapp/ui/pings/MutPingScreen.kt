package com.plcoding.graphqlcountriesapp.ui.pings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.graphqlcountriesapp.presentation.MutPingViewModel

@Composable
fun MutPingScreen(
    viewModel: MutPingViewModel = hiltViewModel()
) {
    val pingMessageState = viewModel.pingMessage.collectAsState(initial = "No data")
    Box(modifier = Modifier.fillMaxSize()) {
        if (pingMessageState.value == "No data") {
            Button(
                onClick = { viewModel.executePingMutation() },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text("Send Ping Mutation")
            }
        } else {
            Text(
                text = pingMessageState.value,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
