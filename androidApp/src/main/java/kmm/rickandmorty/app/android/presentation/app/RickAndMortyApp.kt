package kmm.rickandmorty.app.android.presentation.app

import android.app.Application
import android.content.Context
import kmm.rickandmorty.app.android.presentation.components.characters.CharactersViewModel
import kmm.rickandmorty.app.android.presentation.components.episodes.EpisodesViewModel
import kmm.rickandmorty.app.android.presentation.components.locations.LocationsViewModel
import kmm.rickandmorty.app.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class RickAndMortyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@RickAndMortyApp)
            androidLogger()
            modules(appModule() + androidModule())
        }
    }

    private fun androidModule() =
        module {
            single<Context> { this@RickAndMortyApp }
            viewModel { CharactersViewModel(get()) }
            viewModel { LocationsViewModel(get()) }
            viewModel { EpisodesViewModel(get()) }
        }
}
