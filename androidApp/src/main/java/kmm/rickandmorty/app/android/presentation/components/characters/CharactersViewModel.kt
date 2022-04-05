package kmm.rickandmorty.app.android.presentation.components.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kmm.rickandmorty.app.android.presentation.components.characters.mapper.toPresentation
import kmm.rickandmorty.app.android.presentation.components.characters.model.CharactersUiState
import kmm.rickandmorty.app.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val rickAndMortyRepository: RickAndMortyRepository
) : ViewModel() {
    private val charactersUiState: MutableStateFlow<CharactersUiState> =
        MutableStateFlow(CharactersUiState.Loading)
    val characters = charactersUiState.asStateFlow()

    fun fetchCharacters() {
        viewModelScope.launch {
            val result = rickAndMortyRepository.fetchCharacters()
                .map { character -> character.toPresentation() }
            charactersUiState.value = CharactersUiState.Success(result)
        }
    }
}
