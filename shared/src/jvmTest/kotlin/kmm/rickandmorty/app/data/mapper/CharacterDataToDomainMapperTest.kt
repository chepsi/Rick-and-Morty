package kmm.rickandmorty.app.data.mapper

import kmm.rickandmorty.app.data.model.CharacterDataModel
import kmm.rickandmorty.app.data.model.CharacterDataModel.CharacterLocation
import kmm.rickandmorty.app.data.model.CharacterDataModel.CharacterOrigin
import kmm.rickandmorty.app.domain.models.CharacterDomainModel
import kotlin.test.Test
import kotlin.test.assertEquals

private val givenCharacter = CharacterDataModel(
    id = 1,
    name = "Rick Sanchez",
    status = "Alive",
    species = "Human",
    type = "",
    gender = "Male",
    origin = CharacterOrigin(
        name = "Earth",
        url = "https://rickandmortyapi.com/api/location/1"
    ),
    location = CharacterLocation(
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
private val expectedCharacter = CharacterDomainModel(
    id = 1,
    name = "Rick Sanchez",
    status = "Alive",
    species = "Human",
    type = "",
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

internal class CharacterDataToDomainMapperTest {

    @Test
    fun `Given character data model when toDomain then returns character domain model`() {
        val actual = givenCharacter.toDomain()

        assertEquals(expectedCharacter, actual)
    }
}
