package borboa.andrea.examenu2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val boton_platillos: Button = findViewById(R.id.btn_platilos)
        val boton_drinks: Button = findViewById(R.id.btn_drinks)

        boton_platillos.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            startActivity(intent)
        }

        boton_drinks.setOnClickListener {
            var intent: Intent = Intent (this, DrinksActivity::class.java)
            startActivity(intent)
        }

    }
}