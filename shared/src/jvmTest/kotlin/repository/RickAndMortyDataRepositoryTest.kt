package repository

import datasource.remote.fakes.expectedCharacterDomainModel
import datasource.remote.fakes.fakeEpisodeDataModel
import datasource.remote.fakes.fakeEpisodeDomainModel
import datasource.remote.fakes.fakeLocationDataModel
import datasource.remote.fakes.fakeLocationDomainModel
import datasource.remote.fakes.givenCharacterDataModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kmm.rickandmorty.app.data.datasource.remote.RickAndMortyRemoteSource
import kmm.rickandmorty.app.data.repository.RickAndMortyDataRepository
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class RickAndMortyDataRepositoryTest {

    @MockK
    private lateinit var classUnderTest: RickAndMortyDataRepository

    @MockK
    private lateinit var rickAndMortyRemoteSource: RickAndMortyRemoteSource

    @BeforeTest
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        classUnderTest = RickAndMortyDataRepository(rickAndMortyRemoteSource)
    }

    @Test
    fun `Given fetchCharacters is called then it returns characters`() = runBlocking {
        // Given
        coEvery { rickAndMortyRemoteSource.fetchCharacters() }.returns(
            listOf(
                givenCharacterDataModel
            )
        )

        // When
        val actual = classUnderTest.fetchCharacters()

        // Then
        val expected = listOf(expectedCharacterDomainModel)
        assertEquals(expected, actual)
    }

    @Test
    fun `Given fetchLocations is called then it returns locations`() = runBlocking {
        coEvery { rickAndMortyRemoteSource.fetchLocations() }.returns(listOf(fakeLocationDataModel))

        // When
        val actual = classUnderTest.fetchLocations()

        // Then
        val expected = listOf(fakeLocationDomainModel)
        assertEquals(expected, actual)
    }

    @Test
    fun `Given fetchEpisodes is called then it returns episodes`() = runBlocking {
        coEvery { rickAndMortyRemoteSource.fetchEpisodes() }.returns(listOf(fakeEpisodeDataModel))

        // When
        val actual = classUnderTest.fetchEpisodes()

        // Then
        val expected = listOf(fakeEpisodeDomainModel)
        assertEquals(expected, actual)
    }
}
