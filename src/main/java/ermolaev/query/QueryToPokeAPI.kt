package ermolaev.query

import java.io.IOException
import java.net.URI
import java.net.URISyntaxException
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

object QueryToPokeAPI {
    private const val baseURL = "https://pokeapi.co/api/v2/pokemon/"
    fun sendQuery(query: String): String? {
        var response: HttpResponse<String?>? = null
        response = try {
            val request = HttpRequest.newBuilder(URI(baseURL + query)).build()
            val client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build()
            client.send(request, HttpResponse.BodyHandlers.ofString())
        } catch (e: URISyntaxException) {
            throw RuntimeException(e)
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
        return response?.body()
    }
}
