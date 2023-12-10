package com.example.domains.domain.repository

interface PingRepository {
    suspend fun getPing(): String
}
