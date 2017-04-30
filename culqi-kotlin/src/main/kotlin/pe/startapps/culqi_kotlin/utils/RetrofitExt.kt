package pe.startapps.culqi_kotlin.utils


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
fun <T> Call<T>.enqueue(success: (response: Response<T>) -> Unit, failure: (t: Throwable) -> Unit) {
    enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>?, response: Response<T>) {
            success(response)
        }
        override fun onFailure(call: Call<T>?, t: Throwable) {
            failure(t)
        }
    })
}