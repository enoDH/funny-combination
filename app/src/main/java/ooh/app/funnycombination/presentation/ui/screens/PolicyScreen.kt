package ooh.app.funnycombination.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PolicyScreen(paddingValues: PaddingValues) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Privacy Policy") }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
        ) {

            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(
                            text = "Privacy Policy",
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )

                        Text(
                            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                                    " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                                    " when an unknown printer took a galley of type and scrambled it to make a type " +
                                    "specimen book. It has survived not only five centuries, but also the leap into " +
                                    "electronic typesetting, remaining essentially unchanged. It was popularised in " +
                                    "the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                                    "and more recently with desktop publishing software like Aldus PageMaker including " +
                                    "versions of Lorem Ipsum.",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )

                        Text(
                            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                                    " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                                    " when an unknown printer took a galley of type and scrambled it to make a type " +
                                    "specimen book. It has survived not only five centuries, but also the leap into " +
                                    "electronic typesetting, remaining essentially unchanged. It was popularised in " +
                                    "the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                                    "and more recently with desktop publishing software like Aldus PageMaker including " +
                                    "versions of Lorem Ipsum.",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )

                        Text(
                            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                                    " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                                    " when an unknown printer took a galley of type and scrambled it to make a type " +
                                    "specimen book. It has survived not only five centuries, but also the leap into " +
                                    "electronic typesetting, remaining essentially unchanged. It was popularised in " +
                                    "the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                                    "and more recently with desktop publishing software like Aldus PageMaker including " +
                                    "versions of Lorem Ipsum.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}

