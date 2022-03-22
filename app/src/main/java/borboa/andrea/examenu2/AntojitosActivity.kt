package borboa.andrea.examenu2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*

class AntojitosActivity : AppCompatActivity() {

    var antojitos = ArrayList<item>()
    var adapter: AdaptadorAntojitos? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_detalle)

        agregaAntojitos()

        var listview: ListView = findViewById(R.id.liview_platillos) as ListView
        var adaptador: AdaptadorAntojitos = AdaptadorAntojitos(this, antojitos)

        listview.adapter = adaptador

    }

    fun agregaAntojitos() {
        antojitos.add(item(R.drawable.quesadillas, "Quesadillas", 4.75))
        antojitos.add(item(R.drawable.antojitos, "Huaraches", 9.87))
        antojitos.add(item(R.drawable.antojitos, "Gringas", 6.47))
        antojitos.add(item(R.drawable.antojitos, "Sincronizadas", 6.98))
        antojitos.add(item(R.drawable.antojitos, "Sopes", 3.39))
        antojitos.add(item(R.drawable.antojitos, "Tostadas", 3.55))
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

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var antojitos = antojitos[position]
            var inflador = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflador.inflate(R.layout.item_platillos, null)

            var imagen = vista.findViewById(R.id.img_platillo) as ImageView
            var nombre = vista.findViewById(R.id.nombre_platillo) as TextView
            var precio = vista.findViewById(R.id.precio_platillo) as TextView

            imagen.setImageResource(antojitos.image_item)
            nombre.setText(antojitos.nombre_item)
            precio.setText("$${antojitos.precio_item}")

            imagen.setOnClickListener{
                val intent:Intent = Intent(contexto, detalle_platillos::class.java)
                intent.putExtra("nombre",antojitos.nombre_item)
                intent.putExtra("imagen",antojitos.image_item)
                intent.putExtra("precio",antojitos.precio_item)

                contexto!!.startActivity(intent)
            }
            return vista
        }
    }
}

