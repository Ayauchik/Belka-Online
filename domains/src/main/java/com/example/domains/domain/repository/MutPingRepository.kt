package com.example.domains.domain.repository

import kotlinx.coroutines.flow.Flow

interface MutPingRepository {
    suspend fun getPing(): Flow<String>
}