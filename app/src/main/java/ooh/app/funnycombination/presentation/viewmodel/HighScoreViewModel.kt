package ooh.app.funnycombination.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ooh.app.funnycombination.domain.usecase.GetUserGamesScoreUseCase
import ooh.app.funnycombination.presentation.ui.states.HighScoreUiState
import javax.inject.Inject

@HiltViewModel
class HighScoreViewModel @Inject constructor(
    private val getUserGamesScoreUseCase: GetUserGamesScoreUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HighScoreUiState())
    val uiState: StateFlow<HighScoreUiState> = _uiState.asStateFlow()

    init {
        getHighScoreResults()
    }

    fun getHighScoreResults() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    results = getUserGamesScoreUseCase.getUserGamesScore().sortedBy { it.score }
                        .reversed()
                )
            }
        }
    }
}