package borboa.andrea.examenu2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CarritoActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)

        val lista = ArrayList<item>()


        lista.addAll(intent.getSerializableExtra("listaCarrito") as ArrayList<item>)


        var total = lista.map {
            it.total.toString().toDouble()
        }?.sum().toString().toDouble()

        var adaptador:AdaptadorCarrito
        var listview: RecyclerView = findViewById(R.id.liview_carrito) as RecyclerView
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        listview.setLayoutManager(layoutManager)

        adaptador = AdaptadorCarrito(lista)
        listview.adapter = adaptador


        var totalView: TextView = findViewById(R.id.tv_total) as TextView
        totalView.setText("$${"%.2f".format(total)}")
        var btn_continuar: Button = findViewById(R.id.btn_continuar) as Button
        var btn_comprar: Button = findViewById(R.id.btn_comprar) as Button


        btn_continuar.setOnClickListener{
            var intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("listaCarrito",lista)
            this!!.startActivity(intent)
        }

        btn_comprar.setOnClickListener{
            Toast.makeText(applicationContext,"Gracias por tu compra !",
                Toast.LENGTH_SHORT).show()
            lista.clear()
            var intent = Intent(this, CarritoActivity::class.java)
            intent.putExtra("listaCarrito",lista)
            this!!.startActivity(intent)
        }


    }
}

