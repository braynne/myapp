package dev.braynne.myapp.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val defaultOnClick: () -> Unit = {}

@Composable
fun PrimaryButton(
	modifier: Modifier = Modifier,
	onClick: () -> Unit = defaultOnClick,
	text: String = "",
	enabled: Boolean = true,
	loading: Boolean = false,
	containercolor: Color = MaterialTheme.colorScheme.primary,
	contentcolor: Color = MaterialTheme.colorScheme.onPrimary
) {
	val buttoncolors: ButtonColors = ButtonDefaults.buttonColors(
		containercolor, contentcolor
	)

	Button(
		onClick = onClick,
		modifier = modifier.fillMaxWidth(),
		enabled = enabled && !loading,
		colors = buttoncolors
	) {
		if (loading) {
			CircularProgressIndicator(
				modifier = Modifier.size(20.dp),
				//color = loadingcolor,
				strokeWidth = 2.dp
			)
		} else Text(text, /*color = textcolor*/)
	}
}

@Composable
fun SecondaryButton(
	modifier: Modifier = Modifier,
	onClick: () -> Unit = defaultOnClick,
	text: String = "",
	enabled: Boolean = true,
	loading: Boolean = false,
	containercolor: Color = MaterialTheme.colorScheme.secondary,
	contentcolor: Color = MaterialTheme.colorScheme.onSecondary
) {
	PrimaryButton(
		modifier, onClick, text, enabled,
		loading, containercolor, contentcolor
	)
}

@Composable
fun BackgroundButton(
	modifier: Modifier = Modifier,
	onClick: () -> Unit = defaultOnClick,
	text: String = "",
	enabled: Boolean = true,
	loading: Boolean = false,
	containercolor: Color = MaterialTheme.colorScheme.background,
	contentcolor: Color = MaterialTheme.colorScheme.onBackground
) {
	PrimaryButton(
		modifier, onClick, text, enabled,
		loading, containercolor, contentcolor
	)
}

@Composable
fun ErrorButton(
	modifier: Modifier = Modifier,
	onClick: () -> Unit = defaultOnClick,
	text: String = "",
	enabled: Boolean = true,
	loading: Boolean = false,
	containercolor: Color = MaterialTheme.colorScheme.error,
	contentcolor: Color = MaterialTheme.colorScheme.onError
) {
	PrimaryButton(
		modifier, onClick, text, enabled,
		loading, containercolor, contentcolor
	)
}

@Composable
fun XFloatingActionButton(
	modifier: Modifier = Modifier,
	onClick: () -> Unit = defaultAction,
	icon: ImageVector = Icons.Default.Add,
	description: String? = null
) {
	FloatingActionButton(
		modifier = modifier,
		onClick = onClick
	) {
		Icon(
			imageVector = icon,
			contentDescription = description
		)
	}
}
