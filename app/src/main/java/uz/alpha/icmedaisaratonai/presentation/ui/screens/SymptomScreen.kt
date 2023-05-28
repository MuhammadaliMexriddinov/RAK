package uz.alpha.icmedaisaratonai.presentation.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.alpha.icmedaisaratonai.R
import uz.alpha.icmedaisaratonai.databinding.ScreenSymptomBinding

class SymptomScreen:Fragment(R.layout.screen_symptom) {

    private  val binding by viewBinding(ScreenSymptomBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

    }
}