package dev.braynne.myapp.domain.model

data class User(
	val id: Long = 0,
	val name: String = "",
	val email: String = "",
	val role: String = "user",
	val active: Boolean = true
)
