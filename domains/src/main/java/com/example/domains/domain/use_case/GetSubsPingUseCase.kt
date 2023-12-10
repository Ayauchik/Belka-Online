package com.example.domains.domain.use_case

import com.example.domains.domain.repository.SubsPingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow

class GetSubsPingUseCase(
    private val subsPingRepository: SubsPingRepository
) {
    suspend fun execute(): Flow<String> = flow {
        emitAll(subsPingRepository.getPing())
    }
}