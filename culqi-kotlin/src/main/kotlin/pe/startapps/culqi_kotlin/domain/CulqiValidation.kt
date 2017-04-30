package pe.startapps.culqi_kotlin.domain

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
object CulqiValidation {

    fun luhn(number: String): Boolean {
        var s1 = 0
        var s2 = 0
        val reverse = StringBuffer(number).reverse().toString()
        for (i in 0..reverse.length - 1) {
            val digit = Character.digit(reverse[i], 10)
            if (i % 2 == 0) {                       //this is for odd digits, they are 1-indexed in the algorithm
                s1 += digit
            } else {                                //add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
                s2 += 2 * digit
                if (digit >= 5) {
                    s2 -= 9
                }
            }
        }
        return (s1 + s2) % 10 == 0
    }

    fun bin(bin: String, kind_card: android.widget.ImageView): Int {

        if (bin.isNotEmpty()) {
            if (Integer.valueOf("" + bin[0]) == 3) {
                kind_card.setImageResource(pe.startapps.culqi_kotlin.R.drawable.amex)
                return 4
            } else if (Integer.valueOf("" + bin[0]) == 4) {
                kind_card.setImageResource(pe.startapps.culqi_kotlin.R.drawable.visa)
                return 3
            } else if (Integer.valueOf("" + bin[0]) == 5) {
                kind_card.setImageResource(pe.startapps.culqi_kotlin.R.drawable.mc)
                return 3
            } else {
            }
        } else {
            kind_card.setImageDrawable(null)
        }

        if (bin.length > 1) {
            if (Integer.valueOf(bin.substring(0, 2)) == 36) {
                kind_card.setImageResource(pe.startapps.culqi_kotlin.R.drawable.diners)
                return 3
            } else if (Integer.valueOf(bin.substring(0, 2)) == 38) {
                kind_card.setImageResource(pe.startapps.culqi_kotlin.R.drawable.diners)
                return 3
            } else if (Integer.valueOf(bin.substring(0, 2)) == 37) {
                kind_card.setImageResource(pe.startapps.culqi_kotlin.R.drawable.amex)
                return 3
            } else {
            }
        }

        if (bin.length > 2) {
            if (Integer.valueOf(bin.substring(0, 3)) == 300) {
                kind_card.setImageResource(pe.startapps.culqi_kotlin.R.drawable.diners)
                return 3
            } else if (Integer.valueOf(bin.substring(0, 3)) == 305) {
                kind_card.setImageResource(pe.startapps.culqi_kotlin.R.drawable.diners)
                return 3
            } else {
            }
        }
        return 0
    }

    fun expirationDate(expirationDate: String): Boolean {
        with(expirationDate) {
            try {
                val calendar = java.util.Calendar.getInstance()
                if (length == 2 && toInt() > calendar.get(java.util.Calendar.MONTH) && toInt() <= 12) {
                    return true
                }
                if (length == 5 && ("20${substring(3, 5)}").toInt() >= calendar.get(java.util.Calendar.YEAR)
                        && substring(0, 2).toInt() > calendar.get(java.util.Calendar.MONTH) && substring(0, 2).toInt() <= 12) {
                    return true
                }
                return false
            } catch (e: Exception) {
                return false
            }
        }
    }

    fun emailAddress(email: String): Boolean {
        val ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"
        val p = java.util.regex.Pattern.compile(ePattern)
        val m = p.matcher(email)
        return m.matches()
    }

}