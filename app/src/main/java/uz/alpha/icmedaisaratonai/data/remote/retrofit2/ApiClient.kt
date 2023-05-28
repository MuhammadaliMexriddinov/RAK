package uz.alpha.icmedaisaratonai.data.remote.retrofit2

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private val myClient = OkHttpClient.Builder()
       // .addInterceptor(ChuckInterceptor(App.context))
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()


    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://195.158.16.43:6788/")
        .client(myClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getMedApi(): MedService = retrofit.create(MedService::class.java)
}