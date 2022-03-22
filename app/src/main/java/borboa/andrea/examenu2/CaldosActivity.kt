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

class CaldosActivity : AppCompatActivity() {

    var caldos = ArrayList<item>()
    var adapter: AdaptadorCaldos? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        agregaCaldos()

        var listview: ListView = findViewById(R.id.liview_platillos) as ListView
        var adaptador: AdaptadorCaldos = AdaptadorCaldos(this, caldos)
        listview.adapter = adaptador

    }

    fun agregaCaldos() {
        caldos.add(item(R.drawable.caldomarisco, "Langer", 10.99))
        caldos.add(item(R.drawable.caldocamaron, "Camaron", 11.99))
    }

    class AdaptadorCaldos : BaseAdapter {
        var caldos = ArrayList<item>()
        var contexto: Context? = null

        constructor(contexto: Context, caldos: ArrayList<item>) {
            this.caldos = caldos
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return caldos.size
        }

        override fun getItem(p0: Int): Any {
            return caldos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var caldos = caldos[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.item_platillos, null)

            var imagen = vista.findViewById(R.id.img_platillo) as ImageView
            var nombre = vista.findViewById(R.id.nombre_platillo) as TextView
            var precio = vista.findViewById(R.id.precio_platillo) as TextView

            imagen.setImageResource(caldos.image_item)
            nombre.setText(caldos.nombre_item)
            precio.setText("$${caldos.precio_item}")


            return vista
        }
    }
}