package dev.braynne.myapp.ui.screen.todos.component

import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import dev.braynne.myapp.domain.model.Task

@Composable
fun AddEditTaskDialog(
	task: Task? = null,
	onDismiss: () -> Unit,
	onConfirm: (Task) -> Unit
) {

	val isEditing = task != null

	var title by remember { mutableStateOf(task?.title ?: "") }
	var description by remember { mutableStateOf(task?.description ?: "") }
	var priority by remember { mutableStateOf(task?.priority ?: "medium") }

	AlertDialog(
		onDismissRequest = onDismiss,
		title = {
			Text(
				text = if (isEditing) "Editar tarea" else "Nueva tarea"
			)
		},
		text = {
			Column(modifier = Modifier.fillMaxWidth()) {
				OutlinedTextField(
					value = title,
					onValueChange = { title = it },
					label = { Text("Título") },
					singleLine = true,
					modifier = Modifier.fillMaxWidth()
				)

				Spacer(modifier = Modifier.height(16.dp))

				OutlinedTextField(
					value = description,
					onValueChange = { description = it },
					label = { Text("Descripción") },
					minLines = 2,
					maxLines = 4,
					modifier = Modifier.fillMaxWidth()
				)

				Spacer(modifier = Modifier.height(16.dp))

				PrioritySelector(
					selectedPriority = priority,
					onPrioritySelected = { priority = it }
				)
			}
		},
		confirmButton = {
			TextButton(
				onClick = {
					onConfirm(
						(task ?: Task()).copy(
							title = title,
							description = description,
							priority = priority
						)
					)
				},
				enabled = title.isNotBlank()
			) {
				Text(text = if (isEditing) "Guardar" else "Crear")
			}
		},
		dismissButton = {
			TextButton(onClick = onDismiss) {
				Text(text = "Cancelar")
			}
		}
	)
}