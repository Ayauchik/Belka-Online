package com.example.datas.data.clients

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.example.datas.data.mapper.CreateGameMapper
import com.example.domains.domain.models.Game
import com.example.domains.domain.repository.GameRepository
import com.plcoding.CreateGameMutation
import kotlinx.coroutines.flow.Flow

/*
class GameRepositoryImpl(
    private val apolloClient: ApolloClient,
    private val createGameMapper: CreateGameMapper
):GameRepository {
    override suspend fun createGame(): Game {
        val response = apolloClient.mutation(CreateGameMutation()).execute()
        val createdGame = response.data?.createGame ?: throw Exception("Create game failed")
        return createGameMapper.fromGraphQLResponseToDomain(createdGame)
    }

    override suspend fun startGame(gameId: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun onGameStart(gameId: String): Flow<Game> {
        TODO("Not yet implemented")
    }
}*/
