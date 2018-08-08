package juego;
import java.io.IOException;
import java.util.Scanner;

public class Partida {
    private static int puntage; //almacena el puntaje de cada partida
    private static int movimientos; //movimientos restantes en la partida
    private boolean tipoDePartida;
    private static String nombre = "";
    
    public Partida(boolean tipoDePartida){
        puntage = 0;
        movimientos = 30;
        this.tipoDePartida = tipoDePartida;
        jugar();

    }

    public Partida(int puntage, int movimientos){
        Partida.puntage = puntage;
        Partida.movimientos = movimientos;
        jugar();
    }

    private void jugar(){
        String xy;
        Scanner sc = new Scanner(System.in);

        while (movimientos > 0){
            if (tipoDePartida) {
                System.out.println("Ingrese el Nombre:");
                Partida.nombre = sc.nextLine();
                System.out.println();
                PrintMatriz.print(Matriz.getMatriz());
                System.out.println();
                System.out.println("Movimientos restantes: " + movimientos);
                Coordenadas.jugadaActiva = true;
            }
                do {
                    if (tipoDePartida) {
                        System.out.println();
                        System.out.println("Ingrese Coordenada:  \033[37m(\"x,y\" o \"x,y x,y x,y\" Y \"Stop\" para terminar la jugada)\033[0m");
                        xy = sc.nextLine();
                        if (xy.equalsIgnoreCase("save")){
                            try {
                                new GuardarPartida();
                            } catch (IOException e) {
                                System.out.println("No se pudo guardar");
                            }
                        }
                        else{
                            Coordenadas.verificar(xy);
                        }
                    }
                } while (Coordenadas.jugadaActiva);
            movimientos--;
        }
    }
    public static void sumarPuntaje(int puntos){
      puntage += puntos;
    }

    public static int getPuntage() {
        return puntage;
    }

    public static int getMovimientos() {
        return movimientos;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Partida.nombre = nombre;
    }
}
