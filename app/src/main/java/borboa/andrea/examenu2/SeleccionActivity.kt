package borboa.andrea.examenu2


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class SeleccionActivity : AppCompatActivity() {

    val iv_item_imagen: ImageView = findViewById(R.id.imagen_selected)
    val iv_item_nombre: TextView = findViewById(R.id.item_selected)
    val iv_item_precio: TextView = findViewById(R.id.item_precio)
    val et_cantidad: EditText = findViewById(R.id.et_cantidad)
    val btn_carrito: Button = findViewById(R.id.btn_carrito)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_seleccion)

        val bundle=intent.extras
        if(bundle!=null){
            iv_item_imagen.setImageResource(bundle.getInt("image_item"))
            iv_item_nombre.setText(bundle.getString("nombre_item"))
            iv_item_precio.setText(bundle.getString("precio_item"))
        }



    }
}