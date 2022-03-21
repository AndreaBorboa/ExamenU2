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

class DrinksActivity : AppCompatActivity() {

    var drinks = ArrayList<drink>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drinks)

        agregaDrinks()

        var listview1: ListView = findViewById(R.id.liview_drinks) as ListView
        var adaptador1: AdaptadorDrinks= AdaptadorDrinks(this, drinks)
        listview1.adapter = adaptador1

    }

    fun agregaDrinks(){
        drinks.add(drink(R.drawable.sodas,"SODAS",2.75))
        drinks.add(drink(R.drawable.jarrito,"JARRITOS",2.35))
        drinks.add(drink(R.drawable.aguafresca,"AGUA FRESCA",2.75))
        drinks.add(drink(R.drawable.domesticbeer,"DOMESTIC BEER",6.75))
        drinks.add(drink(R.drawable.mexicanbeer,"MEXICAN BEER",6.75))
        drinks.add(drink(R.drawable.michelada,"MICHELADA",6.75))
        drinks.add(drink(R.drawable.cahuamamichelada,"CAHUAMA MICHELADA",10.99))
        drinks.add(drink(R.drawable.cubetazos,"CUBETAZOS",19.99))
    }

    private class AdaptadorDrinks: BaseAdapter {
        var drinks = ArrayList<drink>()
        var contexto: Context? = null

        constructor(contexto: Context,drinks: ArrayList<drink>){
            this.drinks= drinks
            this.contexto= contexto
        }

        override fun getCount(): Int {
            return drinks.size
        }

        override fun getItem(p0: Int): Any {
            return drinks[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var drink = drinks[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.item_drinks,null)

            var imagen = vista.findViewById(R.id.img_drink) as ImageView
            var nombre = vista.findViewById(R.id.nombre_drink) as TextView
            var precio = vista.findViewById(R.id.precio_drink) as TextView

            imagen.setImageResource(drink.imagen_drink)
            nombre.setText(drink.nombre_drink)
            precio.setText("$${drink.precio_drink}")


            return vista
        }
    }
}