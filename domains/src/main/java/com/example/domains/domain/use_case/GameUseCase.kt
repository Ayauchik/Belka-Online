package com.example.domains.domain.use_case

import com.example.domains.domain.models.Game
import com.example.domains.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow

class GameUseCase(
    private val gameRepository: GameRepository
) {
    suspend fun createGame(): Flow<Game> = flow{
        emitAll(gameRepository.createGame())
    }

    suspend fun startGame(gameId: String): Flow<Boolean> = flow{
        emitAll(gameRepository.startGame(gameId))
    }

    suspend fun onGameStart(gameId: String): Flow<Game> = flow{
        emitAll(gameRepository.onGameStart(gameId))
    }
}