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

class PlatillosActivity : AppCompatActivity() {

    var comidas = ArrayList<platillo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_platillos)

        agregaPlatillos()

        var listview: ListView = findViewById(R.id.liview) as ListView
        var adaptador: AdaptadorPlatillos= AdaptadorPlatillos(this, comidas)
        listview.adapter = adaptador
    }

    fun agregaPlatillos(){
        comidas.add(platillo(R.drawable.imgtacos,"TACOS",2.35f))
        comidas.add(platillo(R.drawable.img_antojitos,"ANTOJITOS",0.00f))
        comidas.add(platillo(R.drawable.img_especialidades,"ESPECIALIDADES",0.00f))
        comidas.add(platillo(R.drawable.img_caldos,"CALDOS",0.00f))
        comidas.add(platillo(R.drawable.img_combinations,"COMBINATIONS",0.00f))
        comidas.add(platillo(R.drawable.img_tortas,"TORTAS",0.00f))
        comidas.add(platillo(R.drawable.img_sopas,"SOPAS",0.00f))
        comidas.add(platillo(R.drawable.img_side,"SIDE ORDERS",0.00f))
    }

    private class AdaptadorPlatillos: BaseAdapter {
        var platillos = ArrayList<platillo>()
        var contexto: Context? = null

        constructor(contexto: Context,platillos: ArrayList<platillo>){
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

            imagen.setImageResource(comida.image_platillo)
            nombre.setText(comida.nombre_platillo)
            precio.setText("$${comida.precio_platillo}")

            return vista
        }
    }
}