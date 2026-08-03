package dev.braynne.myapp.ui.screen.todos.component


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PrioritySelector(
	selectedPriority: String,
	onPrioritySelected: (String) -> Unit,
	modifier: Modifier = Modifier
) {

	val priorities = listOf(
		"low" to "Baja",
		"medium" to "Media",
		"high" to "Alta"
	)

	Row(
		modifier = modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceEvenly
	) {
		priorities.forEach { (value, label) ->
			FilterChip(
				selected = selectedPriority == value,
				onClick = { onPrioritySelected(value) },
				label = { Text(label) }
			)
		}
	}
}
