package javier.casal

fun main() {
    println("--- Encendiendo la máquina ---")
    CoffeeMachine.gestorEstados()

    println("\n--- Intentando hacer café de nuevo ---")
    CoffeeMachine.gestorEstados()

    println("\n--- Limpiando la máquina ---")
    CoffeeMachine.reparando()

    println("\n--- Y ahora, otro café ---")
    CoffeeMachine.gestorEstados()
}