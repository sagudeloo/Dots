package grafico;

import javax.swing.*;
import java.awt.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class VentanaJuego extends JFrame {

    public VentanaJuego(){
        setBounds(0, 0, 1000, 700);
        setTitle("DOTS");
        MostrarPuntos mostrarPuntos = new MostrarPuntos();
        add(mostrarPuntos);
        setBackground(Color.BLACK);


    }
}
