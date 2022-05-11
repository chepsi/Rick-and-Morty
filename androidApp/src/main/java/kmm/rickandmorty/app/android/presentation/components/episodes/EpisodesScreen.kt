package kmm.rickandmorty.app.android.presentation.components.episodes

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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmm.rickandmorty.app.android.R
import kmm.rickandmorty.app.android.presentation.components.episodes.models.EpisodePresentationModel
import kmm.rickandmorty.app.android.presentation.components.episodes.models.EpisodesUiState.Error
import kmm.rickandmorty.app.android.presentation.components.episodes.models.EpisodesUiState.Loading
import kmm.rickandmorty.app.android.presentation.components.episodes.models.EpisodesUiState.Success
import kmm.rickandmorty.app.android.presentation.theme.lato
import kmm.rickandmorty.app.android.presentation.theme.muli
import org.koin.androidx.compose.getViewModel

@Composable
fun EpisodesScreen() {
    val viewModel: EpisodesViewModel = getViewModel()
    viewModel.fetchEpisodes()

    val state by viewModel.episodes.collectAsState()

    when (state) {
        is Success -> {
            LazyColumn(
                contentPadding = PaddingValues(top = dimensionResource(id = R.dimen.episodes_list_content_top_padding), bottom = dimensionResource(id = R.dimen.episodes_list_content_bottom_padding)),
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(id = R.dimen.episodes_list_spacer)
                )
            ) {
                items((state as Success).data) { episode ->
                    Episode(episode)
                }
            }
        }
        is Error -> Unit
        Loading -> Unit
    }
}

@Composable
fun Episode(episode: EpisodePresentationModel) {
    Card(
        shape = RoundedCornerShape(
            dimensionResource(id = R.dimen.episodes_corner_radius)
        ),
        modifier = Modifier
            .height(Max)
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.episodes_card_horizontal_padding))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = dimensionResource(id = R.dimen.episodes_column_padding)),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.episodes_column_spacer)
            )
        ) {
            Text(
                text = episode.episode,
                fontFamily = lato,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = episode.name,
                fontFamily = muli,
                fontSize = 12.sp
            )
            Text(
                text = episode.airDate,
                fontFamily = muli,
                fontSize = 12.sp
            )
        }
    }
}

@Preview
@Composable
fun EpisodesScreenPreview() {
    EpisodesScreen()
}
