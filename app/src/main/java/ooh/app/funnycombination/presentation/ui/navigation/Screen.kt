package ooh.app.funnycombination.presentation.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object GameFlow : Screen("game_flow")
    object Game : Screen("game")
    object GameOver : Screen("game_over")
    object HighScore : Screen("high_score")
    object Policy : Screen("policy")
}