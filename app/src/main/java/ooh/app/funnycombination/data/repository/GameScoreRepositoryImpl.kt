package ooh.app.funnycombination.data.repository

import ooh.app.funnycombination.data.database.dao.UserGameScoreDao
import ooh.app.funnycombination.data.database.entity.UserGameScoreEntity
import ooh.app.funnycombination.domain.model.GameScore
import ooh.app.funnycombination.domain.repository.GameScoreRepository
import javax.inject.Inject

class GameScoreRepositoryImpl @Inject constructor(
    private val userGameScoreDao: UserGameScoreDao
) : GameScoreRepository {
    override suspend fun insertGameScore(score: GameScore) {
        userGameScoreDao.insertGameScore(
            UserGameScoreEntity(
                score = score.score,
                date = score.date
            )
        )

    }

    override suspend fun getGamesScore(): List<GameScore> {
        return userGameScoreDao.getUserScore().map {
            GameScore(
                score = it.score,
                date = it.date
            )
        }
    }

}