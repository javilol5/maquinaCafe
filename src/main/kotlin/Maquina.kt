package javier.casal

object CoffeeMachine {
    var estadoActual: CoffeeMachineState = CoffeeMachineState.Inactivo
    var saldo: Double = 0.0

    // Inactivo -> EsperandoDinero
    fun encender() {
        if (estadoActual is CoffeeMachineState.Inactivo) {
            println("Máquina encendida e iniciando servicio.")
            estadoActual = CoffeeMachineState.EsperandoDinero
        } else {
            println("La máquina no se encuentra inactiva.")
        }
    }

    // EsperandoDinero -> Seleccionando
    fun insertarDinero(cantidad: Double) {
        if (estadoActual is CoffeeMachineState.EsperandoDinero) {
            saldo += cantidad
            println("Dinero insertado: $cantidad€. Saldo total: $saldo€")
            if (saldo > 0) {
                estadoActual = CoffeeMachineState.Seleccionando("Sin selección")
            }
        } else {
            println("No se puede insertar dinero en el estado actual: $estadoActual")
        }
    }

    // Seleccionando -> Preparando (o vuelta a EsperandoDinero al cancelar)
    fun seleccionarProducto(producto: String, precio: Double) {
        when (estadoActual) {
            is CoffeeMachineState.Seleccionando -> {
                if (saldo >= precio) {
                    println("Producto seleccionado: $producto (Precio: $precio€)")
                    saldo -= precio
                    estadoActual = CoffeeMachineState.Preparando(producto)
                } else {
                    println("Saldo insuficiente ($saldo€) para $producto ($precio€). Volviendo a EsperandoDinero...")
                    estadoActual = CoffeeMachineState.EsperandoDinero
                }
            }
            else -> println("Debe insertar dinero antes de seleccionar un producto.")
        }
    }

    fun cancelarCompra() {
        if (estadoActual is CoffeeMachineState.Seleccionando) {
            println("Compra cancelada. Devolviendo saldo: $saldo€")
            saldo = 0.0
            estadoActual = CoffeeMachineState.EsperandoDinero
        }
    }

    // Preparando -> ServirBebida o FueraServicio
    fun preparar(hayIngredientes: Boolean = true) {
        val estado = estadoActual
        if (estado is CoffeeMachineState.Preparando) {
            println("Validando agua, azúcar, vasos y granos para: ${estado.producto}...")
            if (hayIngredientes) {
                println("Preparando la bebida...")
                Thread.sleep(1000)
                val cambio = saldo
                saldo = 0.0
                estadoActual = CoffeeMachineState.ServirBebida(estado.producto, cambio)
            } else {
                println("Fallo crítico: Falta de ingredientes o fallo mecánico.")
                estadoActual = CoffeeMachineState.FueraServicio("Falta de ingredientes")
            }
        }
    }

    // ServirBebida -> EsperandoDinero
    fun entregarProducto() {
        val estado = estadoActual
        if (estado is CoffeeMachineState.ServirBebida) {
            println("Servida la bebida: ${estado.producto}. Cambio entregado: ${estado.cambio}€")
            estadoActual = CoffeeMachineState.EsperandoDinero
        }
    }

    // FueraServicio -> EsperandoDinero / Inactivo
    fun reparar() {
        if (estadoActual is CoffeeMachineState.FueraServicio) {
            println("Reparando y reponiendo máquina...")
            estadoActual = CoffeeMachineState.EsperandoDinero
            println("Sistema recuperado. Estado actual: $estadoActual")
        }
    }

    // Apagado del sistema
    fun apagar() {
        println("Apagando la máquina de café...")
        estadoActual = CoffeeMachineState.Inactivo
    }
}