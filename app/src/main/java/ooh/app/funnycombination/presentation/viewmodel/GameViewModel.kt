package ooh.app.funnycombination.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ooh.app.funnycombination.domain.model.GameScore
import ooh.app.funnycombination.domain.usecase.GenerateCombinationUseCase
import ooh.app.funnycombination.domain.usecase.GenerateCombinationUseCase.Companion.ELEMENTS
import ooh.app.funnycombination.domain.usecase.GetUserGamesScoreUseCase
import ooh.app.funnycombination.domain.usecase.SaveUserGameScoreUseCase
import ooh.app.funnycombination.presentation.ui.states.GameUiState
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val generateCombinationUseCase: GenerateCombinationUseCase,
    private val getUserGamesScoreUseCase: GetUserGamesScoreUseCase,
    private val saveUserGameScoreUseCase: SaveUserGameScoreUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                input = ELEMENTS
            )
        }

        getCombination()
    }

    fun displayCombination() {
        viewModelScope.launch {
            for (i in 0.._uiState.value.combinationLength) {
                _uiState.update {
                    it.copy(
                        showElement = i
                    )
                }
                delay(1000)
            }

            _uiState.update {
                it.copy(
                    enabled = true
                )
            }
        }
    }

    fun getCombination() {
        _uiState.update {
            it.copy(
                enabled = false,
                combination = generateCombinationUseCase.generateCombination(_uiState.value.combinationLength)
            )
        }

        displayCombination()
    }

    fun userInput(el: Int) {
        _uiState.update {
            it.copy(
                userInput = it.userInput + ELEMENTS[el]
            )
        }
        compareInput()
    }

    fun compareInput() {
        if (_uiState.value.userInput.size == _uiState.value.combination.size) {

            if (_uiState.value.userInput == _uiState.value.combination) {

                _uiState.update {
                    it.copy(
                        combinationLength = it.combinationLength + 1,
                        userInput = emptyList<Int>()
                    )
                }

                getCombination()
            } else {

                _uiState.update {
                    it.copy(
                        gameOver = true
                    )
                }

                saveUserResult()
            }
        }
    }

    fun saveUserResult() {
        viewModelScope.launch {
            val scores = getUserGamesScoreUseCase.getUserGamesScore()

            if (scores.isEmpty()) {
                _uiState.update {
                    it.copy(
                        record = true
                    )
                }

                val score = GameScore(
                    score = _uiState.value.combinationLength,
                    date = LocalDate.now().toString(),
                )
                saveUserGameScoreUseCase.saveGameScore(score)
            } else {
                if (_uiState.value.combinationLength > scores.maxOf { it.score }) {
                    _uiState.update {
                        it.copy(
                            record = true
                        )
                    }

                    val score = GameScore(
                        score = _uiState.value.combinationLength,
                        date = LocalDate.now().toString()
                    )
                    saveUserGameScoreUseCase.saveGameScore(score)
                }
            }
        }
    }
}