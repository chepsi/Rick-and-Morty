package kmm.rickandmorty.app.android.presentation.components.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kmm.rickandmorty.app.android.presentation.components.characters.CharactersScreen
import kmm.rickandmorty.app.android.presentation.components.core.NavigationDestinations.Characters
import kmm.rickandmorty.app.android.presentation.components.core.NavigationDestinations.Episodes
import kmm.rickandmorty.app.android.presentation.components.core.NavigationDestinations.Locations
import kmm.rickandmorty.app.android.presentation.components.episodes.EpisodesScreen
import kmm.rickandmorty.app.android.presentation.components.locations.LocationsScreen

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Characters.route) {
        composable(Characters.route) {
            CharactersScreen()
        }
        composable(Locations.route) {
            LocationsScreen()
        }
        composable(Episodes.route) {
            EpisodesScreen()
        }
    }
}