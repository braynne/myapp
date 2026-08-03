package dev.braynne.myapp.ui.screen.todos

import dev.braynne.myapp.domain.model.Task

data class TodosUiState(
	val tasks: List<Task> = emptyList(),
	val loading: Boolean = false,
	val error: String? = null,
	val showDialog: Boolean = false,
	val taskToEdit: Task? = null
)
