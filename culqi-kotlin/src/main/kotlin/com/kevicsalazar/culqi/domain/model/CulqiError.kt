package com.kevicsalazar.culqi.domain.model

import com.google.gson.annotations.SerializedName

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
data class CulqiError(
        @SerializedName("type") val type: String,
        @SerializedName("merchant_message") val message: String
)