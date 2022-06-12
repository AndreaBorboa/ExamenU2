package borboa.andrea.examenu2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdaptadorProductos internal constructor(private val productosList: List<item>, private val lista:ArrayList<item>) :
    RecyclerView.Adapter<AdaptadorProductos.ProductosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_platillo, parent, false)
        return ProductosViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {

        val v:View= holder.itemView
        var cantidad:Int = (productosList[position].cantidad) + 1
        holder.nombre.setText(productosList[position].nombre_item)
        holder.descripcion.setText(productosList[position].descripcion_item)
        holder.precio.setText("$${productosList[position].precio_item}")
        holder.cantidad.setText("${cantidad}")

        holder.btn_mas.setOnClickListener {
            cantidad= cantidad + 1
            productosList[position].total= productosList[position].precio_item * cantidad
            holder.cantidad.setText("${cantidad}")
        }

        holder.btn_menos.setOnClickListener {
            cantidad = cantidad - 1
            productosList[position].total= productosList[position].precio_item * cantidad
            holder.cantidad.setText("${cantidad}")
        }

        holder.btn_añadir.setOnClickListener {
            var intent = Intent(v.context, CarritoActivity::class.java)

            lista.add(item(productosList[position].nombre_item,productosList[position].descripcion_item,productosList[position].precio_item,cantidad,productosList[position].total))

            intent.putExtra("listaCarrito",lista)

            v.context!!.startActivity(intent)
        }

    }

    inner class ProductosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nombre : TextView
        val descripcion : TextView
        val precio : TextView
        val cantidad : TextView
        val btn_mas : Button
        val btn_menos: Button
        val btn_añadir : Button


        init {
            nombre = itemView.findViewById(R.id.platillo_nombre)
            descripcion = itemView.findViewById(R.id.platillo_desc)
            precio=itemView.findViewById(R.id.platillo_precio)
            cantidad = itemView.findViewById(R.id.platillo_cantidad)
            btn_mas = itemView.findViewById(R.id.btn_mas)
            btn_menos = itemView.findViewById(R.id.btn_menos)
            btn_añadir = itemView.findViewById(R.id.btn_añadir)


        }
    }

    override fun getItemCount(): Int {
        return productosList.size

    }
}
