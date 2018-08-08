package grafico;

import javax.swing.*;
import java.awt.*;

import javafx.scene.layout.Background;
import juego.*;

public class MostrarPuntos extends JPanel{

    public MostrarPuntos(){
        //setBackground(Color.DARK_GRAY);
    }

    @Override
    public void paintComponent(Graphics g) {
        int y = 100;
        for (int i = 6; i > 0; i--){
            int x = 100;
            for (int j = 1; j <= 6; j++){
                Dot dot = new Dot(Matriz.getDot((j-1), (i-1)), i, j, x, y);
                dot.dibujarPunto(g);
                x += 40;
            }
            y += 40;
        }
    }
}
