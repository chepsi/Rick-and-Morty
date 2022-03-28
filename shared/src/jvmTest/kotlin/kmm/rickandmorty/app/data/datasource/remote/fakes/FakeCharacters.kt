package kmm.rickandmorty.app.data.datasource.remote.fakes

import kmm.rickandmorty.app.data.model.CharacterDataModel
import kmm.rickandmorty.app.data.model.CharacterDataModel.CharacterLocation
import kmm.rickandmorty.app.data.model.CharacterDataModel.CharacterOrigin
import kmm.rickandmorty.app.domain.models.CharacterDomainModel

const val charactersJsonString = """{
  "info": {
    "count": 826,
    "pages": 42,
    "next": "https://rickandmortyapi.com/api/character/?page=20",
    "prev": "https://rickandmortyapi.com/api/character/?page=18"
  },
  "results": [
    {
      "id": 361,
      "name": "Toxic Rick",
      "status": "Dead",
      "species": "Humanoid",
      "type": "Rick's Toxic Side",
      "gender": "Male",
      "origin": {
        "name": "Alien Spa",
        "url": "https://rickandmortyapi.com/api/location/64"
      },
      "location": {
        "name": "Earth",
        "url": "https://rickandmortyapi.com/api/location/20"
      },
      "image": "https://rickandmortyapi.com/api/character/avatar/361.jpeg",
      "episode": [
        "https://rickandmortyapi.com/api/episode/27"
      ],
      "url": "https://rickandmortyapi.com/api/character/361",
      "created": "2018-01-10T18:20:41.703Z"
    }
  ]
}
"""

val givenCharacterDataModel = CharacterDataModel(
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

val expectedCharacterDomainModel = CharacterDomainModel(
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
