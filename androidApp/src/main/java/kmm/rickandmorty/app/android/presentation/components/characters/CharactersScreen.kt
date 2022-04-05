package kmm.rickandmorty.app.android.presentation.components.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.grid.GridCells.Adaptive
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import kmm.rickandmorty.app.android.presentation.components.characters.model.CharacterPresentationModel
import kmm.rickandmorty.app.android.presentation.components.characters.model.CharactersUiState
import kmm.rickandmorty.app.android.presentation.components.characters.model.CharactersUiState.Error
import kmm.rickandmorty.app.android.presentation.components.characters.model.CharactersUiState.Loading
import kmm.rickandmorty.app.android.presentation.components.characters.model.CharactersUiState.Success
import kmm.rickandmorty.app.android.presentation.components.core.TopBar

@Composable
fun CharactersScreen() {
    val viewModel: CharactersViewModel = viewModel()
    viewModel.fetchCharacters()
    val charactersState: CharactersUiState by viewModel.characters.collectAsState()

    Scaffold(
        topBar = { TopBar() }
    ) {
        when (charactersState) {
            is Success -> {
                LazyVerticalGrid(columns = Adaptive(160.dp)) {
                    items((charactersState as Success).data) { item ->
                        Character(character = item)
                    }
                }
            }
            is Error -> {}
            Loading -> {}
        }
    }
}

@Composable
fun Character(character: CharacterPresentationModel) {
    Image(painter = rememberAsyncImagePainter(character.image), contentDescription = character.name)
    Text(text = character.name)
    Text(text = character.species + ", " + character.status)
}

@Preview
@Composable
fun CharactersScreenPreview() {
    CharactersScreen()
}
