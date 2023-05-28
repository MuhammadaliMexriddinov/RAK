package uz.alpha.icmedaisaratonai.presentation.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.alpha.icmedaisaratonai.R
import uz.alpha.icmedaisaratonai.databinding.ScreenExpandBinding

class Screen_ex:Fragment(R.layout.screen_expand) {

    private  val binding by viewBinding(ScreenExpandBinding::bind)
    var isExpanded: Boolean = false
    private var lastExpandItemPos = -1


    override fun onViewCreated(view: View, savedInstanceState: Bundle?)= with(binding) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.t1.setOnClickListener {
            if (isExpanded) {
                expandableLayout.collapse()
                toggleMyLayout()
                btn1.setImageResource(R.drawable.baseline_expand_more_24)
            }
            else {
                isExpanded = !isExpanded
                expandableLayout.expand()
                btn1.setImageResource(R.drawable.baseline_expand_less_24)
            }
        }


        binding.t2.setOnClickListener {
            if (isExpanded) {
                expandableLayout2.collapse()
                toggleMyLayout()
                btn2.setImageResource(R.drawable.baseline_expand_more_24)
            }
            else {
                isExpanded = !isExpanded
                expandableLayout2.expand()
                btn2.setImageResource(R.drawable.baseline_expand_less_24)
            }
        }

    }

    private fun toggleMyLayout() {
        isExpanded = false
     //   binding.expandableLayout.collapse()
        lastExpandItemPos = -1
    }

}