package borboa.andrea.examenu2


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class SopasActivity : AppCompatActivity() {

    var sopas = ArrayList<item>()
    var adapter: AdaptadorSopas? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        agregaSopas()

        var listview: ListView = findViewById(R.id.liview_platillos) as ListView
        var adaptador: AdaptadorSopas = AdaptadorSopas(this, sopas)
        listview.adapter = adaptador

    }

    fun agregaSopas() {
        sopas.add(item(R.drawable.imgtacos, "Pozole", 5.99))
        sopas.add(item(R.drawable.imgtacos, "Menudo", 5.99))
        sopas.add(item(R.drawable.imgtacos, "Caldo de Res", 5.99))
        sopas.add(item(R.drawable.imgtacos, "Caldo de Camaron", 10.69))
        sopas.add(item(R.drawable.imgtacos, "Sopa de Mariscos", 15.75))
        sopas.add(item(R.drawable.imgtacos, "Coctel de Camaron", 13.50))
    }

    class AdaptadorSopas : BaseAdapter {
        var sopas = ArrayList<item>()
        var contexto: Context? = null

        constructor(contexto: Context, sopas: ArrayList<item>) {
            this.sopas = sopas
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return sopas.size
        }

        override fun getItem(p0: Int): Any {
            return sopas[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var sopas = sopas[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.item_platillos, null)

            var imagen = vista.findViewById(R.id.img_platillo) as ImageView
            var nombre = vista.findViewById(R.id.nombre_platillo) as TextView
            var precio = vista.findViewById(R.id.precio_platillo) as TextView

            imagen.setImageResource(sopas.image_item)
            nombre.setText(sopas.nombre_item)
            precio.setText("$${sopas.precio_item}")


            return vista
        }
    }
}