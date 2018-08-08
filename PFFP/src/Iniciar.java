import grafico.*;
import juego.*;
import java.util.Scanner;

public class Iniciar {

    private static boolean tipoDePartida = true;
    private static int filas = 6, columnas = 6;

    public static void main(String [] args){
        if(tipoDePartida){
            new Matriz();
            new Partida(tipoDePartida);

            /*Scanner sc = new Scanner(System.in);
            boolean inicio = false;
            while (inicio != true) {
                System.out.println("Desera cargar partida o inciar una nueva \033[37m ( 1 \"Cargar\" o 2 \"Nueva\") \033[0m");
                int iniciar = sc.nextInt();
                if (iniciar == 2) {
                    Partida partida = new Partida();
                    inicio = true;
                } else if (iniciar == 1) {
                    inicio = true;
                } else {
                    System.out.println("\033[1;91m Comando invalido");
                }
            }*/
        }
        else {
            new Matriz();
            new Partida(tipoDePartida);
            new PartidaGrafica(filas, columnas);
        }


    }
}
