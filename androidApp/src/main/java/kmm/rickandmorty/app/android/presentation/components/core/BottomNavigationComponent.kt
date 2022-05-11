package kmm.rickandmorty.app.android.presentation.components.core

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kmm.rickandmorty.app.android.presentation.components.core.NavigationDestinations.Characters
import kmm.rickandmorty.app.android.presentation.components.core.NavigationDestinations.Episodes
import kmm.rickandmorty.app.android.presentation.components.core.NavigationDestinations.Locations
import kmm.rickandmorty.app.android.presentation.components.locations.mappers.StringResMapper
import kmm.rickandmorty.app.android.presentation.theme.PrimaryTeal

@Composable
fun BottomNavComponent(navController: NavHostController) {
    val screens = listOf(
        Characters,
        Locations,
        Episodes
    )

    BottomNavigation(
        backgroundColor = PrimaryTeal,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        screens.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = screen.icon),
                        contentDescription = StringResMapper.StringResource(screen.title).stringAble()
                    )
                },
                label = { Text(text = StringResMapper.StringResource(screen.title).stringAble()) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    val navController = rememberNavController()
    BottomNavComponent(navController)
}
