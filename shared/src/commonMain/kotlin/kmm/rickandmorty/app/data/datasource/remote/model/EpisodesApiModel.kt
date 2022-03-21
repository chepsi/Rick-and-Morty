package kmm.rickandmorty.app.data.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodesApiModel(
    @SerialName("info")
    val info: Info? = Info(),
    @SerialName("results")
    val results: List<Result>? = listOf()
) {
    @Serializable
    data class Info(
        @SerialName("count")
        val count: Int? = 0,
        @SerialName("next")
        val next: String? = "",
        @SerialName("pages")
        val pages: Int? = 0,
        @SerialName("prev")
        val prev: String? = ""
    )

    @Serializable
    data class Result(
        @SerialName("air_date")
        val airDate: String? = "",
        @SerialName("characters")
        val characters: List<String>? = listOf(),
        @SerialName("created")
        val created: String? = "",
        @SerialName("episode")
        val episode: String? = "",
        @SerialName("id")
        val id: Int? = 0,
        @SerialName("name")
        val name: String? = "",
        @SerialName("url")
        val url: String? = ""
    )
}
