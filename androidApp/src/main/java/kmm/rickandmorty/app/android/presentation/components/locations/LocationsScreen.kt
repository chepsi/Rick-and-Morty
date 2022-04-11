package kmm.rickandmorty.app.android.presentation.components.locations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize.Max
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmm.rickandmorty.app.android.presentation.components.locations.model.LocationPresentationModel
import kmm.rickandmorty.app.android.presentation.components.locations.model.LocationsUiState.Error
import kmm.rickandmorty.app.android.presentation.components.locations.model.LocationsUiState.Loading
import kmm.rickandmorty.app.android.presentation.components.locations.model.LocationsUiState.Success
import kmm.rickandmorty.app.android.presentation.theme.lato
import kmm.rickandmorty.app.android.presentation.theme.muli
import org.koin.androidx.compose.getViewModel

@Composable
fun LocationsScreen() {
    val viewModel: LocationsViewModel = getViewModel()
    viewModel.fetchLocations()
    val state by viewModel.characters.collectAsState()

    when (state) {
        is Success -> {
            LazyColumn(
                contentPadding = PaddingValues(top = 10.dp, bottom = 60.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
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
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .height(Max)
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = location.name,
                fontFamily = lato,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = location.dimension,
                fontFamily = muli,
                fontSize = 12.sp
            )
            Text(
                text = location.type,
                fontFamily = muli,
                fontSize = 12.sp
            )
        }
    }
}

@Preview
@Composable
fun LocationsScreenPreview() {
    LocationsScreen()
}
