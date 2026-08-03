package dev.braynne.myapp.ui.screen.passwdchange

data class PasswdChangeUiState(
	val passwdcurrent: String = "",
	val passwdnew: String = "",
	val passwdnewconfirm: String = "",
	val error: String? = null,
	val loading: Boolean = false
)
