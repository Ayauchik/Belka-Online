package com.example.datas.data.mapper

import com.example.domains.domain.models.Game
import com.example.domains.domain.models.Player
import com.example.domains.domain.models.Team
import com.example.domains.domain.models.Winner
import com.plcoding.CreateGameMutation
import com.plcoding.OnGameStartSubscription
import com.plcoding.StartGameMutation


fun mapGraphQLResponseToTeam(teamData: CreateGameMutation.Team): Team {
    return Team(
        teamId = teamData.id,
        players = teamData.players.map { mapGraphQLResponseToPlayer(it) }
    )
}

fun mapGraphQlResponseToWinner(winnerData: CreateGameMutation.Winner) : Winner {
    return Winner(
        teamId = winnerData.id,
        players = winnerData.players.map { mapGraphQLResponseToPlayer1(it) }
    )
}

fun mapGraphQLResponseToPlayer(playerData: CreateGameMutation.Player): Player {
    return Player(
        playerId = playerData.id,
        playerName = playerData.name
    )
}

fun mapGraphQLResponseToPlayer1(playerData: CreateGameMutation.Player1): Player {
    return Player(
        playerId = playerData.id,
        playerName = playerData.name
    )
}

fun mapGraphQLResponseToGame(response: CreateGameMutation.CreateGame): Game {
    return Game(
        gameId = response.id,
        teams = response.teams.map { mapGraphQLResponseToTeam(it) },
        winner = response.winner?.let { mapGraphQlResponseToWinner(it) },
    )
}

