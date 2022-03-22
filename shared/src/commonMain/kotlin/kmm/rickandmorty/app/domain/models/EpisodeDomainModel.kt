package kmm.rickandmorty.app.domain.models

data class EpisodeDomainModel(
    val airDate: String,
    val characters: Collection<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)
