package ooh.app.funnycombination.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_score")
data class UserGameScoreEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: String = "",
    val score: Int = 0
)
