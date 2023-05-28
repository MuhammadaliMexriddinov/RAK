package uz.alpha.icmedaisaratonai.presentation.ui.screens

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.alpha.icmedaisaratonai.R
import uz.alpha.icmedaisaratonai.databinding.ScreenInformationappBinding

class AboutScreen:Fragment(R.layout.screen_informationapp) {


    private  val  binding by viewBinding(ScreenInformationappBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.txtWeb.setOnClickListener {
            try {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://ic.tashpmi.uz/"))
                startActivity(browserIntent)
            }catch (e:Exception){
                Toast.makeText(requireContext(), "not found!!!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.txtFacebook.setOnClickListener {
            try {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100091473694528&mibextid=ZbWKwL"))
                startActivity(browserIntent)
            }catch (e:Exception){
                Toast.makeText(requireContext(), "not found!!!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.txtTelegram.setOnClickListener {
            val group_telegram = Intent (Intent.ACTION_VIEW, Uri.parse("https://t.me/medinnovouz"))
            startActivity(group_telegram)
        }

        binding.txtGmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val recipients = arrayOf("catsi@tashpmi.uz")
            intent.putExtra(Intent.EXTRA_EMAIL, recipients)
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject text here...")
            intent.putExtra(Intent.EXTRA_TEXT, "Body of the content here...")
            intent.putExtra(Intent.EXTRA_CC, "mailcc@gmail.com")
            intent.type = "text/html"
            intent.setPackage("com.google.android.gm")
            startActivity(Intent.createChooser(intent, "Send mail"))
//                    Toast.makeText(requireContext(), "Gmail", Toast.LENGTH_SHORT).show()
        }
    }


}