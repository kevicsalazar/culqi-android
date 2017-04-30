package pe.startapps.culqi_kotlin.domain.model

import com.google.gson.annotations.SerializedName

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
data class CulqiCard(
        @SerializedName("card_number") val cardNumber: String,
        @SerializedName("cvv") val cvv: String,
        @SerializedName("expiration_month") val expirationMonth: Int,
        @SerializedName("expiration_year") val expirationYear: Int,
        @SerializedName("email") val email: String
)