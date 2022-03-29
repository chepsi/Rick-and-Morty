package kmm.rickandmorty.app.android.presentation.app

import android.app.Application
import kmm.rickandmorty.app.initKoin

class RickAndMortyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        initKoin {

        }
    }

}