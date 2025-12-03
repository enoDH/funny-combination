package ooh.app.funnycombination.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ooh.app.funnycombination.data.database.dao.UserGameScoreDao
import ooh.app.funnycombination.data.database.entity.UserGameScoreEntity

@Database(
    entities = [UserGameScoreEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ScoreDatabase : RoomDatabase() {
    abstract fun userGameScoreDao(): UserGameScoreDao
}