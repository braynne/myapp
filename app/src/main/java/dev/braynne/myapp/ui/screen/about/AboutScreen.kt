package dev.braynne.myapp.ui.screen.about

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.braynne.myapp.ui.component.BodyMedium
import dev.braynne.myapp.ui.component.ColumnScaffold
import dev.braynne.myapp.ui.component.HeadlineLarge
import dev.braynne.myapp.ui.component.XTopAppBar

@Composable
fun AboutScreen(
	modifier: Modifier = Modifier,
	appVersion: String = "1.0.0"
) {
	ColumnScaffold(modifier, topBar = { XTopAppBar(title = "Acerca de") }) {
		HeadlineLarge("MyApp", textAlign = TextAlign.Center)
		Spacer(Modifier.height(8.dp))
		BodyMedium("Versión $appVersion", textAlign = TextAlign.Center)
	}
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
	AboutScreen()
}