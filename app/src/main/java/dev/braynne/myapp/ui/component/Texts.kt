package dev.braynne.myapp.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TitleLarge(
	text: String,
	modifier: Modifier = Modifier,
	color: Color = Color.Unspecified,
	textAlign: TextAlign = TextAlign.Unspecified
) {
	Text(text, modifier, color, style = MaterialTheme.typography.titleLarge,
		textAlign = textAlign)
}

@Composable
fun TitleMedium(
	text: String,
	modifier: Modifier = Modifier,
	color: Color = Color.Unspecified,
	textAlign: TextAlign = TextAlign.Unspecified
) {
	Text(text, modifier, color, style = MaterialTheme.typography.titleMedium,
		textAlign = textAlign)
}

@Composable
fun TitleSmall(
	text: String,
	modifier: Modifier = Modifier,
	color: Color = Color.Unspecified,
	textAlign: TextAlign = TextAlign.Unspecified
) {
	Text(text, modifier, color, style = MaterialTheme.typography.titleSmall,
		textAlign = textAlign)
}

@Composable
fun HeadlineLarge(
	text: String,
	modifier: Modifier = Modifier,
	color: Color = Color.Unspecified,
	textAlign: TextAlign = TextAlign.Unspecified
) {
	Text(text, modifier, color, style = MaterialTheme.typography.headlineLarge,
		textAlign = textAlign)
}

@Composable
fun HeadlineMedium(
	text: String,
	modifier: Modifier = Modifier,
	color: Color = Color.Unspecified,
	textAlign: TextAlign = TextAlign.Unspecified
) {
	Text(text, modifier, color, style = MaterialTheme.typography.headlineMedium,
		textAlign = textAlign)
}

@Composable
fun HeadlineSmall(
	text: String,
	modifier: Modifier = Modifier,
	color: Color = Color.Unspecified,
	textAlign: TextAlign = TextAlign.Unspecified
) {
	Text(text, modifier, color, style = MaterialTheme.typography.headlineSmall,
		textAlign = textAlign)
}

@Composable
fun BodyLarge(
	text: String,
	modifier: Modifier = Modifier,
	color: Color = Color.Unspecified,
	textAlign: TextAlign = TextAlign.Unspecified
) {
	Text(text, modifier, color, style = MaterialTheme.typography.bodyLarge,
		textAlign = textAlign)
}

@Composable
fun BodyMedium(
	text: String,
	modifier: Modifier = Modifier,
	color: Color = Color.Unspecified,
	textAlign: TextAlign = TextAlign.Unspecified
) {
	Text(text, modifier, color, style = MaterialTheme.typography.bodyMedium,
		textAlign = textAlign)
}

@Composable
fun BodySmall(
	text: String,
	modifier: Modifier = Modifier,
	color: Color = Color.Unspecified,
	textAlign: TextAlign = TextAlign.Unspecified
) {
	Text(text, modifier, color, style = MaterialTheme.typography.bodySmall,
		textAlign = textAlign)
}