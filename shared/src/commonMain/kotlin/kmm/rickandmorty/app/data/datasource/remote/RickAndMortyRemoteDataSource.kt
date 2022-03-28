package kmm.rickandmorty.app.data.datasource.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kmm.rickandmorty.app.data.datasource.mapper.toData
import kmm.rickandmorty.app.data.datasource.remote.model.CharactersApiModel
import kmm.rickandmorty.app.data.datasource.remote.model.EpisodesApiModel
import kmm.rickandmorty.app.data.datasource.remote.model.LocationsApiModel

class RickAndMortyRemoteDataSource(private val client: HttpClient) : RickAndMortyRemoteSource {
    private val baseUrl = "https://rickandmortyapi.com/api"
    private val charactersUrl = "$baseUrl/character"
    private val locationsUrl = "$baseUrl/location"
    private val episodesUrl = "$baseUrl/episode"

    override suspend fun fetchCharacters() = client.get<CharactersApiModel>(charactersUrl).toData()

    override suspend fun fetchLocations() = client.get<LocationsApiModel>(locationsUrl).toData()

    override suspend fun fetchEpisodes() = client.get<EpisodesApiModel>(episodesUrl).toData()
}
