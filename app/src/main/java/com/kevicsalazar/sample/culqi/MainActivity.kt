package com.kevicsalazar.sample.culqi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.kevicsalazar.culqi.domain.CulqiConfig
import com.kevicsalazar.culqi.domain.CulqiParser
import com.kevicsalazar.culqi.presentation.CheckoutActivity
import com.kevicsalazar.sample.culqi.utils.alert
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        CulqiConfig.init(BuildConfig.CULQI_API_KEY)

        btnCheckout.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("title", "Culqi Checkout")
            intent.putExtra("currency", "PEN")
            intent.putExtra("amount", "430.00")
            startActivityForResult(intent, 1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            CulqiParser.parse(data, { (id) ->
                Log.e("Token", id)
            }, { (message) ->
                alert("Error", message).show()
            })
        }
    }

}
