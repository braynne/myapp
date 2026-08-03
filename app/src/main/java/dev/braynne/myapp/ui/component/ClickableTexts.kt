package dev.braynne.myapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun ClickableText(
	text: String,
	modifier: Modifier = Modifier,
	onClick: () -> Unit = defaultOnClick,
	style: TextStyle = LocalTextStyle.current,
	color: Color = MaterialTheme.colorScheme.primary
) {
	Text(
		text = text,
		modifier = modifier.clickable(onClick = onClick),
		color = color,
		textDecoration = TextDecoration.Underline,
		style = style
	)
}