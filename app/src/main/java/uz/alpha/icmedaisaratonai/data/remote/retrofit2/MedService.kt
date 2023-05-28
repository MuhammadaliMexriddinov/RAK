package uz.alpha.icmedaisaratonai.data.remote.retrofit2

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.alpha.icmedaisaratonai.data.remote.retrofit2.response.MedResponse

interface MedService {

    @GET("/rak")
    suspend fun register(
        @Query("GENDER") GENDER: String,
        @Query("AGE") AGE: String,
        @Query("SMOKING") SMOKING: String,
        @Query("YELLOW_FINGERS") YELLOW_FINGERS: String,
        @Query("ANXIETY") ANXIETY: String,
        @Query("PEER_PRESSURE") PEER_PRESSURE: String,
        @Query("CHRONIC_DISEASE") CHRONIC_DISEASE: String,
        @Query("WHEEZING") WHEEZING: String,
        @Query("FATIGUE") FATIGUE: String,
        @Query("ALLERGY") ALLERGY: String,
        @Query("ALCOHOL_CONSUMING") ALCOHOL_CONSUMING: String,
        @Query("COUGHING") COUGHING: String,
        @Query("SHORTNESS_OF_BREATH") SHORTNESS_OF_BREATH: String,
        @Query("SWALLOWING_DIFFICULTY") SWALLOWING_DIFFICULTY: String,
        @Query("CHEST_PAIN") CHEST_PAIN: String,
    ): Response<MedResponse>
}