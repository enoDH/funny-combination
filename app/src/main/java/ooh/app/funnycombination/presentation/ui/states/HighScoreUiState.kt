package ooh.app.funnycombination.presentation.ui.states

import ooh.app.funnycombination.domain.model.GameScore

data class HighScoreUiState(
    val results: List<GameScore> = emptyList<GameScore>()
)
