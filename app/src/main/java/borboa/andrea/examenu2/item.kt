package borboa.andrea.examenu2

import java.io.Serializable

data class item(var nombre_item:String="",
                var descripcion_item:String="",
                var precio_item:Double,
                var cantidad:Int,
                var total:Double):Serializable
