package pe.startapps.culqi_kotlin.domain

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pe.startapps.culqi_kotlin.domain.model.CulqiCard
import pe.startapps.culqi_kotlin.domain.model.CulqiToken
import pe.startapps.culqi_kotlin.utils.enqueue
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import com.google.gson.Gson
import pe.startapps.culqi_kotlin.domain.model.CulqiError


/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class TokenBuilder(val apiKey: String) {

    val service: TokenBuilder.ApiService

    init {

        val builder = OkHttpClient.Builder()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(interceptor)

        builder.addNetworkInterceptor { chain ->
            chain.proceed(chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $apiKey")
                    .build())
        }

        val retrofit = Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build()

        service = retrofit.create(TokenBuilder.ApiService::class.java)
    }

    fun createToken(card: CulqiCard, success: (token: CulqiToken) -> Unit, failure: (error: CulqiError) -> Unit) {
        service.createToken(card).enqueue({
            try {
                if (it.isSuccessful) {
                    success(it.body())
                } else {
                    failure(Gson().fromJson(it.errorBody().string(), CulqiError::class.java))
                }
            } catch (e: Exception) {
                failure(CulqiError("error", e.message ?: "Unknown Error"))
            }
        }, { failure(CulqiError("error", it.message ?: "Unknown Error")) })
    }

    interface ApiService {

        @POST("tokens")
        fun createToken(@Body user: CulqiCard): Call<CulqiToken>

    }

}