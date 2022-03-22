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

class TacosActivity : AppCompatActivity() {

    var tacos = ArrayList<item>()
    var adapter: AdaptadorTacos? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        agregaTacos()

        var listview: ListView = findViewById(R.id.liview_platillos) as ListView
        var adaptador: AdaptadorTacos= AdaptadorTacos(this, tacos)
        listview.adapter = adaptador

    }

    fun agregaTacos(){
        tacos.add(item(R.drawable.tacos,"Asada/Beef Steak",2.35))
        tacos.add(item(R.drawable.tacos,"Pollo/Chicken",2.35))
        tacos.add(item(R.drawable.tacos,"Carnitas/Pulled Pork",2.35))
        tacos.add(item(R.drawable.tacos,"Chorizo/Mexican Sausage",2.35))
        tacos.add(item(R.drawable.tacos,"Suadero/Shredded Beef",2.35))
        tacos.add(item(R.drawable.tacos,"Biche/Pork Stomach",2.35))
        tacos.add(item(R.drawable.tacos,"Al pastor/Marinated Pork",2.35))
        tacos.add(item(R.drawable.tacos,"Cachete/Beef Cheek",2.35))
        tacos.add(item(R.drawable.tacos,"Barbacoa/BBQ",2.35))
        tacos.add(item(R.drawable.tacos,"Tripa/Beef Intestine",2.35))
        tacos.add(item(R.drawable.tacos,"Chicharron/Pork Rinds",2.35))
        tacos.add(item(R.drawable.tacos,"Cueritos/Pork Skin",2.35))
        tacos.add(item(R.drawable.tacos,"Lengua",3.99))
        tacos.add(item(R.drawable.tacos,"Taco de Pescado",2.35))

    }

    class AdaptadorTacos : BaseAdapter {
        var tacos = ArrayList<item>()
        var contexto: Context? = null

        constructor(contexto: Context, tacos: ArrayList<item>) {
            this.tacos= tacos
            this.contexto= contexto
        }

        override fun getCount(): Int {
            return tacos.size
        }

        override fun getItem(p0: Int): Any {
            return tacos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var taco = tacos[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.item_platillos,null)

            var imagen = vista.findViewById(R.id.img_platillo) as ImageView
            var nombre = vista.findViewById(R.id.nombre_platillo) as TextView
            var precio = vista.findViewById(R.id.precio_platillo) as TextView

            imagen.setImageResource(taco.image_item)
            nombre.setText(taco.nombre_item)
            precio.setText("$${taco.precio_item}")


            return vista
        }
    }
}