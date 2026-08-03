package dev.braynne.myapp.ui.screen.register

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.braynne.myapp.ui.component.BodyLarge
import dev.braynne.myapp.ui.component.ClickableText
import dev.braynne.myapp.ui.component.EmailField
import dev.braynne.myapp.ui.component.HeadlineLarge
import dev.braynne.myapp.ui.component.PasswordField
import dev.braynne.myapp.ui.component.PrimaryButton
import dev.braynne.myapp.ui.component.UserField
import dev.braynne.myapp.ui.component.ColumnScaffold
import dev.braynne.myapp.ui.component.defaultOnClick

@Composable
fun RegisterScreen(
	modifier: Modifier = Modifier,
	onRegisterClick: () -> Unit = defaultOnClick,
	onLoginClick: () -> Unit = defaultOnClick
) {
	var state by remember { mutableStateOf(RegisterUiState()) }

	ColumnScaffold(modifier) {

		HeadlineLarge("Bienvenido")

		BodyLarge("Regístrese para continuar")

		Spacer(modifier = Modifier.height(32.dp))

		UserField(
			value = state.name,
			onValueChange = { state = state.copy(name = it) },
			error = state.error
		)

		Spacer(Modifier.height(4.dp))

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

		Spacer(Modifier.height(4.dp))

		PasswordField(
			label = "Confirmar contraseña",
			value = state.passwdconfirm,
			onValueChange = { state = state.copy(passwdconfirm = it) },
			error = state.error
		)

		Spacer(Modifier.height(8.dp))

		PrimaryButton(
			text = "Registrarse",
			onClick = onRegisterClick,
			loading = state.loading
		)

		Spacer(Modifier.height(16.dp))

		ClickableText("Ya tienes cuenta? Inicia sesión", onClick = onLoginClick)
	}
}

@Preview(showBackground = true)
@Composable
fun Preview() {
	RegisterScreen()
}