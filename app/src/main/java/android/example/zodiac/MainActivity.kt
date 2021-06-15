package android.example.zodiac

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var myCalendar: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val p = intent.extras
        val name = p!!.getString("name")
        userName.setText(name)

        val imgURL=p!!.getString("imgURL")
        Glide.with(this).load(imgURL).circleCrop().into(userImage)

        myCalendar= Calendar.getInstance()
        cal_img.setOnClickListener {
            var date= DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                myCalendar.set(Calendar.YEAR , year)
                myCalendar.set(Calendar.MONTH , month)
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateDate();
            }
            DatePickerDialog(this, date ,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(
                Calendar.DAY_OF_MONTH)).show()
        }

        submit.setOnClickListener {
            val input = chosenDate.text.toString().trim()
            if(input.isNotEmpty()) {
                val intent = Intent(this, DisplayActivity::class.java)
                intent.putExtra("date",input)
                startActivity(intent)

                val deli="/"
                val list = input.split(deli)
                val date=list[0]
                val month=list[1]

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_items,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id==R.id.menu_action_filter){
            Firebase.auth.signOut()
            intent=Intent(this,SignInActivity::class.java)
            startActivity(intent)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun updateDate(){
        var myFormat="MM/dd/yy, EEE"
        var sdf= SimpleDateFormat(myFormat, Locale.US)
        chosenDate.setText(sdf.format(myCalendar.getTime()))
    }
}
