package kmm.rickandmorty.app.android.presentation.components.episodes.mapper

import kmm.rickandmorty.app.android.presentation.components.episodes.models.EpisodePresentationModel
import kmm.rickandmorty.app.domain.models.EpisodeDomainModel

fun EpisodeDomainModel.toPresentation() = EpisodePresentationModel(
    airDate,
    characters.toList(),
    created,
    episode,
    id,
    name,
    url
)
