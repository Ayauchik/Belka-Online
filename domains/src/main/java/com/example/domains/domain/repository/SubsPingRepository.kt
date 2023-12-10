package com.example.domains.domain.repository

import kotlinx.coroutines.flow.Flow

interface SubsPingRepository {
    suspend fun getPing(): Flow<String>
}