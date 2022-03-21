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

class EspecialidadesActivity : AppCompatActivity() {

    var especialidades = ArrayList<item>()
    var adapter: AdaptadorEspecialidades? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        agregaEspecialidades()

        var listview: ListView = findViewById(R.id.liview_platillos) as ListView
        var adaptador: AdaptadorEspecialidades = AdaptadorEspecialidades(this, especialidades)
        listview.adapter = adaptador

    }

    fun agregaEspecialidades() {
        especialidades.add(item(R.drawable.imgtacos, "Mojarra Frita / Fried Fish", 14.99))
        especialidades.add(item(R.drawable.imgtacos, "Tostadas de ceviche", 2.99))
        especialidades.add(item(R.drawable.imgtacos, "Fajita Burrito", 11.79))
        especialidades.add(item(R.drawable.imgtacos, "Fajita Quesadilla", 12.49))
        especialidades.add(item(R.drawable.imgtacos, "Botana de Camarones", 17.99))
        especialidades.add(item(R.drawable.imgtacos, "Coctel de Camaron", 14.50))
    }

    class AdaptadorEspecialidades : BaseAdapter {
        var especialidades = ArrayList<item>()
        var contexto: Context? = null

        constructor(contexto: Context, especialidades: ArrayList<item>) {
            this.especialidades = especialidades
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return especialidades.size
        }

        override fun getItem(p0: Int): Any {
            return especialidades[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var especialidades = especialidades[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.item_platillos, null)

            var imagen = vista.findViewById(R.id.img_platillo) as ImageView
            var nombre = vista.findViewById(R.id.nombre_platillo) as TextView
            var precio = vista.findViewById(R.id.precio_platillo) as TextView

            imagen.setImageResource(especialidades.image_item)
            nombre.setText(especialidades.nombre_item)
            precio.setText("$${especialidades.precio_item}")


            return vista
        }
    }
}
