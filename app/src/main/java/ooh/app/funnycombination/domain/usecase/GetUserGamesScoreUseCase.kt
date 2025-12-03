package ooh.app.funnycombination.domain.usecase

import jakarta.inject.Inject
import ooh.app.funnycombination.domain.model.GameScore
import ooh.app.funnycombination.domain.repository.GameScoreRepository

class GetUserGamesScoreUseCase @Inject constructor(
    private val gameScoreRepository: GameScoreRepository
) {
    suspend fun getUserGamesScore(): List<GameScore> {
        return gameScoreRepository.getGamesScore()
    }
}