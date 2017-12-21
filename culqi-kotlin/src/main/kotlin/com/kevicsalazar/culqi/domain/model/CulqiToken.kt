package com.kevicsalazar.culqi.domain.model

import com.google.gson.annotations.SerializedName

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
data class CulqiToken(
        @SerializedName("id") val id: String,
        @SerializedName("card_number") val cardNumber: String
)