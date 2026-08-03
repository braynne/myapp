package dev.braynne.myapp.ui.component

import androidx.compose.foundation.layout.*;
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*;
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val defaultAction: () -> Unit = {}
val defaultContent: @Composable () -> Unit = {}
val defaultColumnContent: @Composable ColumnScope.() -> Unit = {}
val defaultBoxContent: @Composable BoxScope.() -> Unit = {}
val defaultRowContent: @Composable RowScope.() -> Unit = {}



@Composable
fun XColumn(
	modifier: Modifier = Modifier,
	verticalArrangement: Arrangement.Vertical = Arrangement.Center,
	horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
	content: @Composable ColumnScope.() -> Unit = defaultColumnContent
) {
	Column(
		modifier = modifier.fillMaxSize(),
		verticalArrangement = verticalArrangement,
		horizontalAlignment = horizontalAlignment,
		content = content
	)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun XTopAppBar(
	modifier: Modifier = Modifier,
	title: String? = null,
	navigationIcon: @Composable () -> Unit = defaultContent,
	actions: @Composable RowScope.() -> Unit = {},
) {
	TopAppBar(
		title = title?.let{{ Text(it) }} ?: defaultContent,
		modifier, navigationIcon, actions
	)
}



@Composable
fun ColumnScaffold(
	modifier: Modifier = Modifier,
	padding: Dp = 32.dp,
	topBar: @Composable () -> Unit = defaultContent,
	floatingActionButton: @Composable () -> Unit = defaultContent,
	bottomBar: @Composable () -> Unit = defaultContent,
	content: @Composable ColumnScope.() -> Unit = defaultColumnContent
) {
	Scaffold (
		topBar = topBar,
		floatingActionButton = floatingActionButton,
		bottomBar = bottomBar
	) {
		innerPadding ->
		XColumn(
			modifier
				.padding(innerPadding)
				.padding(horizontal = padding),
			content = content
		)
	}
}

@Composable
fun BoxScaffold(
	modifier: Modifier = Modifier,
	padding: Dp = 32.dp,
	topBar: @Composable () -> Unit = defaultContent,
	floatingActionButton: @Composable () -> Unit = defaultContent,
	bottomBar: @Composable () -> Unit = defaultContent,
	content: @Composable BoxScope.() -> Unit = defaultBoxContent
) {
	Scaffold (
		topBar = topBar,
		floatingActionButton = floatingActionButton,
		bottomBar = bottomBar
	) {
			innerPadding ->
		Box(
			Modifier.fillMaxSize()
				.padding(innerPadding)
				.padding(horizontal = padding),
			content = content
		)
	}
}


