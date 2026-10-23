package javier.casal

// Clase para representar los diferentes tipos de cafés disponibles en la máquina, su precio u stock

class Cafes (
    var nombre: String,
    var precio: Double,
    var stock: Int
){
    companion object {
        val catalogo = mutableListOf(
            Cafes("Cafe Solo", 1.20, 5),
            Cafes("Cafe con Leche", 1.50, 5),
            Cafes("Cafe Cortado", 1.30, 5),
            Cafes("Cafe Americano", 1.10, 0),
            Cafes("Cafe Capuchino", 1.80, 5),
        )

        fun buscarCafes(nombreBebida: String): Cafes? {
            return catalogo.find { it.nombre.equals(nombreBebida, ignoreCase = true) }
        }
    }
}