package kmm.rickandmorty.app.android.presentation.components.episodes.models

sealed interface EpisodesUiState {
    object Loading : EpisodesUiState
    data class Success(val data: List<EpisodePresentationModel>) : EpisodesUiState
    data class Error(val message: String) : EpisodesUiState
}
