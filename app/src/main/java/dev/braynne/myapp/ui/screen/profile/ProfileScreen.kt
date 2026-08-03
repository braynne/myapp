package dev.braynne.myapp.ui.screen.profile

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.braynne.myapp.domain.model.User
import dev.braynne.myapp.ui.component.BackgroundButton
import dev.braynne.myapp.ui.component.BodyMedium
import dev.braynne.myapp.ui.component.BodySmall
import dev.braynne.myapp.ui.component.HeadlineLarge
import dev.braynne.myapp.ui.component.PrimaryButton
import dev.braynne.myapp.ui.component.ColumnScaffold
import dev.braynne.myapp.ui.component.ErrorButton
import dev.braynne.myapp.ui.component.SecondaryButton
import dev.braynne.myapp.ui.component.XTopAppBar
import dev.braynne.myapp.ui.component.defaultOnClick

@Composable
fun ProfileScreen(
	modifier: Modifier = Modifier,
	user: User = User(name = "Juan Pérez", email = "juan@email.com"),
	onEdit: () -> Unit = defaultOnClick,
	onChangePasswd: () -> Unit = defaultOnClick,
	onLogout: () -> Unit = defaultOnClick
) {
	var state by remember { mutableStateOf(ProfileUiState()) }

	ColumnScaffold(modifier, topBar = { XTopAppBar(title = "Perfil") }) {

		Spacer(Modifier.height(32.dp))

		Icon(imageVector = Icons.Default.Person, contentDescription = "Usuario", modifier = Modifier
			.size(140.dp, 140.dp))

		HeadlineLarge(user.name, textAlign = TextAlign.Center)

		BodyMedium(
			user.email,
			color = MaterialTheme.colorScheme.secondary,
			textAlign = TextAlign.Center
		)

		Spacer(Modifier.height(20.dp))

		BodySmall(
			"Rol ${user.role}",
			textAlign = TextAlign.Center,
			color = MaterialTheme.colorScheme.primary
		)

		Spacer(Modifier.height(20.dp))

		PrimaryButton(
			text = "Editar perfil",
			onClick = onEdit,
			loading = state.LoadingProfileEdit,
		)

		Spacer(modifier = Modifier.height(8.dp))

		SecondaryButton(
			text = "Cambiar contraseña",
			onClick = onChangePasswd,
			contentcolor = MaterialTheme.colorScheme.primary
		)

		Spacer(modifier = Modifier.height(8.dp))

		ErrorButton(
			text = "Cerrar sesión",
			onClick = onLogout,
			loading = state.loadingLogout,
			contentcolor = MaterialTheme.colorScheme.error
		)
	}
}

@Preview(showBackground = true)
@Composable
fun Preview() {
	ProfileScreen()
}