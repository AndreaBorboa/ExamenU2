package borboa.andrea.examenu2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnTacos: ImageView = findViewById(R.id.btn_tacos) as ImageView

        btnTacos.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","tacos")
            startActivity(intent)
        }

        var btnAntojitos: ImageView = findViewById(R.id.btn_antojitos) as ImageView

        btnAntojitos.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","antojitos")
            startActivity(intent)
        }

        var btnEspecialidades: ImageView = findViewById(R.id.btn_especialidades) as ImageView

        btnEspecialidades.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","especialidades")
            startActivity(intent)
        }

        var btnCaldos: ImageView = findViewById(R.id.btn_caldos) as ImageView

        btnCaldos.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","caldos")
            startActivity(intent)
        }

        var btnCombinatios: ImageView = findViewById(R.id.btn_combinations) as ImageView

        btnCombinatios.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","combinations")
            startActivity(intent)
        }

        var btnTortas: ImageView = findViewById(R.id.btn_tortas) as ImageView

        btnTortas.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","tortas")
            startActivity(intent)
        }

        var btnSopas: ImageView = findViewById(R.id.btn_sopas) as ImageView

        btnSopas.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","sopas")
            startActivity(intent)
        }

        var btnSideOrders: ImageView = findViewById(R.id.btn_sideorders) as ImageView

        btnSideOrders.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","sideorders")
            startActivity(intent)
        }

        var btnDrinks: ImageView = findViewById(R.id.btn_drinks) as ImageView

        btnDrinks.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","drinks")
            startActivity(intent)
        }



    }
}