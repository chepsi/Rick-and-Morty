package kmm.rickandmorty.app.data.datasource.remote.fakes

import kmm.rickandmorty.app.data.model.EpisodeDataModel
import kmm.rickandmorty.app.domain.models.EpisodeDomainModel

const val episodes = """{
  "info": {
    "count": 51,
    "pages": 3,
    "next": "https://rickandmortyapi.com/api/episode?page=2",
    "prev": null
  },
  "results": [
    {
      "id": 1,
      "name": "Pilot",
      "air_date": "December 2, 2013",
      "episode": "S01E01",
      "characters": [
        "https://rickandmortyapi.com/api/character/1",
        "https://rickandmortyapi.com/api/character/2"
      ],
      "url": "https://rickandmortyapi.com/api/episode/1",
      "created": "2017-11-10T12:56:33.798Z"
    }
  ]
}
"""

val fakeEpisodeDataModel = EpisodeDataModel(
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
val fakeEpisodeDomainModel = EpisodeDomainModel(
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
