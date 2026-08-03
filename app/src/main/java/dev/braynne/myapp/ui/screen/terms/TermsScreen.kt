package dev.braynne.myapp.ui.screen.terms

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.braynne.myapp.ui.component.BodyMedium
import dev.braynne.myapp.ui.component.ColumnScaffold
import dev.braynne.myapp.ui.component.HeadlineLarge
import dev.braynne.myapp.ui.component.XTopAppBar

@Composable
fun TermsScreen(
	modifier: Modifier = Modifier
) {
	ColumnScaffold(modifier, topBar = { XTopAppBar(title = "Términos y condiciones") }) {

		HeadlineLarge("Términos de uso")

		Spacer(Modifier.height(16.dp))

		BodyMedium(
			"Al usar esta aplicación aceptas nuestras políticas de uso y privacidad. " +
			"Este es un texto de ejemplo para la pantalla de términos y condiciones."
		)
	}
}

@Preview(showBackground = true)
@Composable
fun TermsScreenPreview() {
	TermsScreen()
}