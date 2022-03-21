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

class SideOrdersActivity : AppCompatActivity() {

    var sideorders = ArrayList<item>()
    var adapter: AdaptadorSideOrders? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        agregaSideOrders()

        var listview: ListView = findViewById(R.id.liview_platillos) as ListView
        var adaptador: AdaptadorSideOrders = AdaptadorSideOrders(this, sideorders)
        listview.adapter = adaptador

    }

    fun agregaSideOrders() {
        sideorders.add(item(R.drawable.imgtacos, "Side Of Guacamole", 3.75))
        sideorders.add(item(R.drawable.imgtacos, "Side Of Rice", 1.99))
        sideorders.add(item(R.drawable.imgtacos, "Side Of Beans", 1.99))
        sideorders.add(item(R.drawable.imgtacos, "Chips and Salsa", 2.25))
        sideorders.add(item(R.drawable.imgtacos, "Flour Tacos", 2.99))
    }

    class AdaptadorSideOrders : BaseAdapter {
        var sideorders = ArrayList<item>()
        var contexto: Context? = null

        constructor(contexto: Context, sideorders: ArrayList<item>) {
            this.sideorders = sideorders
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return sideorders.size
        }

        override fun getItem(p0: Int): Any {
            return sideorders[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var sideorders = sideorders[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.item_platillos, null)

            var imagen = vista.findViewById(R.id.img_platillo) as ImageView
            var nombre = vista.findViewById(R.id.nombre_platillo) as TextView
            var precio = vista.findViewById(R.id.precio_platillo) as TextView

            imagen.setImageResource(sideorders.image_item)
            nombre.setText(sideorders.nombre_item)
            precio.setText("$${sideorders.precio_item}")


            return vista
        }
    }
}