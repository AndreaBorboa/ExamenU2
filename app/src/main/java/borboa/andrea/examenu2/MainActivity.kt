package borboa.andrea.examenu2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val boton_menu: Button = findViewById(R.id.btn_menu)

        boton_menu.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            startActivity(intent)
        }

    }
}