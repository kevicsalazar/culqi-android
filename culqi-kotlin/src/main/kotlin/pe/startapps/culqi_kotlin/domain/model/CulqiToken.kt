package pe.startapps.culqi_kotlin.domain.model

import com.google.gson.annotations.SerializedName

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
data class CulqiToken(
        @SerializedName("id") val id: String,
        @SerializedName("card_number") val cardNumber: String
)