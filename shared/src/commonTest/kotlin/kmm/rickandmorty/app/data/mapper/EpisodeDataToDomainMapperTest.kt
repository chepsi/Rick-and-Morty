package kmm.rickandmorty.app.data.mapper

import kmm.rickandmorty.app.data.model.EpisodeDataModel
import kmm.rickandmorty.app.domain.models.EpisodeDomainModel
import kotlin.test.Test
import kotlin.test.assertEquals

private val givenEpisode = EpisodeDataModel(
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
private val expectedEpisode = EpisodeDomainModel(
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

class EpisodeDataToDomainMapperTest {

    @Test
    fun `Given episode data model when toDomain returns episode domain model`() {
        val actual = givenEpisode.toDomain()

        assertEquals(expectedEpisode, actual)
    }
}
