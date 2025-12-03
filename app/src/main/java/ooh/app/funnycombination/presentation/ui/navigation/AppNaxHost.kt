package ooh.app.funnycombination.presentation.ui.navigation

import android.app.Activity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ooh.app.funnycombination.presentation.ui.screens.GameOverScreen
import ooh.app.funnycombination.presentation.ui.screens.GameScreen
import ooh.app.funnycombination.presentation.ui.screens.HighScoreScreen
import ooh.app.funnycombination.presentation.ui.screens.HomeScreen
import ooh.app.funnycombination.presentation.ui.screens.PolicyScreen
import ooh.app.funnycombination.presentation.ui.screens.SplashScreen
import ooh.app.funnycombination.presentation.viewmodel.GameViewModel

@Composable
fun AppNavHost(navController: NavHostController, paddingValues: PaddingValues) {
    val context = LocalContext.current
    val activity = (context as? Activity)

    NavHost(navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(
                paddingValues,
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                paddingValues,
                onNavigateToGame = {
                    navController.navigate(Screen.GameFlow.route)
                },
                onNavigateToHighScore = {
                    navController.navigate(Screen.HighScore.route)
                },
                onNavigateToPrivacyPolicy = {
                    navController.navigate(Screen.Policy.route)
                },
                onNavigateToExit = {
                    activity?.finish()
                }
            )
        }

        navigation(startDestination = Screen.Game.route, route = Screen.GameFlow.route) {
            composable(Screen.Game.route) { backStackEntry ->
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry(Screen.GameFlow.route)
                }

                val gameViewModel: GameViewModel = hiltViewModel(parentEntry)

                GameScreen(
                    viewModel = gameViewModel,
                    onNavigateToGameOver = {
                        navController.navigate(Screen.GameOver.route)
                    },
                    paddingValues
                )
            }

            composable(Screen.GameOver.route) { backStackEntry ->
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry(Screen.GameFlow.route)
                }

                val gameViewModel: GameViewModel = hiltViewModel(parentEntry)

                GameOverScreen(
                    viewModel = gameViewModel,
                    onNavigateToHome = {
                        navController.navigate(Screen.Home.route)
                    },
                    onNavigateToGame = {
                        navController.popBackStack(route = Screen.GameFlow.route, inclusive = true)
                        navController.navigate(Screen.Game.route)
                    },
                    paddingValues
                )
            }
        }

        composable(Screen.HighScore.route) {
            HighScoreScreen(
                viewModel = hiltViewModel(),
                onNavigateToGame = {
                    navController.navigate(Screen.Game.route)
                },
                paddingValues
            )
        }

        composable(Screen.Policy.route) {
            PolicyScreen(paddingValues)
        }
    }
}