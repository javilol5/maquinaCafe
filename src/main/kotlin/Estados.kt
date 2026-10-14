package javier.casal

class Estados {
    fun e0(){
        println("Estado 0")
    }

    fun e1(){
        println("Estado 1")
    }

    fun e2(){
        println("Estado 2")
    }

    fun e3(){
        println("Estado 3, terminando el programa.")
    }

    fun e4(){
        println("Estado 4, volviendo a Estado 1")
        println("Estado 0, interrumpiendo ejecución")
    }


    fun gestion_estados(a: Boolean, b: Boolean) {

        var estate3: Boolean = false;

        while (!estate3){

            e1()

            // Si a es true, continuaremos el proceso
            if (a){

                // Estado 2
                e2()

                // Si b es true, continuaremos al estado 3
                if (!b){
                    //Estado 3
                    e3()

                    // En caso de que estado sea 3, pasaremos estate3 a true, interrumpiendo el programa
                    estate3 = true;

                    e0();
                }
                else  if (b){

                    // En caso de que b sea false, comunicaremos el error volviendo a E1
                    e4()
                    break
                }
            }
            else{
                println("A no es true, interrumpiendo el programa...")
                break
            }
        }
    }
}