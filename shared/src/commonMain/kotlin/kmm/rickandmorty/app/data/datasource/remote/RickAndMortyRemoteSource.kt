package kmm.rickandmorty.app.data.datasource.remote

import kmm.rickandmorty.app.data.model.CharacterDataModel
import kmm.rickandmorty.app.data.model.EpisodeDataModel
import kmm.rickandmorty.app.data.model.LocationDataModel

interface RickAndMortyRemoteSource {
    suspend fun fetchCharacters(): Collection<CharacterDataModel>
    suspend fun fetchLocations(): Collection<LocationDataModel>
    suspend fun fetchEpisodes(): Collection<EpisodeDataModel>
}
