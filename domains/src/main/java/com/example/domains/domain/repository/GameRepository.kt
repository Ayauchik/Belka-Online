package com.example.domains.domain.repository

import com.example.domains.domain.models.Game
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    suspend fun createGame(): Flow<Game>
    suspend fun startGame(gameId: String): Flow<Boolean>
    suspend fun onGameStart(gameId: String): Flow<Game>

}