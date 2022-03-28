package kmm.rickandmorty.app.domain.models

data class CharacterDomainModel(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterLocation,
    val name: String,
    val origin: CharacterOrigin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    data class CharacterLocation(
        val name: String,
        val url: String
    )

    data class CharacterOrigin(
        val name: String,
        val url: String
    )
}
