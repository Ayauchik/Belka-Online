package com.example.domains.domain.models

data class Game(
    val gameId: String,
    val teams: List<Team>,
    val winner: Winner?,
)
