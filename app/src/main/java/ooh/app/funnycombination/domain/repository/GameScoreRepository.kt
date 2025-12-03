package ooh.app.funnycombination.domain.repository

import ooh.app.funnycombination.domain.model.GameScore

interface GameScoreRepository {
    suspend fun insertGameScore(score: GameScore)
    suspend fun getGamesScore(): List<GameScore>
}