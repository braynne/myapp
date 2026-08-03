package dev.braynne.myapp.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.braynne.myapp.ui.component.*


@Composable
fun HomeScreen(
	modifier: Modifier = Modifier,
	onNavigate: (String) -> Unit = {}
) {
	ColumnScaffold (modifier) {

		HeadlineSmall(
			text = "Pantallas disponibles",
			Modifier.padding(16.dp)
		)

		LazyColumn(
			Modifier.fillMaxSize(),
			contentPadding = PaddingValues(16.dp),
			verticalArrangement = Arrangement.spacedBy(12.dp)
		) {
			items(Screen.visibles, key = { it.route } ) { screen ->
				SecondaryButton (
					modifier.height(56.dp),
					text = screen.label,
					onClick = { onNavigate(screen.route) },

				)
			}
		}

	}
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
	HomeScreen()
}