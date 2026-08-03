package dev.braynne.myapp.ui.screen.home

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.braynne.myapp.ui.screen.login.LoginScreen
import dev.braynne.myapp.ui.screen.profileedit.ProfileEditScreen
import dev.braynne.myapp.ui.screen.register.RegisterScreen

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.braynne.myapp.ui.screen.about.AboutScreen
import dev.braynne.myapp.ui.screen.help.HelpScreen
import dev.braynne.myapp.ui.screen.passwdchange.PasswdChangeScreen
import dev.braynne.myapp.ui.screen.profile.ProfileScreen
import dev.braynne.myapp.ui.screen.settings.SettingsScreen
import dev.braynne.myapp.ui.screen.terms.TermsScreen
import dev.braynne.myapp.ui.screen.todos.TodosScreen

// ---------- Definición centralizada de pantallas ----------
sealed class Screen(
	val route: String,
	val label: String,
	val visible: Boolean = true,
	val content: @Composable (NavHostController) -> Unit
) {
	object Home : Screen(
		route = "home",
		label = "Inicio",
		visible = false,
		content = { nav -> HomeScreen(
			onNavigate = {route -> nav.navigate(route)}
		)}
	)

	object Login : Screen(
		route = "login",
		label = "Login",
		content = {
			LoginScreen() // sin funcionalidad, solo visual
		}
	)

	object Register : Screen(
		route = "register",
		label = "Registro",
		content = {
			RegisterScreen()
		}
	)

	object Profile : Screen(
		route = "profile",
		label = "Perfil",
		content = {
			ProfileScreen()
		}
	)

	object PasswdChange : Screen(
		route = "passwdchange",
		label = "Cambiar contraseña",
		content = {
			PasswdChangeScreen()
		}
	)

	object ProfileEdit : Screen(
		route = "editprofile",
		label = "Editar perfil",
		content = {
			ProfileEditScreen()
		}
	)

	object Todos : Screen(
		route = "todos",
		label = "TODOs",
		content = {
			TodosScreen()
		}
	)

	object Settings : Screen(
		route = "settings",
		label = "Ajustes",
		content = {
			SettingsScreen()
		}
	)

	object Help : Screen(
		route = "help",
		label = "Ayuda",
		content = {
			HelpScreen()
		}
	)

	object Terms : Screen(
		route = "terms",
		label = "Términos y condiciones",
		content = {
			TermsScreen()
		}
	)

	object About : Screen(
		route = "about",
		label = "Acerca de",
		content = {
			AboutScreen()
		}
	)

	companion object {
		// Todas las pantallas registradas en la app
		val all: List<Screen> by lazy { listOf(
			Home, Login, Register, Profile, PasswdChange,
			ProfileEdit, Todos, Settings, Help, Terms, About
		) }

		// Solo las que se muestran como items en el menú del Home
		val visibles get() = all.filter { it.visible }
	}
}

// ---------- NavHost ----------
@Composable
fun AppNavHost() {
	val navController = rememberNavController()

	NavHost(navController = navController, startDestination = Screen.Home.route) {
		Screen.all.forEach { screen ->
			composable(screen.route) {
				screen.content(navController)
			}
		}
	}
}
