package kmm.rickandmorty.app.android.presentation.components.core

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kmm.rickandmorty.app.android.R
import kmm.rickandmorty.app.android.presentation.components.locations.mappers.StringResMapper

sealed class NavigationDestinations(
    var route: String,
    @DrawableRes var icon: Int,
    @StringRes var title: Int,
) {
    object Characters : NavigationDestinations("characters", R.drawable.ic_temp, R.string.page_one)
    object Locations : NavigationDestinations("locations", R.drawable.ic_temp, R.string.page_two)
    object Episodes : NavigationDestinations("episodes", R.drawable.ic_temp, R.string.page_three)
}
