package borboa.andrea.examenu2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CarritoActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)

        val listaCarrito = ArrayList<item>()

         var nombre_platillo:String
         var precio_platillo:Double
         var cantidad_platillo:Int
         var descripcion_platillo:String
         var total_platillo:Double

        val bundle = intent.extras
        nombre_platillo = bundle?.getString("nombre").toString()
        precio_platillo = bundle?.getDouble("precio").toString().toDouble()
        cantidad_platillo = bundle?.getInt("cantidad").toString().toInt()
        descripcion_platillo = bundle?.getString("descripcion").toString()
        total_platillo = bundle?.getDouble("total").toString().toDouble()


        listaCarrito.add(item(nombre_platillo,descripcion_platillo,precio_platillo,cantidad_platillo,total_platillo))
        var totalPrecios = listaCarrito.map {
            it.precio_item.toString().toDouble()
        }?.sum().toString().toDouble()

        var totalCantidad = listaCarrito.map{
            it.cantidad.toString().toInt()
        }?.sum().toString().toInt()


        val total = totalCantidad*totalPrecios

        var adaptador:AdaptadorCarrito
        var listview: RecyclerView = findViewById(R.id.liview_carrito) as RecyclerView
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        listview.setLayoutManager(layoutManager)

        adaptador = AdaptadorCarrito(listaCarrito)
        listview.adapter = adaptador


        var totalView: TextView = findViewById(R.id.tv_total) as TextView
        totalView.setText("${total}")
    }
}