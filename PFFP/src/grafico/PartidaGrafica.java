package grafico;

import juego.Matriz;
import juego.Partida;

import javax.swing.*;

public class PartidaGrafica {

    public PartidaGrafica(int filas, int columnas){
        VentanaJuego ventanaJuego = new  VentanaJuego();
        ventanaJuego.setVisible(true);
        ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
