package kmm.rickandmorty.app.android.presentation.app

import android.app.Application
import android.content.Context
import kmm.rickandmorty.app.android.presentation.components.characters.CharactersViewModel
import kmm.rickandmorty.app.initKoin
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class RickAndMortyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        initKoin(
            module {
                single<Context> { this@RickAndMortyApp }
                viewModel { CharactersViewModel(get()) }
            }
        )
    }
}
