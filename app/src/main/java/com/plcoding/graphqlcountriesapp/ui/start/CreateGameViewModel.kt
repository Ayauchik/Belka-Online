package com.plcoding.graphqlcountriesapp.ui.start

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domains.domain.models.Team
import com.example.domains.domain.models.Winner
import com.example.domains.domain.use_case.GameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateGameViewModel @Inject constructor(
    private val gameUseCase: GameUseCase
): ViewModel() {
    private val _state = MutableStateFlow(GameState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            gameUseCase.createGame().collect{createdGame->
                Log.e("creatingGame", "${createdGame.gameId}")

                gameUseCase.startGame(createdGame.gameId).collect{isStarted ->
                    Log.e("startingGame", "$isStarted")

                    if(isStarted){
                     /*   _state.update {
                            it.copy(
                                gameId = createdGame.gameId,
                                teams = createdGame.teams,
                                winner = createdGame.winner,
                                isLoading = false
                            )
                        }*/
                        gameUseCase.onGameStart(createdGame.gameId).collect{game ->
                            Log.e("onGameStart", "${game.gameId} + ${game.teams}")
                            _state.update {
                                it.copy(
                                    gameId = game.gameId,
                                    teams = game.teams,
                                    winner = game.winner,
                                    isLoading = false
                                )
                            }
                        }
                    }else{
                        throw Exception("Failed to start game")
                    }
                }
            }
        }
    }

    data class GameState(
        var gameId: String? = null,
        var teams: List<Team> = emptyList(),
        var winner: Winner? = null,
        var isLoading: Boolean = false,
    )
}