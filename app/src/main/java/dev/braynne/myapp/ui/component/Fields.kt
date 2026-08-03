package dev.braynne.myapp.ui.component

import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*;
import androidx.compose.runtime.*;
import androidx.compose.material3.*;
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

val defaultOnValueChange: (String) -> Unit = {}

@Composable
fun XField (
	modifier: Modifier = Modifier,
	value: String = "",
	onValueChange: (String) -> Unit = defaultOnValueChange,
	label: String? = null,
	keyboardType: KeyboardType = KeyboardType.Unspecified,
	leadingIcon: ImageVector? = null,
	onToggleVisibility: (() -> Unit)? = null,
	visible: Boolean = true,
	error: String? = null
) {
	OutlinedTextField(
		value = value,
		onValueChange = onValueChange,
		label = label?.let { { Text(it) } }, //if (label != null) { { Text(label) } } else null,
		singleLine = true,
		visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
		keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
		modifier = modifier.fillMaxWidth(),
		leadingIcon = leadingIcon?.let { {
			Icon(imageVector = leadingIcon, contentDescription = null)
		} },
		trailingIcon = onToggleVisibility?.let { {
			IconButton(onClick = it) {
				Icon( imageVector =
						if (visible) Icons.Default.Visibility
						else Icons.Default.VisibilityOff,
					contentDescription = if (visible) "Ocultar" else "Mostrar"
				)
			}
		} },
		isError = error != null,
		supportingText =  error?.let { { Text(it) } }
	)
}

@Composable
fun EmailField(
	modifier: Modifier = Modifier,
	value: String = "",
	onValueChange: (String) -> Unit = defaultOnValueChange,
	error: String? = null,
	label: String = "Correo electrónico",
) {
	XField(
		modifier, value, onValueChange,
		label = label, error = error,
		leadingIcon = Icons.Default.Email,
		keyboardType = KeyboardType.Email
	)
}

@Composable
fun UserField(
	modifier: Modifier = Modifier,
	value: String = "",
	onValueChange: (String) -> Unit = defaultOnValueChange,
	error: String? = null,
	label: String = "Nombre de usuario",
) {
	XField(
		modifier, value, onValueChange,
		label = label, error = error,
		leadingIcon = Icons.Default.Person
	)
}

@Composable
fun PasswordField(
	modifier: Modifier = Modifier,
	value: String = "",
	onValueChange: (String) -> Unit = defaultOnValueChange,
	error: String? = null,
	label: String = "Contraseña",
) {
	var visible by remember { mutableStateOf(false) }
	XField(
		modifier, value, onValueChange,
		label = label, error = error,
		leadingIcon = Icons.Default.Key,
		visible = visible,
		onToggleVisibility = { visible = !visible }
	)
}

@Preview(showBackground = true)
@Composable
fun Preview() {
	PasswordField(Modifier, "XDDDD")
}