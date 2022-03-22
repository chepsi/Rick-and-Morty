package kmm.rickandmorty.app

import kmm.rickandmorty.app.data.datasource.remote.RickAndMortyRemoteDataSource
import kmm.rickandmorty.app.data.datasource.remote.RickAndMortyRemoteSource
import kmm.rickandmorty.app.data.httpClient
import kmm.rickandmorty.app.data.repository.RickAndMortyDataRepository
import kmm.rickandmorty.app.domain.repository.RickAndMortyRepository
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule)
}

// called by iOS etc
fun initKoin() = initKoin {}

val commonModule = module {
    single { httpClient }
    factory<RickAndMortyRemoteSource> { RickAndMortyRemoteDataSource(get()) }
    factory<RickAndMortyRepository> { RickAndMortyDataRepository(get()) }
}
