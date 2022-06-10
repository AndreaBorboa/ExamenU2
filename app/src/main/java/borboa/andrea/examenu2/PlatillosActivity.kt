package borboa.andrea.examenu2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class PlatillosActivity : AppCompatActivity() {

    var tacos = ArrayList<item>()
    var antojitos = ArrayList<item>()
    var especialidades = ArrayList<item>()
    var caldos = ArrayList<item>()
    var combinations = ArrayList<item>()
    var tortas = ArrayList<item>()
    var sopas = ArrayList<item>()
    var sideorders = ArrayList<item>()
    var drinks = ArrayList<item>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_platillos)
        //var adaptador:AdaptadorProductos

        var menuOption: String? = intent.getStringExtra("menuType")

        if (menuOption != null) {
            agregaPlatillo(menuOption)
        }

    }


    fun agregaPlatillo(option:String){
        var adaptador:AdaptadorProductos
        var tituloPlatillo = findViewById<TextView>(R.id.titulo) as TextView
        var listview: RecyclerView = findViewById(R.id.liview_platillos) as RecyclerView
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        listview.setLayoutManager(layoutManager)
        when(option) {
            "tacos" -> {
                tacos.add(item("Asada/Beef Steak", "Traditional Taco", 2.35,0,2.35))
                tacos.add(item("Pollo/Chicken", "Traditional Taco", 2.35,0,2.35))
                tacos.add(item("Carnitas/Pulled Pork", "Traditional Taco", 2.35,0,2.35))
                tacos.add(item("Chorizo/Mexican Sausage", "Traditional Taco", 2.35,0,2.35))
                tacos.add(item("Suadero/Shredded Beef", "Traditional Taco", 2.35,0,2.35))
                tacos.add(item("Biche/Pork Stomach", "Traditional Taco", 2.35,0,2.35))
                tacos.add(item("Al pastor/Marinated Pork", "Traditional Taco", 2.35,0,2.35))
                tacos.add(item("Cachete/Beef Cheek", "Traditional Taco", 2.35,0,2.35))
                tacos.add(item("Barbacoa/BBQ", "Traditional Taco", 2.35,0,2.35))
                tacos.add(item("Tripa/Beef Intestine", "Traditional Taco", 2.35,0,2.35))
                tacos.add(item("Chicharron/Pork Rinds", "Traditional Taco", 2.35,0,2.35))
                tacos.add(item("Cueritos/Pork Skin", "Traditional Taco", 2.35,0,2.35))
                tacos.add(item("Lengua", "Traditional Taco", 3.99,0,3.99))
                tacos.add(item("Taco de Pescado", "Traditional Taco", 2.35,0,2.35))
                adaptador = AdaptadorProductos(tacos)
                tituloPlatillo.setText("TACOS")
                listview.adapter = adaptador
            }
            "antojitos" ->{
                antojitos.add(item("Quesadillas","Rellenas con su carne favorita, servidas con ensalada. Filled with your choice of meat, served with salad.", 4.75,0,4.75))
                antojitos.add(item("Huaraches","Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema. Big Thick tortilla with beans, your choice of meat, fresh cheese, and sour cream.", 9.87,0,9.87))
                antojitos.add(item("Gringas","Tortilla de harina con queso, carne al pastor y piña Flour tortilla with cheese marinated pork and pineapple.", 6.47,0,6.47))
                antojitos.add(item("Sincronizadas","Tortilla de harina rellena con queso y jamon. Se sirve con lechuga, crema y guacamole Sandwich of Two four tortillas filled with ham and cheese. Served with lettuce, sour cream, and guacamole.", 6.98,0,6.98))
                antojitos.add(item("Sopes","Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema Fried thick tortilla with beans, your choice of meat, lettuce, fresh cheese, sour cream and tomatoes.", 3.39,0,3.39))
                antojitos.add(item("Tostadas","Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate Fried tortilla with beans, your choice of meat, lettuce, fresh cheese, sour cream and tomatoes.", 3.55,0,3.55))
                adaptador = AdaptadorProductos(antojitos)
                tituloPlatillo.setText("ANTOJITOS")
                listview.adapter = adaptador
            }
            "especialidades"->{
                especialidades.add(item("Mojarra Frita / Fried Fish","Tilapia frita servida con lechiga, cebolla, jitomate, aguacate y tortillas. Agregue arroz y frijoles.", 14.99,0,14.99))
                especialidades.add(item("Tostadas de ceviche", "Tilapia, camarones y pico de gallo servido en una crujiente tostada Tilapia, Shrimp and pico de gallo, served on a crispy shell.",2.99,0,2.99))
                especialidades.add(item( "Fajita Burrito", "Gran burrito relleno de tu carne favorita, cebolla, chile, arroz, frijoles y jitomate. Servido con lechuga y guacamole Large burrito filled with your choice of meat, onions, chile, peppers, rice, beans and tomatoes. Served with lettuce guacamole and sour cream.",11.79,0,11.79))
                especialidades.add(item( "Fajita Quesadilla","Quesadilla extra grande, rellena con tu carne favorita, cebolla asada, chile banana y jitomate. Servida con arroz, frijoles y ensalada Extra large quesadilla with your choice of meat, cooked with grilled onions, banana peppers and tomatoes. Served with rice beans and salad.", 12.49,0,12.49))
                especialidades.add(item("Botana de Camarones","Botana", 17.99,0,17.99))
                especialidades.add(item("Coctel de Camaron","Coctel", 14.50,0,14.50))
                adaptador = AdaptadorProductos(especialidades)
                tituloPlatillo.setText("ESPECIALIDADES")
                listview.adapter = adaptador
            }
            "caldos"->{
                caldos.add(item("Langer","Caldo", 10.99,0,10.99))
                caldos.add(item("Camaron","Caldo", 11.99,0,11.99))
                adaptador = AdaptadorProductos(caldos)
                tituloPlatillo.setText("CALDOS")
                listview.adapter = adaptador
            }
            "combinations"->{
                combinations.add(item("Tradicional Taco Combo","Tortilla de Maiz, tu carne favorita, servido con arroz y frijoles Corn tortilla taco, your choice of meat, served with rice and beans.", 6.99,0,6.99))
                combinations.add(item("Mexican Burritos","Your choice of meat on a big burrito made of flour tortilla with rice, beans, lettuce, grilled onions, pico de gallo, guacamole and sour cream.",10.99,0,10.99))
                combinations.add(item("Los Portales Burrito","A flour tortilla wrapped around grilled cactus, steak, pastor, (Seasoned Pork) grilled onions, rice and beans. Served a side of lettuce salad, tomatoes, sour cream and guacamole.",11.79,0,11.79))
                combinations.add(item("Cinco","One hard sell taco with your choice of meat, lettuce and cheese. One burrito with your choice of meat, pico de gallo, sour cream, guacamole and beans. Served with rice and beans.",7.67,0,7.67))
                combinations.add(item("Dos Amigos", "Two hard shell tacos with your choice of meat topped with lettuce and shredded cheese. served with a side of rice and beans.",8.25,0,8.25))
                combinations.add(item("Burrito Pepe","\n" +
                        "A flour tortilla wrapped around your choice of meat with beans, lettuce, sour cream, guacamole and pico de gallo. served with a side of rice.", 6.89,0,6.89))
                adaptador = AdaptadorProductos(combinations)
                tituloPlatillo.setText("COMBINATIONS")
                listview.adapter = adaptador
            }
            "tortas"->{
                tortas.add(item("Torta Regular","All tortas come with lettuce, onions, tomatoes, avocado do, sour cream, mayo, jalapeno pepper and your choice of meat.", 10.95,0,10.95))
                tortas.add(item("Torta Milanesa de Res o Pollo", "Breaded Steak or Chicken.",11.99,0,11.99))
                tortas.add(item("Torta Cubana","Chorizo, asada, jamon, pastor y queso Mexican sausage, steak, marinated pork, ham, and cheese.", 12.35,0,12.35))
                tortas.add(item("Torta Mixta","Chorizo, asada y pastor Mexican sausage, steak and marinated pork.", 11.99,0,11.99))
                tortas.add(item("Small Mexican Torta", "Bolillo bread sandwich with your choice of filling. Topped with Lettuce, tomatoes, onions, and avocado.",6.89,0,6.89))
                adaptador = AdaptadorProductos(tortas)
                tituloPlatillo.setText("TORTAS")
                listview.adapter = adaptador
            }
            "sopas"->{
                sopas.add(item("Pozole","Weekends only", 5.99,0,5.99))
                sopas.add(item("Menudo","Wednesday to Sunday", 5.99,0,5.99))
                sopas.add(item("Caldo de Res", "....",5.99,0,5.99))
                sopas.add(item("Caldo de Camaron", "Shrimp soup",10.69,0,10.69))
                sopas.add(item("Sopa de Mariscos","Seafood soup", 15.75,0,15.75))
                sopas.add(item("Coctel de Camaron","Shrimp cocktail", 13.50,0,13.50))
                adaptador = AdaptadorProductos(sopas)
                tituloPlatillo.setText("SOPAS")
                listview.adapter = adaptador
            }
            "sideorders"->{
                sideorders.add(item("Side Of Guacamole", "...",3.75,0,3.75))
                sideorders.add(item("Side Of Rice","...", 1.99,0,1.99))
                sideorders.add(item("Side Of Beans","...", 1.99,0,1.99))
                sideorders.add(item("Chips and Salsa", "...",2.25,0,2.25))
                sideorders.add(item("Flour Tacos","...", 2.99,0,2.99))
                adaptador = AdaptadorProductos(sideorders)
                tituloPlatillo.setText("SIDE ORDERS")
                listview.adapter = adaptador
            }
            "drinks"->{
                drinks.add(item("Sodas","drink", 2.75,0,2.75))
                drinks.add(item("Jarritos","drink", 2.35,0,2.35))
                drinks.add(item("Aguas Frescas","drink", 2.75,0,2.75))
                drinks.add(item("Domestic Beer","drink", 3.55,0,3.55))
                drinks.add(item("Mexican Beer","drink", 3.99,0,3.99))
                drinks.add(item("Micheladas","drink", 6.75,0,6.75))
                drinks.add(item("Caguama", "drink",7.99,0,7.99))
                drinks.add(item("Caguama Michelada","drink", 10.99,0,10.99))
                drinks.add(item("Cubetazos","drink", 19.99,0,19.99))
                drinks.add(item("Lata Beer","drink", 2.99,0,2.99))
                drinks.add(item("Charolazo","drink", 15.75,0,15.75))
                drinks.add(item("Charolazo con camarones","drink", 21.99,0,21.99))
                drinks.add(item("La mamalona","drink", 12.99,0,12.99))
                drinks.add(item("La mamalona con camarones","drink", 14.99,0,14.99))
                drinks.add(item("Cubetazo (6 cervezas)","drink", 21.99,0,21.99))
                adaptador = AdaptadorProductos(drinks)
                tituloPlatillo.setText("DRINKS")
                listview.adapter = adaptador
            }
        }

    }

}