package kmm.rickandmorty.app.android.presentation.components.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kmm.rickandmorty.app.android.presentation.components.episodes.mapper.toPresentation
import kmm.rickandmorty.app.android.presentation.components.episodes.models.EpisodesUiState
import kmm.rickandmorty.app.android.presentation.components.episodes.models.EpisodesUiState.Loading
import kmm.rickandmorty.app.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EpisodesViewModel(
    private val rickAndMortyRepository: RickAndMortyRepository
) : ViewModel() {

    private val episodesUiState: MutableStateFlow<EpisodesUiState> =
        MutableStateFlow(Loading)
    val episodes = episodesUiState.asStateFlow()

    fun fetchEpisodes() {
        viewModelScope.launch {
            val result = rickAndMortyRepository.fetchEpisodes()
                .map { character -> character.toPresentation() }
            episodesUiState.value = EpisodesUiState.Success(result)
        }
    }
}
