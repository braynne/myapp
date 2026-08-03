package dev.braynne.myapp.ui.screen.help

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.braynne.myapp.ui.component.BodyLarge
import dev.braynne.myapp.ui.component.BodyMedium
import dev.braynne.myapp.ui.component.ColumnScaffold
import dev.braynne.myapp.ui.component.HeadlineLarge
import dev.braynne.myapp.ui.component.XTopAppBar

@Composable
fun HelpScreen(
	modifier: Modifier = Modifier
) {
	ColumnScaffold(modifier, topBar = { XTopAppBar(title = "Ayuda") }) {

		HeadlineLarge("¿Necesitas ayuda?", textAlign = TextAlign.Center)

		Spacer(Modifier.height(16.dp))

		BodyLarge("Preguntas frecuentes", textAlign = TextAlign.Center)

		Spacer(Modifier.height(8.dp))

		BodyMedium(
			"Si tienes problemas con tu cuenta, contáctanos en soporte@myapp.dev",
			textAlign = TextAlign.Center
		)
	}
}

@Preview(showBackground = true)
@Composable
fun HelpScreenPreview() {
	HelpScreen()
}