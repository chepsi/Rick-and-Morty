package kmm.rickandmorty.app.data.datasource.mapper

import kmm.rickandmorty.app.data.datasource.remote.model.CharactersApiModel
import kmm.rickandmorty.app.data.model.CharacterDataModel
import kotlin.test.Test
import kotlin.test.assertEquals

class CharacterApiToDataMapperTest {
    private val givenCharacter0 = CharactersApiModel.Result(
        id = 1,
        name = "Rick Sanchez",
        status = "Alive",
        species = "Human",
        type = "",
        gender = "Male",
        origin = CharactersApiModel.Result.Origin(
            name = "Earth",
            url = "https://rickandmortyapi.com/api/location/1"
        ),
        location = CharactersApiModel.Result.Location(
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
    private val givenCharacter1 = CharactersApiModel.Result(
        id = 2,
        name = "Johnny Depp",
        status = "Alive",
        species = "Human",
        type = "",
        gender = "Male",
        origin = CharactersApiModel.Result.Origin(
            name = "Earth",
            url = "https://rickandmortyapi.com/api/location/1"
        ),
        location = CharactersApiModel.Result.Location(
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
    private val givenCharacterApiModel = CharactersApiModel(
        info = CharactersApiModel.Info(
            count = 826,
            pages = 42,
            next = "https://rickandmortyapi.com/api/character/?page=2",
            prev = null
        ),
        results = listOf(givenCharacter0, givenCharacter1)
    )
    private val expectedCharacter0 = CharacterDataModel(
        id = 1,
        name = "Rick Sanchez",
        status = "Alive",
        species = "Human",
        type = "",
        gender = "Male",
        origin = CharacterDataModel.CharacterOrigin(
            name = "Earth",
            url = "https://rickandmortyapi.com/api/location/1"
        ),
        location = CharacterDataModel.CharacterLocation(
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
    private val expectedCharacter1 = CharacterDataModel(
        id = 2,
        name = "Johnny Depp",
        status = "Alive",
        species = "Human",
        type = "",
        gender = "Male",
        origin = CharacterDataModel.CharacterOrigin(
            name = "Earth",
            url = "https://rickandmortyapi.com/api/location/1"
        ),
        location = CharacterDataModel.CharacterLocation(
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

    @Test
    fun `Given characters api model when toData then returns character data model`() {
        val actual = givenCharacterApiModel.toData()
        val expected = listOf(expectedCharacter0, expectedCharacter1)

        assertEquals(expected, actual)
    }
}
