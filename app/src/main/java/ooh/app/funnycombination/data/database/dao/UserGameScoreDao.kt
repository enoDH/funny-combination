package ooh.app.funnycombination.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ooh.app.funnycombination.data.database.entity.UserGameScoreEntity

@Dao
interface UserGameScoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameScore(score: UserGameScoreEntity)

    @Query("SELECT * FROM game_score")
    suspend fun getUserScore(): List<UserGameScoreEntity>
}