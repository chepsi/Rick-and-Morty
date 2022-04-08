package kmm.rickandmorty.app.android.presentation.components.characters.mapper

import kmm.rickandmorty.app.android.presentation.components.characters.model.CharacterPresentationModel
import kmm.rickandmorty.app.domain.models.CharacterDomainModel

fun CharacterDomainModel.toPresentation() = CharacterPresentationModel(
    episode = episode,
    id = id,
    image = image,
    locationName = location.name,
    originName = origin.name,
    name = name,
    species = species,
    status = status,
    type = type,
    url = url
)
