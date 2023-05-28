package uz.alpha.icmedaisaratonai.presentation.ui.screens

import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.alpha.icmedaisaratonai.R
import uz.alpha.icmedaisaratonai.data.local.localstorage.SharedPref
import uz.alpha.icmedaisaratonai.databinding.ScreenSettingsBinding
import java.util.*

class SettingsScreen: DialogFragment(R.layout.screen_settings)  {

    private  val sharedPreference= SharedPref.getInstance()
    private  val  binding by viewBinding(ScreenSettingsBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDialog()?.setCancelable(false)

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.startScreen)
        }


//        when (sharedPreference?.language) {
//            "uz" -> {
//                binding.uzImage.visibility = View.VISIBLE
//                binding.ruImage.visibility = View.GONE
//            }
//            "ru" -> {
//                binding.uzImage.visibility = View.GONE
//                binding.ruImage.visibility = View.VISIBLE
//            }
//            else -> {
//                binding.ruImage.visibility = View.GONE
//                binding.uzImage.visibility = View.GONE
//            }
//        }


        binding.l2.setOnClickListener {
            val language = "ru"
            setLocate(language)
//            binding.uzImage.visibility = View.GONE
//            binding.ruImage.visibility = View.VISIBLE
            binding.txtUz.text = "Узбекский"
            binding.txtRu.text = "Русский"
            binding.txt.text="Язык"
        }

        binding.l1.setOnClickListener {
            val language = "uz"
            setLocate(language)
//            binding.uzImage.visibility = View.VISIBLE
//            binding.ruImage.visibility = View.GONE
            binding.txtUz.text = "O'zbekcha"
            binding.txtRu.text = "Ruscha"
            binding.txt.text="Til"
        }


    }


    private fun setLocate(language: String) {
        val resources: Resources = resources
        val metric: DisplayMetrics = resources.displayMetrics
        val configuration = resources.configuration
        configuration.locale = Locale(language)
        resources.updateConfiguration(configuration, metric)
        onConfigurationChanged(configuration)
        SharedPref.getInstance()?.language = language
    }

    override fun onResume() {
        super.onResume()
        val params = dialog!!.window!!.attributes
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params
    }
}