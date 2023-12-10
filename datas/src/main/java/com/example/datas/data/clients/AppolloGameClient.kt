package com.example.datas.data.clients

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.example.datas.data.mapper.mapGraphQLResponseToGame
import com.example.datas.data.mapper.mapGraphQLResponseToOnGameStart
import com.example.domains.domain.models.Game
import com.example.domains.domain.models.Team
import com.example.domains.domain.repository.GameRepository
import com.plcoding.CreateGameMutation
import com.plcoding.OnGameStartSubscription
import com.plcoding.StartGameMutation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single

class AppolloGameClient(
    private val apolloClient: ApolloClient
) : GameRepository{

      override suspend fun createGame(): Flow<Game> {
          return flow {
              try {
                  val response = apolloClient.mutation(CreateGameMutation()).execute()
                  val createGame = response.data?.createGame

                  emit(mapGraphQLResponseToGame(createGame!!))

              }catch (e:Exception){
                  emit(Game(gameId = "", teams = listOf(), winner = null))
              }
          }
      }

    override suspend fun startGame(gameId: String): Flow<Boolean> {
        return flow {
            try {
                val mutation = StartGameMutation(gameId = gameId)
                val response = apolloClient.mutation(mutation).execute()
                val startGame = response.data?.startGame ?: throw Exception("Start game failed")
                emit(startGame.success!!)
            }catch (e:Exception){
                emit(false)
            }
        }
    }

    override suspend fun onGameStart(gameId: String): Flow<Game> {
        Log.e("onGameStart", "$gameId")
        val response = apolloClient.subscription(OnGameStartSubscription(gameId))
           .toFlow()
            .single()
            .data?.onGameStart
//           .map {response ->
//               val gameData = response.data?.onGameStart
//               Log.e("onGameStart", "${gameData?.id}")
//            if(gameData!= null){
//                mapGraphQLResponseToOnGameStart(gameData)
//            }else{
//                throw Exception("apollo game client exception")
//            }
//        }
        Log.e("OnGameStartResponse", "${response?.id}")
        return flow {
            mapGraphQLResponseToOnGameStart(response!!)
        }
    }


}
