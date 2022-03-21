package borboa.andrea.examenu2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class AntojitosActivity : AppCompatActivity() {

    var antojitos = ArrayList<item>()
    var adapter: AdaptadorAntojitos? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        agregaAntojitos()

        var listview: ListView = findViewById(R.id.liview_platillos) as ListView
        var adaptador: AdaptadorAntojitos = AdaptadorAntojitos(this, antojitos)
        listview.adapter = adaptador

    }

    fun agregaAntojitos() {
        antojitos.add(item(R.drawable.imgtacos, "Quesadillas", 4.75))
        antojitos.add(item(R.drawable.imgtacos, "Huaraches", 9.87))
        antojitos.add(item(R.drawable.imgtacos, "Gringas", 6.47))
        antojitos.add(item(R.drawable.imgtacos, "Sincronizadas", 6.98))
        antojitos.add(item(R.drawable.imgtacos, "Sopes", 3.39))
        antojitos.add(item(R.drawable.imgtacos, "Tostadas", 3.55))
    }

    class AdaptadorAntojitos : BaseAdapter {
        var antojitos = ArrayList<item>()
        var contexto: Context? = null

        constructor(contexto: Context, tacos: ArrayList<item>) {
            this.antojitos = tacos
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return antojitos.size
        }

        override fun getItem(p0: Int): Any {
            return antojitos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var antojitos = antojitos[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.item_platillos, null)

            var imagen = vista.findViewById(R.id.img_platillo) as ImageView
            var nombre = vista.findViewById(R.id.nombre_platillo) as TextView
            var precio = vista.findViewById(R.id.precio_platillo) as TextView

            imagen.setImageResource(antojitos.image_item)
            nombre.setText(antojitos.nombre_item)
            precio.setText("$${antojitos.precio_item}")

            imagen.setOnClickListener{
                var intent = Intent(contexto, detalle_platillos::class.java)
                intent.putExtra("image_item",antojitos.image_item)
                intent.putExtra("nombre_item",antojitos.nombre_item)
                intent.putExtra("precio_item",antojitos.precio_item)
                contexto!!.startActivity(intent)
            }
            return vista
        }
    }
}
