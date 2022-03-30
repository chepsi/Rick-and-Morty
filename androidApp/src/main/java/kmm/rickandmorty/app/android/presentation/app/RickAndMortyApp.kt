package kmm.rickandmorty.app.android.presentation.app

import android.app.Application

class RickAndMortyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
    }
}
