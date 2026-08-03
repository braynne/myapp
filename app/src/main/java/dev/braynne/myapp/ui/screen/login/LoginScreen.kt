package dev.braynne.myapp.ui.screen.login

import androidx.compose.foundation.layout.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.braynne.myapp.ui.component.*;

@Composable
fun LoginScreen(
	modifier: Modifier = Modifier,
	onLoginClick: () -> Unit = defaultOnClick,
	onRegisterClick: () -> Unit = defaultOnClick
) {
	var state by remember { mutableStateOf(LoginUiState()) }

	ColumnScaffold (modifier) {

		HeadlineLarge("Bienvenido")



		BodyLarge("Inicia sesión para continuar")

		Spacer(Modifier.height(32.dp))

		EmailField(
			value = state.email,
			onValueChange = { state = state.copy(email = it) },
			error = state.error
		)

		Spacer(Modifier.height(4.dp))

		PasswordField(
			value = state.passwd,
			onValueChange = { state = state.copy(passwd = it) },
			error = state.error
		)

		Spacer(Modifier.height(8.dp))

		PrimaryButton(
			text = "Iniciar sesión",
			onClick = onLoginClick,
			loading = state.loading
		)

		Spacer(Modifier.height(16.dp))

		ClickableText("No tienes cuenta? Registrate", onClick = onRegisterClick)
	}
}

@Preview(showBackground = true)
@Composable
fun Preview() {
	LoginScreen()
}