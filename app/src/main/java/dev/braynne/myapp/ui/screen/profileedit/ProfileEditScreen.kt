package dev.braynne.myapp.ui.screen.profileedit

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
import dev.braynne.myapp.ui.component.ColumnScaffold
import dev.braynne.myapp.ui.component.EmailField
import dev.braynne.myapp.ui.component.PrimaryButton
import dev.braynne.myapp.ui.component.UserField
import dev.braynne.myapp.ui.component.XTopAppBar
import dev.braynne.myapp.ui.component.defaultOnClick

@Composable
fun ProfileEditScreen(
	modifier: Modifier = Modifier,
	onSaveClick: () -> Unit = defaultOnClick
) {
	var state by remember { mutableStateOf(ProfileEditUiState()) }

	ColumnScaffold(modifier, topBar = { XTopAppBar(title = "Editar perfil") }) {

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

		Spacer(Modifier.height(16.dp))

		PrimaryButton(
			text = "Guardar cambios",
			onClick = onSaveClick,
			loading = state.loading
		)
	}
}

@Preview(showBackground = true)
@Composable
fun ProfileEditScreenPreview() {
	ProfileEditScreen()
}