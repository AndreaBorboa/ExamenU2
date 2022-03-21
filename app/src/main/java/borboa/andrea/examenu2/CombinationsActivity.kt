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

class CombinationsActivity : AppCompatActivity() {

    var combinations = ArrayList<item>()
    var adapter: AdaptadorCombinations? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        agregaCombinations()

        var listview: ListView = findViewById(R.id.liview_platillos) as ListView
        var adaptador: AdaptadorCombinations = AdaptadorCombinations(this, combinations)
        listview.adapter = adaptador

    }

    fun agregaCombinations() {
        combinations.add(item(R.drawable.imgtacos, "Tradicional Taco Combo", 6.99))
        combinations.add(item(R.drawable.imgtacos, "Mexican Burritos", 10.99))
        combinations.add(item(R.drawable.imgtacos, "Los Portales Burrito", 11.79))
        combinations.add(item(R.drawable.imgtacos, "Cinco", 7.67))
        combinations.add(item(R.drawable.imgtacos, "Dos Amigos", 8.25))
        combinations.add(item(R.drawable.imgtacos, "Burrito Pepe", 6.89))
    }

    class AdaptadorCombinations : BaseAdapter {
        var combinations = ArrayList<item>()
        var contexto: Context? = null

        constructor(contexto: Context, combinations: ArrayList<item>) {
            this.combinations = combinations
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return combinations.size
        }

        override fun getItem(p0: Int): Any {
            return combinations[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var combinations = combinations[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.item_platillos, null)

            var imagen = vista.findViewById(R.id.img_platillo) as ImageView
            var nombre = vista.findViewById(R.id.nombre_platillo) as TextView
            var precio = vista.findViewById(R.id.precio_platillo) as TextView

            imagen.setImageResource(combinations.image_item)
            nombre.setText(combinations.nombre_item)
            precio.setText("$${combinations.precio_item}")


            return vista
        }
    }
}