package juego;


import java.io.*;

public class GuardarPartida {

    private String ruta = "C:\\Dots\\" + Partida.getNombre() + ".txt";
    private BufferedWriter partida = null;
    private String separador = "\\";

    public GuardarPartida() throws IOException {
        try {
            partida = new BufferedWriter(new FileWriter(ruta));
            guardarDatosPartida();
            guardarMatriz();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            partida.close();
        }
    }

    private void guardarMatriz(){
        try {
            partida.write(separador);
            for (int i = 0; i < Matriz.getFilas(); i++) {
                for (int j = 0; j < Matriz.getColumnas(); j++) {
                    partida.write(" " + Matriz.getDot(i, j));
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void guardarDatosPartida(){
        try {
            partida.write(separador + Partida.getNombre());
            partida.write(separador + Partida.getPuntage());
            partida.write(separador + Partida.getMovimientos());
        }
        catch (Exception e){

        }
    }

}
