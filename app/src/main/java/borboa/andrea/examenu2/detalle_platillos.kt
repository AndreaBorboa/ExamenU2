package borboa.andrea.examenu2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class detalle_platillos : AppCompatActivity() {
    val iv_imagen_item: ImageView = findViewById(R.id.imagen_selected)
    val tv_nombre_item: TextView = findViewById(R.id.item_selected)
    val tv_precio_item: TextView = findViewById(R.id.item_precio)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_seleccion)

        val bundle=intent.extras
        if(bundle!=null){
            iv_imagen_item.setImageResource(bundle.getInt("image_item"))
            tv_nombre_item.setText(bundle.getString("nombre_item"))
            tv_precio_item.setText(bundle.getString("precio_item"))
        }
    }
}