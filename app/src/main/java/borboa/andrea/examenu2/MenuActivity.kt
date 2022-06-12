package borboa.andrea.examenu2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import com.nex3z.notificationbadge.NotificationBadge

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        var lista = intent.getSerializableExtra("listaCarrito") as ArrayList<item>
        var list = ArrayList<item>()
        list.addAll(lista)


        var btn_atras: ImageButton = findViewById(R.id.btn_menu) as ImageButton
        btn_atras.setOnClickListener{
            var intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        var btn_carrito: ImageButton = findViewById(R.id.carrito) as ImageButton
        btn_carrito.setOnClickListener {
            var intent: Intent = Intent(this, CarritoActivity::class.java)
            intent.putExtra("listaCarrito",lista)
            startActivity(intent)
        }

        var btnTacos: ImageView = findViewById(R.id.btn_tacos) as ImageView

        btnTacos.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","tacos")
            intent.putExtra("listaCarrito",lista)
            startActivity(intent)
        }

        var btnAntojitos: ImageView = findViewById(R.id.btn_antojitos) as ImageView

        btnAntojitos.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","antojitos")
            intent.putExtra("listaCarrito",lista)
            startActivity(intent)
        }

        var btnEspecialidades: ImageView = findViewById(R.id.btn_especialidades) as ImageView

        btnEspecialidades.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","especialidades")
            intent.putExtra("listaCarrito",lista)
            startActivity(intent)
        }

        var btnCaldos: ImageView = findViewById(R.id.btn_caldos) as ImageView

        btnCaldos.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","caldos")
            intent.putExtra("listaCarrito",lista)
            startActivity(intent)
        }

        var btnCombinatios: ImageView = findViewById(R.id.btn_combinations) as ImageView

        btnCombinatios.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","combinations")
            intent.putExtra("listaCarrito",lista)
            startActivity(intent)
        }

        var btnTortas: ImageView = findViewById(R.id.btn_tortas) as ImageView

        btnTortas.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","tortas")
            intent.putExtra("listaCarrito",lista)
            startActivity(intent)
        }

        var btnSopas: ImageView = findViewById(R.id.btn_sopas) as ImageView

        btnSopas.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","sopas")
            intent.putExtra("listaCarrito",lista)
            startActivity(intent)
        }

        var btnSideOrders: ImageView = findViewById(R.id.btn_sideorders) as ImageView

        btnSideOrders.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","sideorders")
            intent.putExtra("listaCarrito",lista)
            startActivity(intent)
        }

        var btnDrinks: ImageView = findViewById(R.id.btn_drinks) as ImageView

        btnDrinks.setOnClickListener{
            var intent: Intent = Intent(this, PlatillosActivity::class.java)
            intent.putExtra("menuType","drinks")
            intent.putExtra("listaCarrito",lista)
            startActivity(intent)
        }



    }
}