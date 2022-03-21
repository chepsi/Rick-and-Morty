package kmm.rickandmorty.app.data

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json

val httpClient = HttpClient() {
    install(JsonFeature) {
        val json = Json { ignoreUnknownKeys = true }
        serializer = KotlinxSerializer(json)
    }
}
