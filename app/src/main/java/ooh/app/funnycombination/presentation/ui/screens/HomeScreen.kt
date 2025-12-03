package ooh.app.funnycombination.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    onNavigateToGame: () -> Unit,
    onNavigateToHighScore: () -> Unit,
    onNavigateToPrivacyPolicy: () -> Unit,
    onNavigateToExit: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = onNavigateToGame) {
            Text("Play")
        }

        Button(onClick = onNavigateToHighScore) {
            Text("High Score")
        }

        Button(onClick = onNavigateToPrivacyPolicy) {
            Text("Privacy Policy")
        }

        Button(onClick = onNavigateToExit) {
            Text("Exit")
        }
    }
}