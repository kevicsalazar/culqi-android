package pe.startapps.culqi_kotlin.domain

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
object CulqiConfig {

    internal val BASE_URL: String = "https://api.culqi.com/v2/"
    internal var API_KEY: String = "UNDEFINED"

    fun init(apiKey: String) {
        API_KEY = apiKey
    }

}