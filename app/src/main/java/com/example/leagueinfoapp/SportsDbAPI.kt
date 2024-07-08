
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SportsDbAPI {
    @GET("searchteams.php")
    suspend fun searchTeams(@Query("t") query: String): TeamsResponse

    @GET("lookupequipment.php")
    suspend fun lookupEquipment(@Query("id") teamId: String): EquipmentResponse
}

fun createTheSportsDbApi(): SportsDbAPI {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(SportsDbAPI::class.java)
}