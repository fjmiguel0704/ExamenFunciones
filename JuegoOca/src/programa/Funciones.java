package programa;

public class Funciones {
    // ^ Definimos la variable TAMCIRCUITO como final y global
    static final int TAMCIRCUITO = 11;

    // ^ Definimos las variables fichaJ1 y fichaJ2 como variables globales no estaticas, estas variables almacenarán la posición de los Jugadores
    static int fichaJ1, fichaJ2;

    // ^ Definimos las variables min y max para el dado, estas variables son globales estaticas y sirven para indicarle al programa el min y maximo de un dado
    static int minDado;
    static int maxDado;

    // ? El método tiraDados devolverá un número pseudoaleatorio entre el min y el max del dado
    static int tiraDados(){
        // ! Generamos un número double
        double resultado = Math.random() * (maxDado - minDado) + minDado;

        // ! Sumamos 0.5 para redondearlo
        resultado += 0.5d;

        // ! Devolvemos el número redondeado a un entero
        return (int) resultado;
    }

    // ? El método pintaPista estático pintara un tablero según el tama;o de la pista y la posición de los Jugadores
    static void pintaPista(){
        // ! Primero pintamos todo el tablero
        for (int pos = 0; pos <= TAMCIRCUITO; pos++){
            if (pos == 0){
                System.out.println("\t ");
            } else {
                System.out.print("\t" + pos);
            }
        }

        System.out.println(); // ? Cambiamos de Línea
        
        // ! Despues pintaremos la posición del Jugador 1
        for (int pos = 0; pos <= fichaJ1; pos++){
            if (pos == fichaJ1){
                System.out.print("J1");
            } else{
                System.out.print(" ");
            } System.out.print("\t");
        }

        System.out.println(); // ? Cambiamos de Línea
        
        // ! Por último pintaremos la posición del Jugador 2
        for (int pos = 0; pos <= fichaJ2; pos++){
            if (pos == fichaJ2){
                System.out.print("J2");
            } else{
                System.out.print(" ");
            } System.out.print("\t");
        }
    }

    // ? Esta función estatica devolverá true si la suma de la tirada es prima y false si la tirada np es prima
    static boolean sumaDeNumerosEsPrimo(int tirada1, int tirada2){
        // ^ Definimos la variable resultado que sera igual a la suma de las dos tiradas
        int resultado = tirada1 + tirada2;

        // ^ Definimos la variable state la cual cambiará según si es primo o no
        boolean state = true;

        // ! 1 o menor nunca será primo, en case contrario lo comprobaremos
        if(resultado <= 1){
            state = false;
        } else{
            for (int i = 2; i < resultado; i++){
                if (resultado % i == 0){ // ! En case de que alguno de los modulos de 0 no será primo
                    state = false;
                }
            }
        }

        // ! Si pasa todo lo anterior será primo, por lo que devolveremos true
        return state;
    }

    // ? Este método imprimirá el nombre de la persona que va ganando
    void imprimeComoVaLaCarrera(String nomJ1, String nomJ2){
        // ! Mediante una estructura de if-else combroparemos quien va en cabeza
        if (fichaJ1 > fichaJ2){ // * Si J1 va ganando
            System.out.println("'" + nomJ1 + "' va Ganando");
        } else if (fichaJ2 > fichaJ1){ // * Si J2 va ganando
            System.out.println("'" + nomJ2 + "' va Ganando");
        } else { // * Si van empate
            System.out.println("'" + nomJ1 + "' y '" + nomJ2 + "' van Empatados");
        }
    }

    // ? El método esGanador devolverá el nombre del quien haya ganado, si esque alguién gano
    String esGanador(String nomJ1, String nomJ2){
        // ^ Definimos la variable ganador que ira cambiando según el ganador
        String ganador;

        // ! Según quién haya superado el tablero mandaremos un nombre o otro
        if (fichaJ1 >= TAMCIRCUITO){ // * Si J1 a ganado
            ganador = nomJ1;
        } else if (fichaJ2 >= TAMCIRCUITO){ // * Si J2 a ganado
            ganador = nomJ2;
        } else {
            ganador = "";
        }

        // ! Devolvemos el nombre del Ganador
        return ganador;
    }
}