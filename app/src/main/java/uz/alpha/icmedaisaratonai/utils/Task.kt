package uz.alpha.icmedaisaratonai.utils

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import uz.alpha.icmedaisaratonai.R

class Task : Fragment(R.layout.screen_home) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val a: Int = 1
        val b: Int = 2
        val c: Int = 3

        //2ab-2bc
        Log.d("TTT", "onViewCreated:  ${2 * a * b - 2 * b * c}")

        //Natija: -8


    }


}
