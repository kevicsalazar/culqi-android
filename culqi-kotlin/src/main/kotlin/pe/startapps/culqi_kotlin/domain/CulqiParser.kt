package pe.startapps.culqi_kotlin.domain

import android.content.Intent
import com.google.gson.Gson
import pe.startapps.culqi_kotlin.domain.model.CulqiError
import pe.startapps.culqi_kotlin.domain.model.CulqiToken

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
object CulqiParser {

    fun parse(data: Intent): Pair<Boolean, Any> {
        if (data.getBooleanExtra("successful", false)) {
            return Pair(true, Gson().fromJson(data.getStringExtra("token"), CulqiToken::class.java))
        } else {
            return Pair(false, Gson().fromJson(data.getStringExtra("error"), CulqiError::class.java))
        }
    }

}