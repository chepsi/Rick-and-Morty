package kmm.rickandmorty.app.android.presentation.components.characters

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kmm.rickandmorty.app.android.presentation.components.characters.model.CharacterPresentationModel
import kmm.rickandmorty.app.android.presentation.components.characters.model.CharactersUiState.Success
import kmm.rickandmorty.app.domain.models.CharacterDomainModel
import kmm.rickandmorty.app.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

val givenCharacter = CharacterDomainModel(
    id = 1,
    name = "Rick Sanchez",
    status = "Alive",
    species = "Human",
    type = "type",
    gender = "Male",
    origin = CharacterDomainModel.CharacterOrigin(
        name = "Earth",
        url = "https://rickandmortyapi.com/api/location/1"
    ),
    location = CharacterDomainModel.CharacterLocation(
        name = "Earth",
        url = "https://rickandmortyapi.com/api/location/20"
    ),
    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
    episode = listOf(
        "https://rickandmortyapi.com/api/episode/1",
        "https://rickandmortyapi.com/api/episode/2"
    ),
    url = "https://rickandmortyapi.com/api/character/1",
    created = "2017-11-04T18:48:46.250Z"
)

val expectedCharacter = CharacterPresentationModel(
    episode = listOf(
        "https://rickandmortyapi.com/api/episode/1",
        "https://rickandmortyapi.com/api/episode/2"
    ),
    id = 1,
    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
    locationName = "Earth",
    originName = "Earth",
    name = "Rick Sanchez",
    species = "Human",
    status = "Alive",
    type = "type",
    url = "https://rickandmortyapi.com/api/character/1"
)

internal class CharactersViewModelTest {
    @MockK
    lateinit var rickAndMortyRepository: RickAndMortyRepository

    private lateinit var classUnderTest: CharactersViewModel

    @BeforeEach
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(Dispatchers.Unconfined)
        classUnderTest = CharactersViewModel(rickAndMortyRepository = rickAndMortyRepository)
    }

    @Test
    fun `Given successful when onFetchCharacters returns characters`() = runTest {
        coEvery { rickAndMortyRepository.fetchCharacters() }.returns(
            listOf(givenCharacter)
        )

        // when
        classUnderTest.fetchCharacters()
        val actualValue = classUnderTest.characters.value

        // Then
        val expectedResult = Success(listOf(expectedCharacter))
        coVerify { rickAndMortyRepository.fetchCharacters() }
        assertEquals(expectedResult, actualValue)
    }
}
