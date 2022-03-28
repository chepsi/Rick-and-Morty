package kmm.rickandmorty.app.domain.models

data class LocationDomainModel(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: Collection<String>,
    val type: String,
    val url: String
)
