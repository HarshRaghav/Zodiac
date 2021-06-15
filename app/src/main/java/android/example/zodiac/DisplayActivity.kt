package android.example.zodiac

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_display.*
import kotlinx.android.synthetic.main.activity_main.*

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val p = intent.extras
        val input = p!!.getString("date")
        val deli="/"
        val list = input?.split(deli)
        val date= list?.get(0)?.toInt()
        val month= list?.get(1)?.toInt()

        if (date != null) {
            if (month == 1) {
                if (date < 20) {
                    displaying.setImageResource(R.drawable.capricorn)
                } else {
                    displaying.setImageResource(R.drawable.aquarius)
                }
            } else if (month == 2) {
                if (date < 19) {
                    displaying.setImageResource(R.drawable.aquarius)
                } else {
                    displaying.setImageResource(R.drawable.pisces)
                }
            } else if (month == 3) {
                if (date < 21) {
                    displaying.setImageResource(R.drawable.pisces)
                } else {
                    displaying.setImageResource(R.drawable.aries)
                }
            } else if (month == 4) {
                if (date != null) {
                    if (date < 20) {
                        displaying.setImageResource(R.drawable.aries)
                    } else {
                        displaying.setImageResource(R.drawable.taurus)
                    }
                }
            } else if (month == 5) {
                if (date < 21) {
                    displaying.setImageResource(R.drawable.taurus)
                } else {
                    displaying.setImageResource(R.drawable.gemini)
                }
            } else if (month == 6) {
                if (date < 21) {
                    displaying.setImageResource(R.drawable.gemini)
                } else {
                    displaying.setImageResource(R.drawable.cancer)
                }
            } else if (month == 7) {
                if (date < 23) {
                    displaying.setImageResource(R.drawable.cancer)
                } else {
                    displaying.setImageResource(R.drawable.leo)
                }
            } else if (month == 8) {
                if (date < 23) {
                    displaying.setImageResource(R.drawable.leo)
                } else {
                    displaying.setImageResource(R.drawable.virgo)
                }
            } else if (month == 9) {
                if (date < 23) {
                    displaying.setImageResource(R.drawable.virgo)
                } else {
                    displaying.setImageResource(R.drawable.libra)
                }
            } else if (month == 10) {
                if (date < 23) {
                    displaying.setImageResource(R.drawable.libra)
                } else {
                    displaying.setImageResource(R.drawable.scorpio)
                }
            } else if (month == 11) {
                if (date < 22) {
                    displaying.setImageResource(R.drawable.scorpio)
                } else {
                    displaying.setImageResource(R.drawable.saggittarius)
                }
            } else {
                if (date < 22) {
                    displaying.setImageResource(R.drawable.saggittarius)
                } else {
                    displaying.setImageResource(R.drawable.capricorn)
                }
            }
        }
    }
}