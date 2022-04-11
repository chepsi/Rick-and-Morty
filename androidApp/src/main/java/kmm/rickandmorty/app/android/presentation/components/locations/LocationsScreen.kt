package kmm.rickandmorty.app.android.presentation.components.locations

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import kmm.rickandmorty.app.android.presentation.components.locations.model.LocationPresentationModel
import kmm.rickandmorty.app.android.presentation.components.locations.model.LocationsUiState.Error
import kmm.rickandmorty.app.android.presentation.components.locations.model.LocationsUiState.Loading
import kmm.rickandmorty.app.android.presentation.components.locations.model.LocationsUiState.Success
import org.koin.androidx.compose.getViewModel

@Composable
fun LocationsScreen() {
    val viewModel: LocationsViewModel = getViewModel()
    viewModel.fetchLocations()
    val state by viewModel.characters.collectAsState()

    when (state) {
        is Success -> {
            LazyColumn {
                items((state as Success).data) { location ->
                    Location(location = location)
                }
            }
        }
        is Error -> Unit
        Loading -> Unit
    }
}

@Composable
fun Location(location: LocationPresentationModel) {
    Image(
        painter = rememberAsyncImagePainter(model = location.url),
        contentDescription = location.name
    )
    Text(text = location.name)
}

@Preview
@Composable
fun LocationsScreenPreview() {
    LocationsScreen()
}
