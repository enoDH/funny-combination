package ooh.app.funnycombination.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import ooh.app.funnycombination.data.repository.GameScoreRepositoryImpl
import ooh.app.funnycombination.domain.repository.GameScoreRepository
import ooh.app.funnycombination.domain.usecase.GetUserGamesScoreUseCase
import ooh.app.funnycombination.domain.usecase.SaveUserGameScoreUseCase

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePasswordRepository(implementation: GameScoreRepositoryImpl): GameScoreRepository {
        return implementation
    }

    @Provides
    fun provideGetUserGamesScoreUseCase(repo: GameScoreRepository): GetUserGamesScoreUseCase {
        return GetUserGamesScoreUseCase(repo)
    }

    @Provides
    fun provideSaveUserGameScoreUseCase(repo: GameScoreRepository): SaveUserGameScoreUseCase {
        return SaveUserGameScoreUseCase(repo)
    }

}