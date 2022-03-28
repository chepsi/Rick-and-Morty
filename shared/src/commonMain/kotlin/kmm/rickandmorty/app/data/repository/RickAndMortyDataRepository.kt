package kmm.rickandmorty.app.data.repository

import kmm.rickandmorty.app.data.datasource.remote.RickAndMortyRemoteSource
import kmm.rickandmorty.app.data.mapper.toDomain
import kmm.rickandmorty.app.domain.repository.RickAndMortyRepository

class RickAndMortyDataRepository(
    private val rickAndMortyRemoteSource: RickAndMortyRemoteSource
) : RickAndMortyRepository {
    override suspend fun fetchEpisodes() =
        rickAndMortyRemoteSource.fetchEpisodes().map { episode -> episode.toDomain() }

    override suspend fun fetchCharacters() =
        rickAndMortyRemoteSource.fetchCharacters().map { character -> character.toDomain() }

    override suspend fun fetchLocations() =
        rickAndMortyRemoteSource.fetchLocations().map { location -> location.toDomain() }
}
