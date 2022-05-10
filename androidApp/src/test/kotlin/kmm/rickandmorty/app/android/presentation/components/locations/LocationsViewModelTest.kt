package kmm.rickandmorty.app.android.presentation.components.locations

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kmm.rickandmorty.app.android.presentation.components.locations.model.LocationPresentationModel
import kmm.rickandmorty.app.android.presentation.components.locations.model.LocationsUiState.Success
import kmm.rickandmorty.app.domain.models.LocationDomainModel
import kmm.rickandmorty.app.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

val givenLocation = LocationDomainModel(
    created = "2017-11-10T12:42:04.162Z",
    dimension = "Dimension C-137",
    id = 1,
    name = "earth",
    residents = listOf("resident-1", "resident-2"),
    type = "Planet",
    url = "https://rickandmortyapi.com/api/location/1"
)

val expectedLocation = LocationPresentationModel(
    created = "2017-11-10T12:42:04.162Z",
    dimension = "Dimension C-137",
    id = 1,
    name = "earth",
    residents = listOf("resident-1", "resident-2"),
    type = "Planet",
    url = "https://rickandmortyapi.com/api/location/1"
)

internal class LocationsViewModelTest {

    @MockK
    lateinit var rickAndMortyRepository: RickAndMortyRepository

    private lateinit var classUnderTest: LocationsViewModel

    @BeforeEach
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(Dispatchers.Unconfined)
        classUnderTest = LocationsViewModel(rickAndMortyRepository = rickAndMortyRepository)
    }

    @Test
    fun `Given successful execution When onFetchLocations returns list of locations`() {
        coEvery { rickAndMortyRepository.fetchLocations() }.returns(
            listOf(givenLocation)
        )

        // when
        classUnderTest.fetchLocations()
        val actualValue = classUnderTest.locations.value

        // Then
        val expectedResult = Success(listOf(expectedLocation))
        coVerify { rickAndMortyRepository.fetchLocations() }
        assertEquals(expectedResult, actualValue)
    }
}
