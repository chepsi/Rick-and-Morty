package kmm.rickandmorty.app.android.presentation.components.locations

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.IntrinsicSize.Max
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import kmm.rickandmorty.app.android.R
import kmm.rickandmorty.app.android.presentation.components.core.AppLoader
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
    val state by viewModel.locations.collectAsState()

    when (state) {
        is Success -> {
            LazyColumn(
                contentPadding = PaddingValues(top = dimensionResource(id = R.dimen.location_list_content_top_padding), bottom = dimensionResource(id = R.dimen.location_list_content_bottom_padding)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.location_list_spacer))
            ) {
                items((state as Success).data) { location ->
                    Location(location = location)
                }
            }
        }
        is Error -> Unit
        Loading -> {
            AppLoader(modifier = Modifier.fillMaxSize(), imageID = R.drawable.morty_dance,
                imageHeight = dimensionResource(id = R.dimen.app_loader_height))
        }
    }
}

@Composable
fun Location(location: LocationPresentationModel) {
    Card(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.location_corner_radius)),
        modifier = Modifier
            .height(Max)
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.location_card_horizontal_padding))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = dimensionResource(id = R.dimen.location_column_padding)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.location_column_spacer))
        ) {
            Text(
                text = location.name,
                fontFamily = lato,
                fontWeight = FontWeight.Bold,
                fontSize =16.sp
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
