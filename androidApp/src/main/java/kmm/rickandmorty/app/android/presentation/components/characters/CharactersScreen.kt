package kmm.rickandmorty.app.android.presentation.components.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize.Max
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells.Adaptive
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import kmm.rickandmorty.app.android.presentation.components.characters.model.CharacterPresentationModel
import kmm.rickandmorty.app.android.presentation.components.characters.model.CharactersUiState
import kmm.rickandmorty.app.android.presentation.components.characters.model.CharactersUiState.Error
import kmm.rickandmorty.app.android.presentation.components.characters.model.CharactersUiState.Loading
import kmm.rickandmorty.app.android.presentation.components.characters.model.CharactersUiState.Success
import kmm.rickandmorty.app.android.presentation.components.core.TopBar
import kmm.rickandmorty.app.android.presentation.theme.lato
import kmm.rickandmorty.app.android.presentation.theme.muli
import org.koin.androidx.compose.getViewModel

@Composable
fun CharactersScreen() {
    val viewModel: CharactersViewModel = getViewModel()
    viewModel.fetchCharacters()
    val charactersState: CharactersUiState by viewModel.characters.collectAsState()

    Scaffold(
        topBar = { TopBar() }
    ) {
        when (charactersState) {
            is Success -> {
                LazyVerticalGrid(
                    columns = Adaptive(160.dp),
                    modifier = Modifier.padding(bottom = 60.dp),
                    contentPadding = PaddingValues(vertical = 10.dp)
                ) {
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(Max)
            .height(220.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(character.image),
            contentDescription = character.name,
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(180.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            text = character.name,
            fontFamily = lato,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = character.species + ", " + character.status,
            fontFamily = muli,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview
@Composable
fun CharactersScreenPreview() {
    CharactersScreen()
}
