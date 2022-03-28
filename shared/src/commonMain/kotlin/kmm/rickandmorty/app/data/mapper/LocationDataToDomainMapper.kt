package kmm.rickandmorty.app.data.mapper

import kmm.rickandmorty.app.data.model.LocationDataModel
import kmm.rickandmorty.app.domain.models.LocationDomainModel

fun LocationDataModel.toDomain() = LocationDomainModel(
    created = created,
    dimension = dimension,
    id = id,
    name = name,
    residents = residents,
    type = type,
    url = url
)
