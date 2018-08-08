package grafico;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SeleccionarPunto extends MouseAdapter{

    int x,y;

    public SeleccionarPunto(){
        this.x=x;
        this.y=y;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Seleccionaste el punto " + x + " " + y);
    }
}
