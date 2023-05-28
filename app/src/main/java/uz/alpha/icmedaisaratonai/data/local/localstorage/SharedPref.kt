package uz.alpha.icmedaisaratonai.data.local.localstorage

import android.content.Context
import android.content.SharedPreferences
import uz.alpha.icmedaisaratonai.app.App


/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */
class SharedPref private constructor() {

    private val preferences: SharedPreferences =
        App.context!!.getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE)


    companion object {
        private lateinit var myPref: SharedPref

        fun getInstance(): SharedPref {
            if (!this::myPref.isInitialized) {
                myPref = SharedPref()
            }
            return myPref
        }
    }

    fun setStarts(s: Boolean) {
        preferences.edit().putBoolean("SET", s).apply()
    }

    fun getStart() = preferences.getBoolean("SET", false)

    var language: String?
        get() = preferences.getString("language", "eng")
        set(language) {
            preferences.edit().putString("language", language).apply()
        }

}