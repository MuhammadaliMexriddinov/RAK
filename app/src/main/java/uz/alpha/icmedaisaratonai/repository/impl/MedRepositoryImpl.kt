package uz.alpha.icmedaisaratonai.repository.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withTimeoutOrNull
import uz.alpha.icmedaisaratonai.data.remote.retrofit2.ApiClient
import uz.alpha.icmedaisaratonai.data.remote.retrofit2.ApiClient2
import uz.alpha.icmedaisaratonai.repository.MedRepository

class MedRepositoryImpl : MedRepository {

    private val api = ApiClient.getMedApi()
    private val api2 = ApiClient2.getMedApi()

    override fun sendData(
        GENDER: String,
        AGE: String,
        SMOKING: String,
        YELLOW_FINGERS: String,
        ANXIETY: String,
        PEER_PRESSURE: String,
        CHRONIC_DISEASE: String,
        WHEEZING: String,
        FATIGUE: String,
        ALLERGY: String,
        ALCOHOL_CONSUMING: String,
        COUGHING: String,
        SHORTNESS_OF_BREATH: String,
        SWALLOWING_DIFFICULTY: String,
        CHEST_PAIN: String,
    ): Flow<Result<String>> = flow<Result<String>> {
//        val response = authApi.login(AuthRequest.LoginRequest(password, phone))


        val response = withTimeoutOrNull(1500) {
            val response =
                api.register(
                    GENDER,
                    AGE,
                    SMOKING,
                    YELLOW_FINGERS,
                    ANXIETY,
                    PEER_PRESSURE,
                    CHRONIC_DISEASE,
                    WHEEZING,
                    FATIGUE,
                    ALLERGY,
                    ALCOHOL_CONSUMING,
                    COUGHING,
                    SHORTNESS_OF_BREATH,
                    SWALLOWING_DIFFICULTY,
                    CHEST_PAIN
                )
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Result.success(it.result))
                }
            }
        }
        if (response != null) {
            // Handle response
        } else {
            val response2 =
                api2.register(
                    GENDER,
                    AGE,
                    SMOKING,
                    YELLOW_FINGERS,
                    ANXIETY,
                    PEER_PRESSURE,
                    CHRONIC_DISEASE,
                    WHEEZING,
                    FATIGUE,
                    ALLERGY,
                    ALCOHOL_CONSUMING,
                    COUGHING,
                    SHORTNESS_OF_BREATH,
                    SWALLOWING_DIFFICULTY,
                    CHEST_PAIN
                )

            if (response2.isSuccessful) {
                response2.body()?.let {
                    emit(Result.success(it.result))
                }
            }
        }


    }.catch {
        emit(Result.failure(Exception(it.message)))

    }.flowOn(Dispatchers.IO)

}