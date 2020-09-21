package my.jalal.made.core.data.source.remote.network

import my.jalal.made.core.data.source.remote.response.GameResponse
import my.jalal.made.core.data.source.remote.response.ListGameResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    suspend fun getGameList(
        @Query("page") pageCount: Int,
        @Query("page_size") gameCountPerPage: Int
    ): ListGameResponse

    @GET("games/{id}")
    fun getGameDetail(
        @Path("id") gameId: String
    ): GameResponse
}