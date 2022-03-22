package borboa.andrea.examenu2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class detalle_platillos : AppCompatActivity() {
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
            iv_imagen_item.setImageResource(bundle.getInt("image_item"))
            tv_nombre_item.setText(bundle.getString("nombre_item"))
            tv_precio_item.setText(bundle.getString("precio_item"))
        }

        val item_cantidad: TextView = findViewById(R.id.et_cantidad)

        var cantidad = Integer.parseInt(et_cantidad.text.toString())
        var precio = Integer.parseInt(tv_precio_item.text.toString())

        var total=cantidad*precio
        tv_total.setText(total.toString())

    }
}