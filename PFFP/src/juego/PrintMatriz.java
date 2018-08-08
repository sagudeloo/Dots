package juego;

public final class PrintMatriz {

    private PrintMatriz(){

    }

    private static final String blue = "\033[0;106m";
    private static final String red = "\033[0;41m";
    private static final String green = "\033[0;102m";
    private static final String yellow = "\033[0;103m";
    private static final String purple = "\033[0;45m";
    private static final String grey = "\033[0;100m";
    private static final String reset = "\033[0;0m";

    /**Este mmetodo se encarga de imprimir la matriz
     * */
    static void print(int[][] dots){
        for (int i = dots[0].length; i > 0; i--) {
            System.out.println();
            System.out.print("[" + i  + "]  ");
            for (int j = 0; j < dots.length; j++) {
                switch (dots[j][i-1]){
                    case 1:
                        System.out.print(blue + " " + " " +  " " + reset + "  " );
                        break;
                    case 2:
                        System.out.print(red + " " + " " + " " + reset + "  " );
                        break;
                    case 3:
                        System.out.print(green + " " + " " + " " + reset + "  " );
                        break;
                    case 4:
                        System.out.print(yellow + " " + " " + " " + reset + "  " );
                        break;
                    case 5:
                        System.out.print(purple + " " + " " + " " + reset + "  " );
                        break;
                    case 6:
                        System.out.print(grey + " " + " " + " " + reset + "  " );
                        break;
                }
            }
            System.out.println();
        }
        System.out.print("     ");
        for (int i = 1; i <= dots.length; i++) {
            System.out.print("[" + i + "]  ");
        }
    }
}