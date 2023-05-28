package uz.alpha.icmedaisaratonai.repository

interface MedRepository {
    fun sendData(
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
    ): kotlinx.coroutines.flow.Flow<Result<String>>
}