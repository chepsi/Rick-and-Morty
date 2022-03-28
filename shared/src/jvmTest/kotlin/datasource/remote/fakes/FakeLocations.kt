package datasource.remote.fakes

import kmm.rickandmorty.app.data.model.LocationDataModel
import kmm.rickandmorty.app.domain.models.LocationDomainModel

const val locations = """{
     "info": {
    "count": 126,
    "pages": 7,
    "next": "https://rickandmortyapi.com/api/location?page=2",
    "prev": null
  },
  "results": [
    {
      "id": 1,
      "name": "Earth",
      "type": "Planet",
      "dimension": "Dimension C-137",
      "residents": [
        "https://rickandmortyapi.com/api/character/1",
        "https://rickandmortyapi.com/api/character/2"
      ],
      "url": "https://rickandmortyapi.com/api/location/1",
      "created": "2017-11-10T12:42:04.162Z"
    }
  ]
}
"""

val fakeLocationDataModel = LocationDataModel(
    created = "2017-11-10T12:42:04.162Z",
    dimension = "Dimension C-137",
    id = 1,
    name = "earth",
    residents = listOf("resident-1", "resident-2"),
    type = "Planet",
    url = "https://rickandmortyapi.com/api/location/1"
)
val fakeLocationDomainModel = LocationDomainModel(
    created = "2017-11-10T12:42:04.162Z",
    dimension = "Dimension C-137",
    id = 1,
    name = "earth",
    residents = listOf("resident-1", "resident-2"),
    type = "Planet",
    url = "https://rickandmortyapi.com/api/location/1"
)
