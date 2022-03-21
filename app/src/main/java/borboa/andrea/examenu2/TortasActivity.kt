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

class TortasActivity : AppCompatActivity() {

    var tortas = ArrayList<item>()
    var adapter: AdaptadorTortas? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        agregaTortas()

        var listview: ListView = findViewById(R.id.liview_platillos) as ListView
        var adaptador: AdaptadorTortas = AdaptadorTortas(this, tortas)
        listview.adapter = adaptador

    }

    fun agregaTortas() {
        tortas.add(item(R.drawable.imgtacos, "Torta Regular", 10.95))
        tortas.add(item(R.drawable.imgtacos, "Torta Milanesa de Res o Pollo", 11.99))
        tortas.add(item(R.drawable.imgtacos, "Torta Cubana", 12.35))
        tortas.add(item(R.drawable.imgtacos, "Torta Mixta", 11.99))
        tortas.add(item(R.drawable.imgtacos, "Small Mexican Torta", 6.89))
    }

    class AdaptadorTortas : BaseAdapter {
        var tortas = ArrayList<item>()
        var contexto: Context? = null

        constructor(contexto: Context, tortas: ArrayList<item>) {
            this.tortas = tortas
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return tortas.size
        }

        override fun getItem(p0: Int): Any {
            return tortas[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var tortas = tortas[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.item_platillos, null)

            var imagen = vista.findViewById(R.id.img_platillo) as ImageView
            var nombre = vista.findViewById(R.id.nombre_platillo) as TextView
            var precio = vista.findViewById(R.id.precio_platillo) as TextView

            imagen.setImageResource(tortas.image_item)
            nombre.setText(tortas.nombre_item)
            precio.setText("$${tortas.precio_item}")


            return vista
        }
    }
}
