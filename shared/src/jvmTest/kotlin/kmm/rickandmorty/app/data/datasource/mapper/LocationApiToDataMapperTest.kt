package kmm.rickandmorty.app.data.datasource.mapper

import kmm.rickandmorty.app.data.datasource.remote.model.LocationsApiModel
import kmm.rickandmorty.app.data.model.LocationDataModel
import kotlin.test.Test
import kotlin.test.assertEquals

class LocationApiToDataMapperTest {
    private val givenLocation0 = LocationsApiModel.Result(
        created = "2017-11-10T12:42:04.162Z",
        dimension = "Dimension C-137",
        id = 1,
        name = "earth",
        residents = listOf("resident-1", "resident-2"),
        url = "https://rickandmortyapi.com/api/location/1",
        type = "Planet"
    )
    private val givenLocation1 = LocationsApiModel.Result(
        created = "2017-11-10T12:42:04.162Z",
        dimension = "Dimension C-138",
        id = 2,
        name = "mars",
        residents = listOf("resident-1", "resident-2"),
        url = "https://rickandmortyapi.com/api/location/2",
        type = "Planet"
    )
    private val givenLocations = LocationsApiModel(
        info = LocationsApiModel.Info(
            count = 1,
            next = "https://rickandmortyapi.com/api/location?page=2",
            pages = 10,
            prev = null
        ),
        results = listOf(givenLocation0, givenLocation1)
    )
    private val expectedLocation0 = LocationDataModel(
        created = "2017-11-10T12:42:04.162Z",
        dimension = "Dimension C-137",
        id = 1,
        name = "earth",
        residents = listOf("resident-1", "resident-2"),
        type = "Planet",
        url = "https://rickandmortyapi.com/api/location/1"
    )
    private val expectedLocation1 = LocationDataModel(
        created = "2017-11-10T12:42:04.162Z",
        dimension = "Dimension C-138",
        id = 2,
        name = "mars",
        residents = listOf("resident-1", "resident-2"),
        type = "Planet",
        url = "https://rickandmortyapi.com/api/location/2"
    )

    @Test
    fun `given Location Api Model when toData returns location data model`() {
        val actual = givenLocations.toData()
        val expected = listOf(expectedLocation0, expectedLocation1)
        assertEquals(expected, actual)
    }
}
