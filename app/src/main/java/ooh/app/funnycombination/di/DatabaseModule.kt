package ooh.app.funnycombination.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ooh.app.funnycombination.data.database.ScoreDatabase
import ooh.app.funnycombination.data.database.dao.UserGameScoreDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ScoreDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            ScoreDatabase::class.java,
            "user_game_score.db"
        ).build()
    }

    @Provides
    fun provideUserGameScoreDao(database: ScoreDatabase): UserGameScoreDao {
        return database.userGameScoreDao()
    }
}