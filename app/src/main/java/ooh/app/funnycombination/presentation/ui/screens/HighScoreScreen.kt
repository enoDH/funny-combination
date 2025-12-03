package ooh.app.funnycombination.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ooh.app.funnycombination.presentation.viewmodel.HighScoreViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun HighScoreScreen(
    viewModel: HighScoreViewModel,
    onNavigateToGame: () -> Unit,
    paddingValues: PaddingValues
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Dashboard",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )

        if (uiState.results.isEmpty()) {
            Text(
                "You are welcome here",
                modifier = Modifier.padding(16.dp)
            )

            Button(onClick = onNavigateToGame) {
                Text("Play")
            }
        } else {
            LazyColumn {
                items(uiState.results) { item ->
                    Row(
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .background(color = Color.Cyan, RoundedCornerShape(8.dp))
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text("Date: ${item.date}")
                        Text("Level: ${item.score}")
                    }
                }
            }
        }
    }
}