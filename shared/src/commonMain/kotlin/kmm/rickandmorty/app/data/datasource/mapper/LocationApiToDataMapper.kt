package kmm.rickandmorty.app.data.datasource.mapper

import kmm.rickandmorty.app.data.datasource.remote.model.LocationsApiModel
import kmm.rickandmorty.app.data.model.LocationDataModel

fun LocationsApiModel.toData(): Collection<LocationDataModel> = results?.map { location ->
    LocationDataModel(
        created = location.created.orEmpty(),
        dimension = location.dimension.orEmpty(),
        id = location.id ?: 0,
        name = location.name.orEmpty(),
        residents = location.residents ?: emptyList(),
        type = location.type.orEmpty(),
        url = location.url.orEmpty()
    )
} ?: emptyList()
