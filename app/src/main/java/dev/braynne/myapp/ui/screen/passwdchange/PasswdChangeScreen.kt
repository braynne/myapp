package dev.braynne.myapp.ui.screen.passwdchange

import androidx.compose.foundation.layout.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.braynne.myapp.ui.component.*;

@Composable
fun PasswdChangeScreen(
	modifier: Modifier = Modifier,
	onPasswdChangeClick: () -> Unit = defaultOnClick
) {
	var state by remember { mutableStateOf(PasswdChangeUiState()) }

	ColumnScaffold (modifier) {

		HeadlineLarge("Cambiar contraseña")

		BodyLarge(
			"Ingresa tu contraseña actual y la nueva contraseña",
			textAlign = TextAlign.Center
		)

		Spacer(Modifier.height(32.dp))

		PasswordField(
			label = "Contraseña actual",
			value = state.passwdcurrent,
			onValueChange = { state = state.copy(passwdcurrent = it) },
			error = state.error
		)
		Spacer(Modifier.height(4.dp))

		PasswordField(
			label = "Contraseña nueva",
			value = state.passwdnew,
			onValueChange = { state = state.copy(passwdnew = it) },
			error = state.error
		)

		Spacer(Modifier.height(4.dp))

		PasswordField(
			label = "Confirmar contraseña nueva",
			value = state.passwdnewconfirm,
			onValueChange = { state = state.copy(passwdnewconfirm = it) },
			error = state.error
		)

		Spacer(Modifier.height(8.dp))

		PrimaryButton(
			text = "Iniciar sesión",
			onClick = onPasswdChangeClick,
			loading = state.loading
		)

		Spacer(Modifier.height(16.dp))

	}
}

@Preview(showBackground = true)
@Composable
fun Preview() {
	PasswdChangeScreen()
}