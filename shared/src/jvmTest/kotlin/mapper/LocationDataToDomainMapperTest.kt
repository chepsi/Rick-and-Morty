package mapper

import kmm.rickandmorty.app.data.mapper.toDomain
import kmm.rickandmorty.app.data.model.LocationDataModel
import kmm.rickandmorty.app.domain.models.LocationDomainModel
import kotlin.test.Test
import kotlin.test.assertEquals

private val givenLocation = LocationDataModel(
    created = "2017-11-10T12:42:04.162Z",
    dimension = "Dimension C-137",
    id = 1,
    name = "earth",
    residents = listOf("resident-1", "resident-2"),
    type = "Planet",
    url = "https://rickandmortyapi.com/api/location/1"
)
private val expectedLocation = LocationDomainModel(
    created = "2017-11-10T12:42:04.162Z",
    dimension = "Dimension C-137",
    id = 1,
    name = "earth",
    residents = listOf("resident-1", "resident-2"),
    type = "Planet",
    url = "https://rickandmortyapi.com/api/location/1"
)

class LocationDataToDomainMapperTest {

    @Test
    fun `Given location data model when toDomain then returns location domain model`() {
        val actual = givenLocation.toDomain()

        assertEquals(expectedLocation, actual)
    }
}
