package datasource.mapper

import kmm.rickandmorty.app.data.datasource.mapper.toData
import kmm.rickandmorty.app.data.datasource.remote.model.EpisodesApiModel
import kmm.rickandmorty.app.data.model.EpisodeDataModel
import kotlin.test.Test
import kotlin.test.assertEquals

class EpisodeApiToDataMapperTest {
    private val givenEpisode0 = EpisodesApiModel.Result(
        airDate = "December 2, 2013",
        characters = listOf(
            "https://rickandmortyapi.com/api/character/1",
            "https://rickandmortyapi.com/api/character/2"
        ),
        created = "2017-11-10T12:56:33.798Z",
        url = "https://rickandmortyapi.com/api/episode/1",
        episode = "S01E01",
        id = 1,
        name = "Pilot"
    )
    private val givenEpisode1 = EpisodesApiModel.Result(
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
    private val givenEpisodesApiModel = EpisodesApiModel(
        info = EpisodesApiModel.Info(
            count = 2,
            next = "https://rickandmortyapi.com/api/episode?page=2",
            prev = null,
            pages = 5
        ),
        results = listOf(givenEpisode0, givenEpisode1)
    )

    private val expectedEpisode0 = EpisodeDataModel(
        airDate = "December 2, 2013",
        characters = listOf(
            "https://rickandmortyapi.com/api/character/1",
            "https://rickandmortyapi.com/api/character/2"
        ),
        created = "2017-11-10T12:56:33.798Z",
        url = "https://rickandmortyapi.com/api/episode/1",
        episode = "S01E01",
        id = 1,
        name = "Pilot"
    )
    private val expectedEpisode1 = EpisodeDataModel(
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

    @Test
    fun `Given episodes api model When to Api then returns episodes data model`() {
        val actual = givenEpisodesApiModel.toData()
        val expected = listOf(expectedEpisode0, expectedEpisode1)

        assertEquals(expected, actual)
    }
}
