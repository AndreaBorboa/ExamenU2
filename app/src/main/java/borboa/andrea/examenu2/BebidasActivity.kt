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

class BebidasActivity : AppCompatActivity() {

    var bebidas = ArrayList<item>()
    var adapter: AdaptadorBebidas? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        agregaBebidas()

        var listview: ListView = findViewById(R.id.liview_platillos) as ListView
        var adaptador: AdaptadorBebidas = AdaptadorBebidas(this, bebidas)
        listview.adapter = adaptador

    }

    fun agregaBebidas() {
        bebidas.add(item(R.drawable.sodas, "Sodas", 2.75))
        bebidas.add(item(R.drawable.jarrito, "Jarritos", 2.35))
        bebidas.add(item(R.drawable.aguafresca, "Aguas Frescas", 2.75))
        bebidas.add(item(R.drawable.domesticbeer, "Domestic Beer", 3.55))
        bebidas.add(item(R.drawable.mexicanbeer, "Mexican Beer", 3.99))
        bebidas.add(item(R.drawable.michelada, "Micheladas", 6.75))
        bebidas.add(item(R.drawable.cahuamamichelada, "Caguama", 7.99))
        bebidas.add(item(R.drawable.cahuamamichelada, "Caguama Michelada", 10.99))
        bebidas.add(item(R.drawable.cubetazos, "Cubetazos", 19.99))
        bebidas.add(item(R.drawable.cubetazos, "Lata Beer", 2.99))
        bebidas.add(item(R.drawable.cubetazos, "Charolazo", 15.75))
        bebidas.add(item(R.drawable.cubetazos, "Charolazo con camarones", 21.99))
        bebidas.add(item(R.drawable.cubetazos, "La mamalona", 12.99))
        bebidas.add(item(R.drawable.cubetazos, "La mamalona con camarones", 14.99))
        bebidas.add(item(R.drawable.cubetazos, "Cubetazo (6 cervezas)", 21.99))
    }

    class AdaptadorBebidas : BaseAdapter {
        var bebidas = ArrayList<item>()
        var contexto: Context? = null

        constructor(contexto: Context, bebidas: ArrayList<item>) {
            this.bebidas = bebidas
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return bebidas.size
        }

        override fun getItem(p0: Int): Any {
            return bebidas[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var bebidas = bebidas[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.item_platillos, null)

            var imagen = vista.findViewById(R.id.img_platillo) as ImageView
            var nombre = vista.findViewById(R.id.nombre_platillo) as TextView
            var precio = vista.findViewById(R.id.precio_platillo) as TextView

            imagen.setImageResource(bebidas.image_item)
            nombre.setText(bebidas.nombre_item)
            precio.setText("$${bebidas.precio_item}")


            return vista
        }
    }
}
