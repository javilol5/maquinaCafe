package javier.casal

sealed class CoffeeMachineState {
    object Inactivo : CoffeeMachineState()
    object EsperandoDinero : CoffeeMachineState()
    data class Seleccionando(val producto: String) : CoffeeMachineState()
    data class Preparando(val producto: String) : CoffeeMachineState()
    data class ServirBebida(val producto: String, val cambio: Double) : CoffeeMachineState()
    data class FueraServicio(val motivo: String) : CoffeeMachineState()
}