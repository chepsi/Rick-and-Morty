package kmm.rickandmorty.app.android.presentation.components.episodes.models

data class EpisodePresentationModel(
    val airDate: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)
