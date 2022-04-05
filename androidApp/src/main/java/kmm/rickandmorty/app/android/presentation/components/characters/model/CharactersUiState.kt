package kmm.rickandmorty.app.android.presentation.components.characters.model

sealed interface CharactersUiState {
    object Loading : CharactersUiState
    data class Success(val data: List<CharacterPresentationModel>) : CharactersUiState
    data class Error(val message: String) : CharactersUiState
}
