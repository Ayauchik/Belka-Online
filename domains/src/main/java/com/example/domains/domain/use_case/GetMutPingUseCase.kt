package com.example.domains.domain.use_case

import com.example.domains.domain.repository.MutPingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow

class GetMutPingUseCase(
    private val mutPingRepository: MutPingRepository
) {
    suspend fun executePingMutation(): Flow<String> = flow {
        emitAll(mutPingRepository.getPing())
    }
}
