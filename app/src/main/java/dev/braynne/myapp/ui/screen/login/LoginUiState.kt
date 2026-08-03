package dev.braynne.myapp.ui.screen.login

data class LoginUiState(
	val email: String = "",
	val passwd: String = "",
	val pwvisible: Boolean = false,
	val loading: Boolean = false,
	val error: String? = null
)