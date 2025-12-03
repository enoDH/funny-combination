package ooh.app.funnycombination.presentation.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ooh.app.funnycombination.R
import ooh.app.funnycombination.presentation.viewmodel.GameViewModel

@Composable
fun GameScreen(
    viewModel: GameViewModel,
    onNavigateToGameOver: () -> Unit,
    paddingValues: PaddingValues
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.gameOver) {
        val context = LocalContext.current

        Toast.makeText(context, "You lost. Try again!",Toast.LENGTH_SHORT).show()
        onNavigateToGameOver()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineLarge
        )

        Text("Level: ${uiState.combinationLength}")

        LazyRow(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Gray)
                .padding(8.dp)
        )
        {
            items(uiState.combination.size) { item ->
                Column(
                    modifier = Modifier
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    if (item == uiState.showElement) {
                        Text(
                            text = stringResource(uiState.combination[item]),
                            fontSize = 24.sp
                        )
                    }
                }
            }
        }

        Text(text = if (uiState.enabled) "Repeat combination" else "Stay focused")

        LazyRow(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Gray)
                .padding(8.dp)
        )
        {
            items(uiState.userInput.size) { index ->
                Column(
                    modifier = Modifier
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Text(
                        text = stringResource(uiState.userInput[index]),
                        fontSize = 24.sp
                    )
                }
            }
        }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(uiState.input.size) { item ->
                Text(
                    stringResource(uiState.input[item]),
                    modifier = Modifier
                        .background(Color.Cyan, RoundedCornerShape(16.dp))
                        .padding(8.dp)
                        .clickable(
                            enabled = uiState.enabled,
                            onClick = {
                                viewModel.userInput(item)
                            }
                        ),
                    fontSize = 36.sp
                )
            }
        }

    }

}