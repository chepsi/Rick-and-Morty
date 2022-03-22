package kmm.rickandmorty.app.domain.repository

import kmm.rickandmorty.app.domain.models.CharacterDomainModel
import kmm.rickandmorty.app.domain.models.EpisodeDomainModel
import kmm.rickandmorty.app.domain.models.LocationDomainModel

interface RickAndMortyRepository {
    suspend fun fetchEpisodes(): Collection<EpisodeDomainModel>
    suspend fun fetchCharacters(): Collection<CharacterDomainModel>
    suspend fun fetchLocations(): Collection<LocationDomainModel>
}
