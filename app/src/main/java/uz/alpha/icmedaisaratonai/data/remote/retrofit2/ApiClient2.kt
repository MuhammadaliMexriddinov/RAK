package uz.alpha.icmedaisaratonai.data.remote.retrofit2

import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.alpha.icmedaisaratonai.app.App

object ApiClient2 {


    private val myClient = OkHttpClient.Builder()
        .addInterceptor(ChuckInterceptor(App.context))
        .build()


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.100.12:6788/")
            //http://195.158.16.43:6788
        .client(myClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getMedApi(): MedService = retrofit.create(MedService::class.java)

}

