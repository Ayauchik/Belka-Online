package com.plcoding.graphqlcountriesapp

import GameInfoScreen
import PingScreen
import SubsPingScreen
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import com.plcoding.graphqlcountriesapp.presentation.PingViewModel
import com.plcoding.graphqlcountriesapp.presentation.SubsPingViewModel
import com.plcoding.graphqlcountriesapp.ui.pings.MutPingScreen
import com.plcoding.graphqlcountriesapp.ui.theme.GraphQlCountriesAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphQlCountriesAppTheme {
                /*val viewModel = hiltViewModel<PingViewModel>()
                val state by viewModel.state.collectAsState()
                PingScreen(state = state)*/
               /* val viewModel = hiltViewModel<SubsPingViewModel>()
                SubsPingScreen(viewModel = viewModel)*/
                GameInfoScreen()
                //MutPingScreen()
            }
        }
    }
}