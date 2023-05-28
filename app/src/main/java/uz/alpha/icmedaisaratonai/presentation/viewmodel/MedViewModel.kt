package uz.alpha.icmedaisaratonai.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import retrofit2.http.Query

interface MedViewModel {
    // val openHomeScreenLiveData: MutableLiveData<Unit>
    val errorMessageLiveData: MutableLiveData<String>
    val notConnectionLiveData: MutableLiveData<Unit>
    val succesLiveData: MutableLiveData<String>

    // val changeButtonStatusLiveData : MutableLiveData<Boolean>
    val progressLiveData: MutableLiveData<Boolean>
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
    )


}