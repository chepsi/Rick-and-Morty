package kmm.rickandmorty.app.data.datasource.remote

import kmm.rickandmorty.app.data.datasource.remote.model.CharactersApiModel
import kmm.rickandmorty.app.data.datasource.remote.model.EpisodesApiModel
import kmm.rickandmorty.app.data.datasource.remote.model.LocationsApiModel

interface RickAndMortyRemoteSource {
    suspend fun fetchCharacters(): CharactersApiModel
    suspend fun fetchLocations(): LocationsApiModel
    suspend fun fetchEpisodes(): EpisodesApiModel
}
