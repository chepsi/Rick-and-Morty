package kmm.rickandmorty.app.data.mapper

import kmm.rickandmorty.app.data.model.EpisodeDataModel
import kmm.rickandmorty.app.domain.models.EpisodeDomainModel

fun EpisodeDataModel.toDomain() = EpisodeDomainModel(
    airDate = airDate,
    characters = characters,
    created = created,
    episode = episode,
    id = id,
    name = name,
    url = url
)
