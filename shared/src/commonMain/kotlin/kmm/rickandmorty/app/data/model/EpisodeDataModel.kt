package kmm.rickandmorty.app.data.model

data class EpisodeDataModel(
    val airDate: String,
    val characters: Collection<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)
