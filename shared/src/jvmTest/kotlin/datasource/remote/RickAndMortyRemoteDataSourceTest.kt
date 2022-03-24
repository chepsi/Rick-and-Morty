package datasource.remote

import datasource.remote.fakes.charactersJsonString
import datasource.remote.fakes.episodes
import datasource.remote.fakes.locations
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel
import kmm.rickandmorty.app.data.datasource.remote.RickAndMortyRemoteDataSource
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

@Suppress("IllegalIdentifier")
class RickAndMortyRemoteDataSourceTest {

    private lateinit var classUnderTest: RickAndMortyRemoteDataSource

    private fun getEngine(response: String) = MockEngine { _ ->
        respond(
            content = ByteReadChannel(response),
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }

    private fun getClient(engine: MockEngine) = HttpClient(engine) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(
                Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    @Test
    fun `fetchCharacters returns data correctly on success`() = runBlocking {
        val engine = getEngine(charactersJsonString)
        val client = getClient(engine)
        classUnderTest = RickAndMortyRemoteDataSource(client)

        val actual = classUnderTest.fetchCharacters()
        assertEquals(actual.size, 1)
    }

    @Test
    fun `fetchLocations returns data correctly on success`() = runBlocking {
        val engine = getEngine(locations)
        val client = getClient(engine)

        classUnderTest = RickAndMortyRemoteDataSource(client)

        val actual = classUnderTest.fetchLocations()

        assertEquals(actual.size, 1)
    }

    @Test
    fun `fetchEpisodes returns data on success`() = runBlocking {
        val engine = getEngine(episodes)
        val client = getClient(engine)

        classUnderTest = RickAndMortyRemoteDataSource(client)

        val actual = classUnderTest.fetchEpisodes()

        assertEquals(actual.size, 1)
    }
}
