package kmm.rickandmorty.app.android.presentation.components.core

import androidx.annotation.DrawableRes
import kmm.rickandmorty.app.android.R

sealed class NavigationDestinations(
    var route: String,
    @DrawableRes var icon: Int,
    var title: String
) {
    object Characters : NavigationDestinations("characters", R.drawable.ic_temp, "Characters")
    object Locations : NavigationDestinations("locations", R.drawable.ic_temp, "Locations")
    object Episodes : NavigationDestinations("episodes", R.drawable.ic_temp, "Episodes")
}
