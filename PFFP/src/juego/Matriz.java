package juego;

public class Matriz {

    private static int [][] dots;
    private static int filas = 6;
    private static int columnas = 6;

    /**Este metodo genera la matriz para la partida de dots
     */
    public Matriz(){
        dots = new int[columnas][filas];
        for (int i = 0; i < columnas; i++){
            for (int j =  0; j < filas; j++){
                dots[i][j] = ((int)(Math.random() * 5 )+ 1);
            }
        }
    }

    /**Este constructor carga una matriz ya generada
     * */
    public Matriz(int [][] dots){
        Matriz.dots = new int[dots.length][dots[0].length];
        for (int i = 0; i < dots.length; i++) {
            System.arraycopy(dots[i],0, Matriz.dots[i], 0, dots[i].length);
        }
        Matriz.columnas = dots.length;
        Matriz.filas = dots[0].length;
    }

    /**este metodo se encarga de bajar los dots a los puntos vacios
     * y de llenarlos al final
     * */
    private static void rehacerMatriz(){
        for(int i = 0; i < dots.length; i++){
            for (int j = 0; j < dots[i].length; j++){
                if(dots[i][j] == 0){
                    int k =  j;
                    while (dots[i][j] == 0 && k < dots[i].length){
                        if(dots[i][k] > 0 ){
                            int temp = dots[i][j];
                            dots[i][j] = dots[i][k];
                            dots[i][k] = temp;
                        }
                        k++;
                    }
                }
            }
        }
        llenarEspacios();
    }

    /**este metodo se encarga de llenar los espacios vacios
     * */
     private static void llenarEspacios(){
        for(int i = 0; i < dots.length; i++) {
            for (int j = 0; j < dots[i].length; j++) {
                if (dots[i][j] == 0) {
                    dots[i][j] = ((int)(Math.random() * 5 )+ 1);
                }
            }
        }
    }

    static void eliminarJugada(int[] x, int[] y){
        for (int i = 0; i < x.length; i++) {
            dots[x[i]][y[i]] = 0;
        }
        rehacerMatriz();
    }

    static void eliminarFullColor(int dot){
        for (int i = 0; i < dots.length; i++) {
            for (int j = 0; j < dots[i].length; j++) {
                if (dots[i][j] == dot) {
                    dots[i][j] = 0;
                }
            }
        }
        rehacerMatriz();
    }

    /**Retorna la matriz de dots
     * */
    static int [][] getMatriz(){
         return dots;
    }

    public static int getDot(int x, int y){
        return dots[x][y];
    }

    public static int getFilas() {
        return filas;
    }

    public static int getColumnas() {
        return columnas;
    }

    public static void setFilas(int filas) {
        Matriz.filas = filas;
    }

    public static void setColumnas(int columnas) {
        Matriz.columnas = columnas;
    }

}