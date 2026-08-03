package dev.braynne.myapp.ui.screen.todos

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.braynne.myapp.domain.model.Task
import dev.braynne.myapp.ui.component.BodyLarge
import dev.braynne.myapp.ui.component.BoxScaffold
import dev.braynne.myapp.ui.component.XFloatingActionButton
import dev.braynne.myapp.ui.component.ColumnScaffold
import dev.braynne.myapp.ui.component.XTopAppBar
import dev.braynne.myapp.ui.screen.todos.component.AddEditTaskDialog
import dev.braynne.myapp.ui.screen.todos.component.TaskItem

@Composable
fun TodosScreen(
	onLogoutClick: () -> Unit = {},
) {
	var state by remember {
		mutableStateOf(TodosUiState(tasks = listOf(
			Task(id=1, title="Estudiar Compose", description="Ver videos de Compose", priority="high", userId=1),
			Task(id=2, title="Hacer ejercicio", description="30 minutos", status = "in_progress", userId=1),
			Task(id=3, title="Comprar viveres", status="done", userId=1)
		)))
	}

	BoxScaffold (
		topBar = { XTopAppBar(title = "Mis tareas") },
		floatingActionButton = { XFloatingActionButton(
			onClick = { state = state.copy(showDialog = true) }
		) }
	) {
		if (state.loading) {
			CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
		}

		else if (state.tasks.isEmpty()) {
			BodyLarge(
				text = "Tareas",
				modifier = Modifier.align(Alignment.CenterHorizontally),
				color = MaterialTheme.colorScheme.onSurfaceVariant
			)
		} else {

			LazyColumn(
				modifier = Modifier.fillMaxSize().padding(16.dp)
			) {
				items(
					items = state.tasks,
					key = { it.id }
				) { task ->
					TaskItem(
						task = task,
						onEditClick = {
							state = state.copy(taskToEdit = task)
						},
						onDeleteClick = {
							state = state.copy(tasks = state.tasks.filter {
								it.id != task.id
							})
						}
					)
				}
			}
		}
	}
	if (state.showDialog) {
		AddEditTaskDialog(
			onDismiss = { state = state.copy(showDialog = false) },
			onConfirm = { newTask ->
				state = state.copy(
					tasks = state.tasks + newTask.copy(id = (state.tasks.maxOfOrNull { it.id } ?: 0) + 1),
					showDialog = false
				)
			}
		)
	}

	state.taskToEdit?.let { task ->
		AddEditTaskDialog(
			task = task,
			onDismiss = { state = state.copy(taskToEdit = null) },
			onConfirm = { updatedTask ->
				state = state.copy(
					tasks = state.tasks.map { if (it.id == updatedTask.id) updatedTask else it },
					taskToEdit = null
				)
			}
		)
	}
}

@Preview(showBackground = true)
@Composable
fun TodoScreenPreview() {
	TodosScreen()
}