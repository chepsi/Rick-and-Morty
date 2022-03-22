package kmm.rickandmorty.app.data.mapper

import kmm.rickandmorty.app.data.model.CharacterDataModel
import kmm.rickandmorty.app.domain.models.CharacterDomainModel
import kmm.rickandmorty.app.domain.models.CharacterDomainModel.CharacterLocation
import kmm.rickandmorty.app.domain.models.CharacterDomainModel.CharacterOrigin

fun CharacterDataModel.toDomain() = CharacterDomainModel(
    created = created,
    episode = episode,
    gender = gender,
    id = id,
    image = image,
    location = CharacterLocation(location.name, location.url),
    name = name,
    origin = CharacterOrigin(origin.name, origin.url),
    species = species,
    status = status,
    type = type,
    url = url
)
