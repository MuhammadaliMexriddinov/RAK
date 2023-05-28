package uz.alpha.icmedaisaratonai.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import uz.alpha.icmedaisaratonai.presentation.viewmodel.MedViewModel
import uz.alpha.icmedaisaratonai.repository.impl.MedRepositoryImpl
import uz.alpha.icmedaisaratonai.utils.hasConnection

class MedViewModelImpl : MedViewModel, ViewModel() {
    private val repo = MedRepositoryImpl()
    override val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()
    override val notConnectionLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val succesLiveData: MutableLiveData<String> = MutableLiveData()
    override val progressLiveData: MutableLiveData<Boolean> = MutableLiveData()

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
    ) {
        progressLiveData.value = true
        if (!hasConnection()) {
            progressLiveData.value = false
            notConnectionLiveData.value = Unit
            return
        }


        viewModelScope.launch {
            repo.sendData(
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
            ).flowOn(Dispatchers.Main).collect {
                it.onSuccess {
                    progressLiveData.value = false
                    succesLiveData.value = it.toString()
                }

                it.onFailure {
                    progressLiveData.value = true
                    errorMessageLiveData.value = "NO INTERNET"
                }
            }
        }
    }
}