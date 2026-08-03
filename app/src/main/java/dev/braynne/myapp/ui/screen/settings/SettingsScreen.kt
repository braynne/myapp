package dev.braynne.myapp.ui.screen.settings

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.braynne.myapp.ui.component.BackgroundButton
import dev.braynne.myapp.ui.component.ColumnScaffold
import dev.braynne.myapp.ui.component.SecondaryButton
import dev.braynne.myapp.ui.component.XTopAppBar
import dev.braynne.myapp.ui.component.defaultOnClick

@Composable
fun SettingsScreen(
	modifier: Modifier = Modifier,
	onNotificationsClick: () -> Unit = defaultOnClick,
	onPrivacyClick: () -> Unit = defaultOnClick,
	onAboutClick: () -> Unit = defaultOnClick
) {
	ColumnScaffold(modifier, topBar = { XTopAppBar(title = "Ajustes") }) {

		SecondaryButton(
			modifier.height(56.dp),
			text = "Notificaciones",
			onClick = onNotificationsClick
		)

		Spacer(Modifier.height(12.dp))

		SecondaryButton(
			modifier.height(56.dp),
			text = "Privacidad",
			onClick = onPrivacyClick
		)

		Spacer(Modifier.height(12.dp))

		SecondaryButton(
			modifier.height(56.dp),
			text = "Acerca de",
			onClick = onAboutClick
		)
	}
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
	SettingsScreen()
}