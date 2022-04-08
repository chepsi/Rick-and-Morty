package kmm.rickandmorty.app.android.presentation.components.characters.model

data class CharacterPresentationModel(
    val episode: List<String>,
    val id: Int,
    val image: String,
    val locationName: String,
    val originName: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
