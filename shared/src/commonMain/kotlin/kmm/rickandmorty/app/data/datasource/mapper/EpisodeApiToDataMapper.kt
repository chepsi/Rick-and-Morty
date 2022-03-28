package kmm.rickandmorty.app.data.datasource.mapper

import kmm.rickandmorty.app.data.datasource.remote.model.EpisodesApiModel
import kmm.rickandmorty.app.data.model.EpisodeDataModel

fun EpisodesApiModel.toData(): Collection<EpisodeDataModel> = results?.map { episode ->
    EpisodeDataModel(
        airDate = episode.airDate.orEmpty(),
        characters = episode.characters ?: emptyList(),
        created = episode.created.orEmpty(),
        episode = episode.episode.orEmpty(),
        id = episode.id ?: 0,
        name = episode.name.orEmpty(),
        url = episode.url.orEmpty()
    )
} ?: emptyList()
