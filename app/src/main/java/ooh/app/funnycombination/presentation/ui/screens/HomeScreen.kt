package ooh.app.funnycombination.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    onNavigateToGame: () -> Unit,
    onNavigateToHighScore: () -> Unit,
    onNavigateToPrivacyPolicy: () -> Unit,
    onNavigateToExit: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Main Menu") }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(paddingValues)
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Button(
                        onClick = onNavigateToGame,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        Text("Play")
                    }

                    Button(
                        onClick = onNavigateToHighScore,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        Text("High Score")
                    }

                    Button(
                        onClick = onNavigateToPrivacyPolicy,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        Text("Privacy Policy")
                    }

                    Button(
                        onClick = onNavigateToExit,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        Text("Exit")
                    }
                }
            }
        }
    }
}
