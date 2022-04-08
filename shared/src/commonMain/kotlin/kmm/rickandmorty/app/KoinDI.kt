package kmm.rickandmorty.app

import io.ktor.client.HttpClient
import kmm.rickandmorty.app.data.datasource.remote.RickAndMortyRemoteDataSource
import kmm.rickandmorty.app.data.datasource.remote.RickAndMortyRemoteSource
import kmm.rickandmorty.app.data.httpClient
import kmm.rickandmorty.app.data.repository.RickAndMortyDataRepository
import kmm.rickandmorty.app.domain.repository.RickAndMortyRepository
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun initKoin(appModule: Module) = startKoin {
    modules(appModule, commonModule)
}

val commonModule = module {
    single<HttpClient> { httpClient }
    factory<RickAndMortyRemoteSource> { RickAndMortyRemoteDataSource(get()) }
    factory<RickAndMortyRepository> { RickAndMortyDataRepository(get()) }
}
