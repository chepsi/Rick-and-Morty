package kmm.rickandmorty.app

import io.ktor.client.HttpClient
import kmm.rickandmorty.app.data.datasource.remote.RickAndMortyRemoteDataSource
import kmm.rickandmorty.app.data.datasource.remote.RickAndMortyRemoteSource
import kmm.rickandmorty.app.data.httpClient
import kmm.rickandmorty.app.data.repository.RickAndMortyDataRepository
import kmm.rickandmorty.app.domain.repository.RickAndMortyRepository
import org.koin.dsl.module

fun appModule() = module {
    single<HttpClient> { httpClient }
    factory<RickAndMortyRemoteSource> { RickAndMortyRemoteDataSource(get()) }
    factory<RickAndMortyRepository> { RickAndMortyDataRepository(get()) }
}
