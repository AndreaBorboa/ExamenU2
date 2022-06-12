package borboa.andrea.examenu2
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCarrito internal constructor(private val productosList: ArrayList<item>) :
    RecyclerView.Adapter<AdaptadorCarrito.CarritoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_carrito, parent, false)
        return CarritoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarritoViewHolder, position: Int) {
        val v:View= holder.itemView

        var cantidad:Int = (productosList[position].cantidad)
        holder.nombre.setText(productosList[position].nombre_item)
        holder.precio.setText("$${productosList[position].precio_item}")
        holder.cantidad.setText("${cantidad}")
        var totalNuevo:Double=productosList[position].precio_item * cantidad
        productosList[position].total = totalNuevo
        holder.total.setText("$${"%.2f".format(productosList[position].total)}")


        holder.btn_mas.setOnClickListener {
            cantidad= cantidad + 1
            holder.cantidad.setText("${cantidad}")
            productosList[position].total = productosList[position].precio_item * cantidad
            totalNuevo = productosList[position].precio_item * cantidad
            holder.total.setText("$${"%.2f".format(totalNuevo)}")

            var intent = Intent(v.context, CarritoActivity::class.java)
            productosList[position].cantidad = cantidad
            intent.putExtra("listaCarrito",productosList)
            v.context!!.startActivity(intent)

        }

        holder.btn_menos.setOnClickListener {
            cantidad = cantidad - 1
            holder.cantidad.setText("${cantidad}")
            productosList[position].total = productosList[position].precio_item * cantidad
            totalNuevo = productosList[position].precio_item * cantidad
            holder.total.setText("$${"%.2f".format(totalNuevo)}")

            var intent = Intent(v.context, CarritoActivity::class.java)
            productosList[position].cantidad = cantidad
            if(cantidad<1){
                productosList.removeAt(position)
            }
            intent.putExtra("listaCarrito",productosList)
            v.context!!.startActivity(intent)
        }

        holder.btn_carrito.setOnClickListener{
            var intent = Intent(v.context, CarritoActivity::class.java)
            productosList.removeAt(position)
            intent.putExtra("listaCarrito",productosList)
            v.context!!.startActivity(intent)
        }

    }

    inner class CarritoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nombre : TextView
        val precio : TextView
        val cantidad : TextView
        val btn_mas : Button
        val btn_menos: Button
        val total:TextView
        val btn_carrito : Button



        init {
            nombre = itemView.findViewById(R.id.platillo_nombre)
            precio=itemView.findViewById(R.id.platillo_precio)
            cantidad = itemView.findViewById(R.id.platillo_cantidad)
            btn_mas = itemView.findViewById(R.id.btn_mas)
            btn_menos = itemView.findViewById(R.id.btn_menos)
            total = itemView.findViewById(R.id.platillo_total)
            btn_carrito = itemView.findViewById(R.id.carrito)
        }
    }

    override fun getItemCount(): Int {
        return productosList.size

    }
}
