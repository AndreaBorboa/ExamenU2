package borboa.andrea.examenu2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class detalle_platillos : AppCompatActivity() {

    var precio : Double = 0.0
    var total : Double = 0.0
    var cantidad : Int = 1

    val iv_imagen_item: ImageView = findViewById(R.id.imagen_selected)
    val tv_nombre_item: TextView = findViewById(R.id.item_selected)
    val tv_precio_item: TextView = findViewById(R.id.item_precio)
    val et_cantidad: EditText = findViewById(R.id.et_cantidad)
    val tv_total: TextView= findViewById(R.id.tv_total)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.item_seleccion)

        val bundle=intent.extras

        if(bundle!=null){
            var comida = bundle.getString("nombre")
            if(comida != null){
                Log.d("Nombre del platillo",comida)
            }

            iv_imagen_item.setImageResource(bundle.getInt("imagen"))
            tv_nombre_item.setText(bundle.getString("nombre").toString())
            et_cantidad.setText(bundle.getString("cantidad").toString())

            precio = bundle.getDouble("precio")
            total = bundle.getDouble("total")

            tv_precio_item.setText(precio.toString())
            tv_total.setText(total.toString())
            var total1=cantidad*precio

        }
    }
}