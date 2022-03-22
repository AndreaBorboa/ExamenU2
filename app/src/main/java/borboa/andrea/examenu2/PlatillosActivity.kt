package borboa.andrea.examenu2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class PlatillosActivity : AppCompatActivity() {

    var comidas = ArrayList<item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_platillos)

        agregaPlatillos()

        var listview: ListView = findViewById(R.id.liview) as ListView
        var adaptador: AdaptadorPlatillos= AdaptadorPlatillos(this, comidas)
        listview.adapter = adaptador

        listview.setOnItemClickListener(
            OnItemClickListener { parent, view, position, id ->
                if (position == 0) {
                    // Abre una nueva Activity:
                    val myIntent = Intent(view.context, TacosActivity::class.java)
                    startActivity(myIntent)
                } else if (position == 1) {
                    // Abre una nueva Activity:
                    val myIntent = Intent(view.context, AntojitosActivity::class.java)
                    startActivity(myIntent)
                } else if (position == 2) {
                    // Abre una nueva Activity:
                    val myIntent = Intent(view.context, EspecialidadesActivity::class.java)
                    startActivity(myIntent)
                } else if (position == 3) {
                    // Abre una nueva Activity:
                    val myIntent = Intent(view.context, CaldosActivity::class.java)
                    startActivity(myIntent)
                } else if (position == 4) {
                    // Abre una nueva Activity:
                    val myIntent = Intent(view.context, CombinationsActivity::class.java)
                    startActivity(myIntent)
                } else if (position == 5) {
                    // Abre una nueva Activity:
                    val myIntent = Intent(view.context, TortasActivity::class.java)
                    startActivity(myIntent)
                } else if (position == 6) {
                    // Abre una nueva Activity:
                    val myIntent = Intent(view.context, SopasActivity::class.java)
                    startActivity(myIntent)
                } else if (position == 7) {
                    // Abre una nueva Activity:
                    val myIntent = Intent(view.context, SideOrdersActivity::class.java)
                    startActivity(myIntent)
                } else if (position == 8) {
                    // Abre una nueva Activity:
                    val myIntent = Intent(view.context, BebidasActivity::class.java)
                    startActivity(myIntent)
                }

            }
        )

    }

    fun agregaPlatillos(){
        comidas.add(item(R.drawable.tacos,"TACOS",2.35))
        comidas.add(item(R.drawable.huarache,"ANTOJITOS",0.0))
        comidas.add(item(R.drawable.img_especialidades,"ESPECIALIDADES",0.0))
        comidas.add(item(R.drawable.caldores,"CALDOS",0.0))
        comidas.add(item(R.drawable.combinations,"COMBINATIONS",0.0))
        comidas.add(item(R.drawable.torta,"TORTAS",0.0))
        comidas.add(item(R.drawable.pozole,"SOPAS",0.0))
        comidas.add(item(R.drawable.sideorders,"SIDE ORDERS",0.0))
        comidas.add(item(R.drawable.bebidas,"DRINKS",0.0))
    }

    private class AdaptadorPlatillos: BaseAdapter {
        var platillos = ArrayList<item>()
        var contexto: Context? = null

        constructor(contexto: Context,platillos: ArrayList<item>){
            this.platillos= platillos
            this.contexto= contexto
        }

        override fun getCount(): Int {
            return platillos.size
        }

        override fun getItem(p0: Int): Any {
            return platillos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var comida = platillos[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.item_platillos,null)

            var imagen = vista.findViewById(R.id.img_platillo) as ImageView
            var nombre = vista.findViewById(R.id.nombre_platillo) as TextView
            var precio = vista.findViewById(R.id.precio_platillo) as TextView

            imagen.setImageResource(comida.image_item)
            nombre.setText(comida.nombre_item)
            precio.setText("$${comida.precio_item}")

            return vista
        }
    }
}