package kmm.rickandmorty.app.android.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import kmm.rickandmorty.app.android.presentation.components.core.BottomNavComponent
import kmm.rickandmorty.app.android.presentation.components.core.Navigation
import kmm.rickandmorty.app.android.presentation.components.core.TopBar
import kmm.rickandmorty.app.android.presentation.theme.Rick__Morty_KMMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Rick__Morty_KMMTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavComponent(navController) }
    ) {
        Navigation(navHostController = navController)
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}