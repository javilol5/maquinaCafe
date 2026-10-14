package javier.casal

object CoffeeMachine {
    public var currentState: CoffeeMachineState = CoffeeMachineState.Idle

    fun gestorEstados() {
        println("Estado actual: $currentState")

        when (currentState) {
            is CoffeeMachineState.Idle -> {
                println("Máquina encendida. Empezando a hacer café...")
                currentState = CoffeeMachineState.SeleccionandoCafe("Café con leche")
                Thread.sleep(2000)
            }
            is CoffeeMachineState.SeleccionandoCafe -> {
                println("Seleccionando café...")
                currentState = CoffeeMachineState.Pagando
            }
            is CoffeeMachineState.Pagando -> {
                println("Se ha realizado el pago")
                currentState = CoffeeMachineState.RestoPago
            }
            is CoffeeMachineState.RestoPago -> {
                println("Devolviendo Dinero restante...")
                currentState = CoffeeMachineState.HaciendoCafe
            }
            is CoffeeMachineState.HaciendoCafe -> {
                println("La máquina ya está haciendo café.")
                currentState = CoffeeMachineState.SirviendoCafe("Café con leche")
            }
            is CoffeeMachineState.SirviendoCafe -> {
                println("El café ya está servido, recoja el producto")
            }
            is CoffeeMachineState.Error -> {
                println("La máquina tiene un error: ${(currentState as CoffeeMachineState.Error).message}")
            }
        }
    }

    fun reparando() {
        println("La máquina no está en correcto funcionamiento y se está reparando, vuelva en otro momento")
        currentState = CoffeeMachineState.Idle
        println("Se ha reparado la máquina, ya puede hacer su pedido. Estado: $currentState")
    }
}