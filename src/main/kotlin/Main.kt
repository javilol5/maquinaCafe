package javier.casal

fun main() {
    println("--- 1. Encendido ---")
    CoffeeMachine.encender()

    println("\n--- 2. Flujo Exitoso ---")
    CoffeeMachine.insertarDinero(2.00)
    CoffeeMachine.seleccionarProducto("Café Solo", 1.20)
    CoffeeMachine.preparar(hayIngredientes = true)
    CoffeeMachine.entregarProducto()

    println("\n--- 3. Flujo con Error (Fuera de Servicio) ---")
    CoffeeMachine.insertarDinero(1.50)
    CoffeeMachine.seleccionarProducto("Café con Leche", 1.50)
    CoffeeMachine.preparar(hayIngredientes = false)

    println("\n--- 4. Mantenimiento y Recuperación ---")
    CoffeeMachine.reparar()

    println("\n--- 5. Fin de servicio ---")
    CoffeeMachine.apagar()
}