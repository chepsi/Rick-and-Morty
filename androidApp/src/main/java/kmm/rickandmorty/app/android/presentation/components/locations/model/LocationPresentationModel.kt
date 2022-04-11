package kmm.rickandmorty.app.android.presentation.components.locations.model

data class LocationPresentationModel(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: Collection<String>,
    val type: String,
    val url: String
)
