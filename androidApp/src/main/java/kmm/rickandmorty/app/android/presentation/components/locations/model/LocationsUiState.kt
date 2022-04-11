package kmm.rickandmorty.app.android.presentation.components.locations.model

sealed interface LocationsUiState {
    object Loading : LocationsUiState
    data class Success(val data: List<LocationPresentationModel>) : LocationsUiState
    data class Error(val message: String) : LocationsUiState
}
