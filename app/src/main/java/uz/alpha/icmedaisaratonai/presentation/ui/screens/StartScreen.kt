package uz.alpha.icmedaisaratonai.presentation.ui.screens

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tapadoo.alerter.Alerter
import com.tapadoo.alerter.BuildConfig
import uz.alpha.icmedaisaratonai.R
import uz.alpha.icmedaisaratonai.data.local.localstorage.SharedPref
import uz.alpha.icmedaisaratonai.databinding.ScreenStartBinding
import java.util.*

class StartScreen : Fragment(R.layout.screen_start) {

    private var sharedPref = SharedPref.getInstance()
    private val binding by viewBinding(ScreenStartBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.statusBarColor =
            ContextCompat.getColor(requireContext(), R.color.intro) // 93 969 5113 bex

        if (sharedPref.language.toString() == "uz"
        ) binding.img.setImageResource(R.drawable.uzbekistan) else binding.img.setImageResource(R.drawable.russia)


        if (!binding.checkbox.isChecked) {
            binding.checkbox.setOnClickListener {
                binding.btnStart.setBackgroundResource(if (binding.checkbox.isChecked) R.drawable.shape3 else R.drawable.shape4)
            }
        }

        if (binding.checkbox.isChecked) {
            binding.btnStart.setBackgroundResource(R.drawable.shape4)
        }

        binding.btnStart.setOnClickListener {
            if (binding.checkbox.isChecked) {
                binding.checkbox.isChecked = false
                findNavController().navigate(StartScreenDirections.actionStartScreenToMainScreen())
            } else {
                Alerter.create(requireActivity())
                    .setText(getString(R.string.alert2))
                    .setBackgroundColorRes(R.color.purple_200)
                    .show()
            }
        }




        requireActivity().onBackPressedDispatcher.addCallback(this) {
            requireActivity().finish()
        }


        binding.linear1.setOnClickListener {
             findNavController().navigate(R.id.symptomScreen)
        }

        binding.linear2.setOnClickListener {
            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
                var shareMessage = "\nLet me recommend you this application\n\n"
                shareMessage =
                    """
                            ${shareMessage + "https://play.google.com/store/apps/details?id=" + uz.alpha.icmedaisaratonai.BuildConfig.APPLICATION_ID}


                            """.trimIndent()
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                startActivity(Intent.createChooser(shareIntent, "choose one"))
            } catch (e: Exception) {
                //e.toString();
            }
        }

        binding.linear3.setOnClickListener {
            findNavController().navigate(StartScreenDirections.actionStartScreenToScreenEx())
        }

        binding.linear4.setOnClickListener {
            findNavController().navigate(StartScreenDirections.actionStartScreenToAboutScreen2())
        }


        binding.img.setOnClickListener {
            showDialog()
        }


    }

    private fun showDialog() {
        val dialog = SettingsScreen()
        dialog.show(childFragmentManager, " ")
    }


}