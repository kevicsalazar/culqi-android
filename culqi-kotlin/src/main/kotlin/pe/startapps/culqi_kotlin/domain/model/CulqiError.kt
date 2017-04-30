package pe.startapps.culqi_kotlin.domain.model

import com.google.gson.annotations.SerializedName

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
data class CulqiError(
        @SerializedName("type") val type: String,
        @SerializedName("merchant_message") val merchantMessage: String
)