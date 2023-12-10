package com.example.datas.data.mapper

import com.example.domains.domain.models.Game
import com.example.domains.domain.models.Player
import com.example.domains.domain.models.Team
import com.plcoding.CreateGameMutation

class CreateGameMapper() {

    private fun PlayersToDomain(playerData: CreateGameMutation.Player): Player{
        return Player(
            playerId = playerData.id,
            playerName = playerData.name
        )
    }

    private fun TeamToDomain(teamData: CreateGameMutation.Team): Team{
        return Team(
            teamId = teamData.id,
            players = teamData.players.map { PlayersToDomain(it) }
        )
    }

    fun fromGraphQLResponseToDomain(gameData: CreateGameMutation.CreateGame): Game{
        //val game = gameData.createGame
        return Game(
            gameId = gameData.id,
            teams = gameData.teams.map{TeamToDomain(it)},
            winner = null,

        )
    }
}