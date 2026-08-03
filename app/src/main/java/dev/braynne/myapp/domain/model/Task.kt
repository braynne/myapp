package dev.braynne.myapp.domain.model

data class Task(
	val id: Long = 0,
	val title: String = "",
	val description: String = "",
	val status: String = "pending",
	val priority: String = "medium",
	val userId: Long = 0
)