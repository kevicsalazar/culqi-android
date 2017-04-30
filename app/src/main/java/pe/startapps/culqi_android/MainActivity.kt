package pe.startapps.culqi_android

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import pe.startapps.culqi_kotlin.domain.model.CulqiError
import pe.startapps.culqi_kotlin.domain.model.CulqiToken
import pe.startapps.culqi_kotlin.presentation.CheckoutActivity
import pe.startapps.culqi_kotlin.domain.CulqiParser

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCheckout.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("apiKey", BuildConfig.CULQI_API_KEY)
            intent.putExtra("amount", "S/. 175.00")
            startActivityForResult(intent, 1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            with(CulqiParser.parse(data)) {
                if (first) {
                    val token = second as CulqiToken
                } else {
                    val error = second as CulqiError
                    Log.e("Error", error.merchantMessage)
                }
            }
        }
    }

}
