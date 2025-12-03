package ooh.app.funnycombination.presentation.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PolicyScreen(paddingValues: PaddingValues) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        item {
            Text(
                text = "Privacy Policy",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
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
                modifier = Modifier.padding(bottom = 8.dp)
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
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                        " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                        " when an unknown printer took a galley of type and scrambled it to make a type " +
                        "specimen book. It has survived not only five centuries, but also the leap into " +
                        "electronic typesetting, remaining essentially unchanged. It was popularised in " +
                        "the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                        "and more recently with desktop publishing software like Aldus PageMaker including " +
                        "versions of Lorem Ipsum."
            )
        }
    }
}
