package grafico;


import java.awt.*;
import java.awt.geom.Ellipse2D;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class Dot extends Ellipse2D.Double{
    private Color c;
    private int x;
    private int y;
    private int patallaX;
    private int patallaY;

    public Dot(int color, int x, int y, int patallaX, int patallaY){
        setColor(color);
        this.x = x;
        this.y = y;
        this.patallaX = patallaX;
        this.patallaY = patallaY;

        SeleccionarPunto seleccionarPunto = new SeleccionarPunto();
        addMouseListener(seleccionarPunto);
    }

    private void setColor(int color) {
        switch (color){
            case 1:
                c = Color.CYAN;
                break;
            case 2:
                c =  Color.RED;
                break;
            case 3:
                c =  Color.GREEN;
                break;
            case 4:
                c =  Color.YELLOW;
                break;
            case 5:
                c =  Color.MAGENTA;
                break;
        }
    }

    public void dibujarPunto(Graphics g){
        Graphics2D g2 =(Graphics2D) g;
        Ellipse2D elipse = new Ellipse2D.Double(patallaX, patallaY, 30, 30);
        g2.setPaint(c);
        g2.fill(elipse);
    }

    public void seleccionarDot(Graphics g){
        g.setColor(Color.BLACK);
        setFrame(patallaX, patallaY, 30, 30);
    }
}
