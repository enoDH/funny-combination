package ooh.app.funnycombination.presentation.ui.states

data class GameUiState(
    val combinationLength: Int = 1,
    val combination: List<Int> = emptyList<Int>(),
    val input: List<Int> = emptyList<Int>(),
    val userInput: List<Int> = emptyList<Int>(),
    val gameOver: Boolean = false,
    val showElement: Int = 0,
    val enabled: Boolean = false,
    val record: Boolean = false
)
