package com.kevicsalazar.culqi.domain

import android.content.Intent
import com.google.gson.Gson
import com.kevicsalazar.culqi.domain.model.CulqiError
import com.kevicsalazar.culqi.domain.model.CulqiToken

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
object CulqiParser {

    fun parse(data: Intent, success: (token: CulqiToken) -> Unit, failure: (error: CulqiError) -> Unit) {
        if (data.getBooleanExtra("successful", false)) {
            success(Gson().fromJson(data.getStringExtra("token"), CulqiToken::class.java))
        } else {
            failure(Gson().fromJson(data.getStringExtra("error"), CulqiError::class.java))
        }
    }

}