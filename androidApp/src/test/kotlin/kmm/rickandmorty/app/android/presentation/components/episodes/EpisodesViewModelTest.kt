package kmm.rickandmorty.app.android.presentation.components.episodes

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kmm.rickandmorty.app.android.presentation.components.episodes.models.EpisodePresentationModel
import kmm.rickandmorty.app.android.presentation.components.episodes.models.EpisodesUiState.Success
import kmm.rickandmorty.app.domain.models.EpisodeDomainModel
import kmm.rickandmorty.app.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

val givenEpisode = EpisodeDomainModel(
    airDate = "December 9, 2013",
    characters = listOf(
        "https://rickandmortyapi.com/api/character/1",
        "https://rickandmortyapi.com/api/character/2"
    ),
    created = "2017-11-10T12:56:33.798Z",
    url = "https://rickandmortyapi.com/api/episode/2",
    episode = "S01E02",
    id = 2,
    name = "New Chapter"
)

val expectedEpisode = EpisodePresentationModel(
    airDate = "December 9, 2013",
    characters = listOf(
        "https://rickandmortyapi.com/api/character/1",
        "https://rickandmortyapi.com/api/character/2"
    ),
    created = "2017-11-10T12:56:33.798Z",
    url = "https://rickandmortyapi.com/api/episode/2",
    episode = "S01E02",
    id = 2,
    name = "New Chapter"
)

internal class EpisodesViewModelTest {
    @MockK
    lateinit var rickAndMortyRepository: RickAndMortyRepository

    private lateinit var classUnderTest: EpisodesViewModel

    @BeforeEach
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(Dispatchers.Unconfined)
        classUnderTest = EpisodesViewModel(rickAndMortyRepository = rickAndMortyRepository)
    }

    @Test
    fun `Given successful execution When fetching episodes Then updates the state`() {
        coEvery { rickAndMortyRepository.fetchEpisodes() }.returns(
            listOf(givenEpisode)
        )

        // when
        classUnderTest.fetchEpisodes()
        val actualValue = classUnderTest.episodes.value

        // Then
        val expectedResult = Success(listOf(expectedEpisode))
        coVerify { rickAndMortyRepository.fetchEpisodes() }
        assertEquals(expectedResult, actualValue)
    }
}
