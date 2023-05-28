package uz.alpha.icmedaisaratonai.presentation.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import uz.alpha.icmedaisaratonai.databinding.DialogScoreBinding

class ScoreDialog(ctx:Context) :Dialog(ctx){

    private lateinit var binding: DialogScoreBinding

    //private val viewModel by viewModels<MedViewModelImpl>()

    private var scoreListener: ((String) -> Unit)? = null

    fun setScore(block: (String) -> Unit) {
        scoreListener = block
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DialogScoreBinding.inflate(layoutInflater)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(binding.root)






    }
}