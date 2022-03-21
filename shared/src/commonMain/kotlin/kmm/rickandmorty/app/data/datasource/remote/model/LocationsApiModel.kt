package kmm.rickandmorty.app.data.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationsApiModel(
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
        @SerialName("created")
        val created: String? = "",
        @SerialName("dimension")
        val dimension: String? = "",
        @SerialName("id")
        val id: Int? = 0,
        @SerialName("name")
        val name: String? = "",
        @SerialName("residents")
        val residents: List<String>? = emptyList(),
        @SerialName("type")
        val type: String? = "",
        @SerialName("url")
        val url: String? = ""
    )
}
