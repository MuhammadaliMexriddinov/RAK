package uz.alpha.icmedaisaratonai.app

import android.app.Application
import android.content.Context

class App : Application() {

    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
//        AppDatabase.init(this)
        context = this
    }

}