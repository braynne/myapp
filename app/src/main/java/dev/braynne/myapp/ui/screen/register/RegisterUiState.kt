package dev.braynne.myapp.ui.screen.register

data class RegisterUiState (
	val name: String = "",
	val email: String = "",
	val passwd: String = "",
	val passwdconfirm: String = "",
	val loading: Boolean = false,
	val error: String? = null
)