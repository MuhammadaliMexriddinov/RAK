package uz.alpha.icmedaisaratonai.presentation.ui.screens

import android.app.AlertDialog
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tapadoo.alerter.Alerter
import uz.alpha.icmedaisaratonai.R
import uz.alpha.icmedaisaratonai.databinding.ScreenHomeBinding
import uz.alpha.icmedaisaratonai.databinding.ScreenMainBinding
import uz.alpha.icmedaisaratonai.presentation.viewmodel.impl.MedViewModelImpl
import uz.alpha.icmedaisaratonai.utils.hasConnection

class MainScreen : Fragment(R.layout.screen_main) {

    var score = 0
    var selectedAnswer = -1
    var index = 0
    var ball: Float = 0f
    var isChecked: Boolean = false
    private val binding by viewBinding(ScreenMainBinding::bind)
    private val radioButtons: ArrayList<View> = ArrayList()
    private val scores: ArrayList<String> = ArrayList()
    private val viewModel by viewModels<MedViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.progressLiveData.observe(this, progressObserver)

        viewModel.succesLiveData.observe(this) {
            if (it == "no_risk") {
                alertDialogShow(getString(R.string.d5))
            }

            if (it == "risk") {
                alertDialogShow(getString(R.string.d2))
            }
        }


    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        if (!hasConnection()) {
            Alerter.create(requireActivity())
                .setText("NO INTERNET")
                .setBackgroundColorRes(R.color.purple_200)
                .setDuration(5000)
                .show()
        }



        binding.apply {
            numbers.maxValue = 150
            numbers.minValue = 0
            var x = numbers.value

        }


        initData()

    }

    private val progressObserver = Observer<Boolean> {
        if (it) binding.verfiedProgress.show() else binding.verfiedProgress.hide()
    }


    fun alertDialogShow(txtResponse: String) {
        val builder = AlertDialog.Builder(requireContext())
        //set title for alert dialog
        builder.setTitle(getString(R.string.d1))
        //set message for alert dialog
        builder.setMessage(txtResponse)
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        //performing positive action
        builder.setPositiveButton(getString(R.string.d4)) { dialogInterface, which ->
            findNavController().navigate(R.id.screen_ex)
        }
        //performing cancel action
        builder.setNeutralButton(getString(R.string.d3)) { dialogInterface, which ->

        }
        //performing negative action
//        builder.setNegativeButton("No"){dialogInterface, which ->
//            Toast.makeText(requireContext(),"clicked No",Toast.LENGTH_LONG).show()
//        }
        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    fun initData() {
        radioButtons.add(binding.btnYes1)
        radioButtons.add(binding.btnNo1)

        radioButtons.add(binding.btnYes2)
        radioButtons.add(binding.btnNo2)

        radioButtons.add(binding.btnYes2)
        radioButtons.add(binding.btnNo2)

        radioButtons.add(binding.btnYes3)
        radioButtons.add(binding.btnNo3)

        radioButtons.add(binding.btnYes4)
        radioButtons.add(binding.btnNo4)

        radioButtons.add(binding.btnYes5)
        radioButtons.add(binding.btnNo5)

        radioButtons.add(binding.btnYes6)
        radioButtons.add(binding.btnNo6)

        radioButtons.add(binding.btnYes7)
        radioButtons.add(binding.btnNo7)

        radioButtons.add(binding.btnYes9)
        radioButtons.add(binding.btnNo9)

        radioButtons.add(binding.btnYes10)
        radioButtons.add(binding.btnNo10)

        radioButtons.add(binding.btnYes11)
        radioButtons.add(binding.btnNo11)

        radioButtons.add(binding.btnYes12)
        radioButtons.add(binding.btnNo12)

        radioButtons.add(binding.btnYes13)
        radioButtons.add(binding.btnNo13)

        radioButtons.add(binding.btnYes14)
        radioButtons.add(binding.btnNo14)

        radioButtons.add(binding.btnYes15)
        radioButtons.add(binding.btnNo15)


        radioButtons[0].setOnClickListener {
            scores.add("1")
            isChecked = true
            clearAllCheck()
            trueCheck(0)
            index = 0
            radioButtons[0].setBackgroundResource(R.drawable.shape_red)
        }


        radioButtons[1].setOnClickListener {
            scores.add("0")
            isChecked = true
            clearAllCheck()
            trueCheck(1)
            index = 1
            radioButtons[1].setBackgroundResource(R.drawable.shape_red)
        }

        radioButtons[2].setOnClickListener {
            scores.add("1")
            isChecked = true
            clearAllCheck()
            trueCheck(0)
            index = 0
            radioButtons[2].setBackgroundResource(R.drawable.shape_red)
        }


        radioButtons[3].setOnClickListener {
            scores.add("0")
            isChecked = true
            clearAllCheck()
            trueCheck(1)
            index = 1
            radioButtons[3].setBackgroundResource(R.drawable.shape_red)
        }

        radioButtons[4].setOnClickListener {
            scores.add("1")
            isChecked = true
            clearAllCheck()
            trueCheck(0)
            index = 0
            radioButtons[4].setBackgroundResource(R.drawable.shape_red)
        }


        radioButtons[5].setOnClickListener {
            scores.add("0")
            isChecked = true
            clearAllCheck()
            trueCheck(1)
            index = 1
            radioButtons[5].setBackgroundResource(R.drawable.shape_red)
        }

        radioButtons[6].setOnClickListener {
            scores.add("1")
            isChecked = true
            clearAllCheck()
            trueCheck(0)
            index = 0
            radioButtons[6].setBackgroundResource(R.drawable.shape_red)
        }


        radioButtons[7].setOnClickListener {
            scores.add("0")
            isChecked = true
            clearAllCheck()
            trueCheck(1)
            index = 1
            radioButtons[7].setBackgroundResource(R.drawable.shape_red)
        }

        radioButtons[8].setOnClickListener {
            scores.add("1")
            isChecked = true
            clearAllCheck()
            trueCheck(0)
            index = 0
            radioButtons[8].setBackgroundResource(R.drawable.shape_red)
        }


        radioButtons[9].setOnClickListener {
            scores.add("0")
            isChecked = true
            clearAllCheck()
            trueCheck(1)
            index = 1
            radioButtons[9].setBackgroundResource(R.drawable.shape_red)
        }

        radioButtons[10].setOnClickListener {
            scores.add("1")
            isChecked = true
            clearAllCheck()
            trueCheck(0)
            index = 0
            radioButtons[10].setBackgroundResource(R.drawable.shape_red)
        }


        radioButtons[11].setOnClickListener {
            scores.add("0")
            isChecked = true
            clearAllCheck()
            trueCheck(1)
            index = 1
            radioButtons[11].setBackgroundResource(R.drawable.shape_red)
        }

        radioButtons[12].setOnClickListener {
            scores.add("1")
            isChecked = true
            clearAllCheck()
            trueCheck(0)
            index = 0
            radioButtons[12].setBackgroundResource(R.drawable.shape_red)
        }


        radioButtons[13].setOnClickListener {
            scores.add("0")
            isChecked = true
            clearAllCheck()
            trueCheck(1)
            index = 1
            radioButtons[13].setBackgroundResource(R.drawable.shape_red)
        }

        radioButtons[14].setOnClickListener {
            scores.add("1")
            isChecked = true
            clearAllCheck()
            trueCheck(0)
            index = 0
            radioButtons[14].setBackgroundResource(R.drawable.shape_red)
        }


        radioButtons[15].setOnClickListener {
            scores.add("0")
            isChecked = true
            clearAllCheck()
            trueCheck(1)
            index = 1
            radioButtons[15].setBackgroundResource(R.drawable.shape_red)
        }

        radioButtons[16].setOnClickListener {
            scores.add("1")
            isChecked = true
            clearAllCheck()
            trueCheck(0)
            index = 0
            radioButtons[16].setBackgroundResource(R.drawable.shape_red)
        }


        radioButtons[17].setOnClickListener {
            scores.add("0")
            isChecked = true
            clearAllCheck()
            trueCheck(1)
            index = 1
            radioButtons[17].setBackgroundResource(R.drawable.shape_red)
        }

        radioButtons[18].setOnClickListener {
            scores.add("1")
            isChecked = true
            clearAllCheck()
            trueCheck(0)
            index = 0
            radioButtons[18].setBackgroundResource(R.drawable.shape_red)
        }


        radioButtons[19].setOnClickListener {
            scores.add("0")
            isChecked = true
            clearAllCheck()
            trueCheck(1)
            index = 1
            radioButtons[19].setBackgroundResource(R.drawable.shape_red)
        }

        radioButtons[20].setOnClickListener {
            scores.add("1")
            isChecked = true
            clearAllCheck()
            trueCheck(0)
            index = 0
            radioButtons[20].setBackgroundResource(R.drawable.shape_red)
        }


        radioButtons[21].setOnClickListener {
            scores.add("0")
            isChecked = true
            clearAllCheck()
            trueCheck(1)
            index = 1
            radioButtons[21].setBackgroundResource(R.drawable.shape_red)
        }

        radioButtons[22].setOnClickListener {
            scores.add("1")
            isChecked = true
            clearAllCheck()
            trueCheck(0)
            index = 0
            radioButtons[22].setBackgroundResource(R.drawable.shape_red)
        }


        radioButtons[23].setOnClickListener {
            scores.add("0")
            isChecked = true
            clearAllCheck()
            trueCheck(1)
            index = 1
            radioButtons[23].setBackgroundResource(R.drawable.shape_red)
        }

        radioButtons[24].setOnClickListener {
            scores.add("1")
            isChecked = true
            clearAllCheck()
            trueCheck(0)
            index = 0
            radioButtons[24].setBackgroundResource(R.drawable.shape_red)
        }


        radioButtons[25].setOnClickListener {
            scores.add("0")
            isChecked = true
            clearAllCheck()
            trueCheck(1)
            index = 1
            radioButtons[25].setBackgroundResource(R.drawable.shape_red)
        }

        radioButtons[26].setOnClickListener {
            scores.add("1")
            isChecked = true
            clearAllCheck()
            trueCheck(0)
            index = 0
            radioButtons[26].setBackgroundResource(R.drawable.shape_red)
        }


        radioButtons[27].setOnClickListener {
            scores.add("0")
            isChecked = true
            clearAllCheck()
            trueCheck(1)
            index = 1
            radioButtons[27].setBackgroundResource(R.drawable.shape_red)
        }






        binding.btnScore.setOnClickListener {

            if (!hasConnection()) {
                Alerter.create(requireActivity())
                    .setText("NO INTERNET")
                    .setBackgroundColorRes(R.color.purple_200)
                    .setDuration(5000)
                    .show()
            }

            viewModel.sendData(
                scores[0],
                binding.numbers.value.toString(),
                scores[1],
                scores[2],
                scores[3],
                scores[4],
                scores[5],
                scores[6],
                scores[7],
                scores[8],
                scores[9],
                scores[10],
                scores[11],
                scores[12],
                scores[13],
            )

            isChecked = false
        }


    }

    fun loadQuestion() {
        initData()
    }

    fun trueCheck(position: Int) {
        radioButtons!![position].isClickable = true
    }


    fun clearAllCheck() {

        radioButtons[0].setBackgroundResource(R.drawable.shape_default)
        radioButtons[1].setBackgroundResource(R.drawable.shape_default)
        radioButtons[2].setBackgroundResource(R.drawable.shape_default)
        radioButtons[3].setBackgroundResource(R.drawable.shape_default)
        radioButtons[4].setBackgroundResource(R.drawable.shape_default)
        radioButtons[5].setBackgroundResource(R.drawable.shape_default)
        radioButtons[6].setBackgroundResource(R.drawable.shape_default)
        radioButtons[7].setBackgroundResource(R.drawable.shape_default)
        radioButtons[8].setBackgroundResource(R.drawable.shape_default)
        radioButtons[9].setBackgroundResource(R.drawable.shape_default)
        radioButtons[10].setBackgroundResource(R.drawable.shape_default)
        radioButtons[11].setBackgroundResource(R.drawable.shape_default)
        radioButtons[12].setBackgroundResource(R.drawable.shape_default)
        radioButtons[13].setBackgroundResource(R.drawable.shape_default)
        radioButtons[14].setBackgroundResource(R.drawable.shape_default)
        radioButtons[15].setBackgroundResource(R.drawable.shape_default)
        radioButtons[16].setBackgroundResource(R.drawable.shape_default)
        radioButtons[17].setBackgroundResource(R.drawable.shape_default)
        radioButtons[18].setBackgroundResource(R.drawable.shape_default)
        radioButtons[19].setBackgroundResource(R.drawable.shape_default)
        radioButtons[20].setBackgroundResource(R.drawable.shape_default)
        radioButtons[21].setBackgroundResource(R.drawable.shape_default)
        radioButtons[22].setBackgroundResource(R.drawable.shape_default)
        radioButtons[23].setBackgroundResource(R.drawable.shape_default)
        radioButtons[24].setBackgroundResource(R.drawable.shape_default)
        radioButtons[25].setBackgroundResource(R.drawable.shape_default)
        radioButtons[26].setBackgroundResource(R.drawable.shape_default)
        radioButtons[27].setBackgroundResource(R.drawable.shape_default)

    }

}