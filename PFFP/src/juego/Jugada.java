package juego;

class Jugada {
    private int x;
    private int y;
    private static int dot;

    Jugada(int x, int y, int dot) {
        this.x = x;
        this.y = y;
        this.dot = dot;
    }

    Jugada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    static int getDot() {
        return dot;
    }


}
