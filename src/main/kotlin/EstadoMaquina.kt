package javier.casal

sealed class CoffeeMachineState {
    object Idle : CoffeeMachineState()
    data class SeleccionandoCafe( val nomreCafe : String ) : CoffeeMachineState()
    object Pagando : CoffeeMachineState()
    object RestoPago : CoffeeMachineState()
    object HaciendoCafe : CoffeeMachineState()
    data class SirviendoCafe(val brand: String):CoffeeMachineState()
    data class Error(val message: String) : CoffeeMachineState()
}