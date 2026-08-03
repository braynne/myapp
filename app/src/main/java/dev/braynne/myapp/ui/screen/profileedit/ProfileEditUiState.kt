package dev.braynne.myapp.ui.screen.profileedit

data class ProfileEditUiState(
	val name: String = "",
	val email: String = "",
	val loading: Boolean = false,
	val error: String? = null
)