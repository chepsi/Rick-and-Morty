package kmm.rickandmorty.app.data.model

data class LocationDataModel(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: Collection<String>,
    val type: String,
    val url: String
)
