package juego;

import java.util.ArrayList;

public class Coordenadas {

    public static ArrayList<Jugada> jugadaXY = new ArrayList<>();
    private static int dot;
    public static boolean jugadaActiva;


    public static void verificar(String jugada){
        if (jugada.equalsIgnoreCase("stop") && jugadaActiva){
            finalizarJugada();
        }
        else {
            if (jugada.length() > 3){
                separarCoordenadas(jugada);
            } else {
                sepetararXY(jugada);
            }
        }
    }

    private static void sepetararXY(String coordenada){
        coordenada = coordenada.replaceAll(" ", "");
        try {
            String [] separador = coordenada.split(",", 2);
            int x = Integer.parseInt(separador[0])-1;
            int y = Integer.parseInt(separador[1])-1;

            verificarCoordenadas(x, y);
        }
        catch (Exception e){
            //System.out.println("\033[1;91m Las cordenadas ingresadas son invalidas\033[0m");
            System.out.println(e.getMessage());
        }
    }

    private static void separarCoordenadas(String jugada){
        try {
            String [] coordenada = jugada.split(" ");
           for (String i: coordenada) {
                sepetararXY(i);
            }
        }
        catch (Exception e) {
            System.out.println("\033[1;91m Las cordenadas ingresadas son invalidas\033[0m");
        }
    }

    private static void verificarCoordenadas(int x, int y){
        if (x >= 0 && y >= 0 && y < Matriz.getFilas() && x < Matriz.getColumnas()) {
            if (jugadaXY == null || jugadaXY.size() == 0){
                dot = Matriz.getDot(x, y);
                jugadaXY.add(new Jugada(x, y, dot));
            }
            else{
                int dx;
                int dy;
                Jugada lastCoordenada;
                int lastX;
                int lastY;
                int lastDot;
                lastCoordenada = jugadaXY.get(jugadaXY.size()-1);
                lastX = lastCoordenada.getX();
                lastY = lastCoordenada.getY();
                lastDot = Jugada.getDot();
                dx = Math.abs(x - lastX);
                dy = Math.abs(y - lastY);
                if (x == lastX && y == lastY){
                    jugadaXY.remove(jugadaXY.size()-1);
                    System.out.println("\033[1;33mJugada removida\033[0;0m");
                }
                else if(lastDot == dot){
                    if (jugadaCerrada(x , y)) {
                        fullColor(dot);
                        jugadaActiva = false;
                    } else if (((x == lastX && dy == 1) || (y == lastY && dx == 1))) {
                        jugadaXY.add(new Jugada(x, y));
                    } else {
                        System.out.println("\033[1;91m Jugada invalida\033[0m");
                    }
                }
                else {
                    System.out.println("\033[1;91m Jugada invalida\033[0m");
                }
            }
        }
        else {
            System.out.println("\033[1;91m Jugada invalida\033[0m");
        }
    }

    private static boolean jugadaCerrada(int x, int y) {
        Jugada coordenadaRef;
        int xRef;
        int yRef;
        if (jugadaXY.size() > 1) {
            if (x != (jugadaXY.get(jugadaXY.size() - 2)).getX() && y != (jugadaXY.get(jugadaXY.size() - 2)).getY()) {
                for (Jugada j: jugadaXY) {
                    coordenadaRef = j;
                    xRef = coordenadaRef.getX();
                    yRef = coordenadaRef.getY();
                    if ((x == xRef) && (y == yRef)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void finalizarJugada(){
        if (jugadaXY.size() > 1) {
            int[] x = new int[jugadaXY.size()];
            int[] y = new int[jugadaXY.size()];
            Jugada coordenadaRef;
            for (int i = 0; i < x.length; i++) {
                coordenadaRef = jugadaXY.get(i);
                x[i] = coordenadaRef.getX();
            }
            for (int i = 0; i < y.length; i++) {
                coordenadaRef = jugadaXY.get(i);
                y[i] = coordenadaRef.getY();
            }
            Matriz.eliminarJugada(x, y);
            jugadaXY.clear();
            jugadaActiva = false;
        }
        else {
            System.out.println("\033[1;91m La jugada debe tene dos o mas puntos \033[0m");
        }
    }

    private static void fullColor(int dot){
        Matriz.eliminarFullColor(dot);
        jugadaXY.clear();
    }
}
