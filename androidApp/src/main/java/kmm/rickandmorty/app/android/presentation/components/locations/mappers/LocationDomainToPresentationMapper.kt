package kmm.rickandmorty.app.android.presentation.components.locations.mappers

import kmm.rickandmorty.app.android.presentation.components.locations.model.LocationPresentationModel
import kmm.rickandmorty.app.domain.models.LocationDomainModel

fun LocationDomainModel.toPresentation() = LocationPresentationModel(
    created = created,
    dimension = dimension,
    id = id,
    name = name,
    residents = residents,
    type = type,
    url = url
)
