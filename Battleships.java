import java.util.Scanner;

public class Battleships {

    public static boolean[][] boardPl1 = new boolean[10][10];
    public static boolean[][] boardPl2 = new boolean[10][10];
    public static boolean[][] ghostBoardPl1 = new boolean[10][10];
    public static boolean[][] ghostBoardPl2 = new boolean[10][10];

    private static void createBattleships() {
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                boardPl1[row][column] = false;
                boardPl2[row][column] = false;
            }
        }

        // letadlova lod
        boardPl1[0][1] = true;
        boardPl1[0][2] = true;
        boardPl1[0][3] = true;
        boardPl1[0][4] = true;
        boardPl1[0][5] = true;

        // kriznik
        boardPl1[5][2] = true;
        boardPl1[6][2] = true;
        boardPl1[7][2] = true;
        boardPl1[8][2] = true;

        // jachta 1
        boardPl1[3][6] = true;
        boardPl1[4][6] = true;
        boardPl1[5][6] = true;

        // jachta 2
        boardPl1[0][9] = true;
        boardPl1[1][9] = true;
        boardPl1[2][9] = true;

        // lodka 1
        boardPl1[8][9] = true;
        boardPl1[9][9] = true;

        // lodka 1
        boardPl1[8][6] = true;
        boardPl1[8][7] = true;

        // ----------- 2. hrac ---------------

        // letadlova lod
        boardPl2[0][1] = true;
        boardPl2[0][2] = true;
        boardPl2[0][3] = true;
        boardPl2[0][4] = true;
        boardPl2[0][5] = true;

        // kriznik
        boardPl2[5][2] = true;
        boardPl2[6][2] = true;
        boardPl2[7][2] = true;
        boardPl2[8][2] = true;

        // jachta 1
        boardPl2[3][6] = true;
        boardPl2[4][6] = true;
        boardPl2[5][6] = true;

        // jachta 2
        boardPl2[0][9] = true;
        boardPl2[1][9] = true;
        boardPl2[2][9] = true;

        // lodka 1
        boardPl2[8][9] = true;
        boardPl2[9][9] = true;

        // lodka 1
        boardPl2[8][6] = true;
        boardPl2[8][7] = true;
    }

    public static void getGhostBoard() {
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                ghostBoardPl1[column][row] = false;
                ghostBoardPl2[column][row] = false;
            }
        }
    }

    public static void drawPl1() {
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                if (boardPl1[column][row] == true && ghostBoardPl1[column][row] == true)                     
                    System.out.print("# ");  
                else if (boardPl1[column][row] == false && ghostBoardPl1[column][row] == true)
                    System.out.print("~ ");
                else
                    System.out.print("- ");
            } System.out.println("");
        } System.out.println("\n-------------------");
    }

    private static void drawPl2() {
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                if (boardPl2[column][row] == true && ghostBoardPl2[column][row] == true)                     
                    System.out.print("# ");  
                else if (boardPl2[column][row] == false && ghostBoardPl2[column][row] == true)
                    System.out.print("~ ");
                else
                    System.out.print("- ");
            } System.out.println("");
        } System.out.println("\n-------------------");
    }

    public static void shootPl1() {
        int cordX, cordY;
        Scanner sc = new Scanner(System.in);

        Battleships.getGhostBoard();
        Battleships.drawPl1();
        do {
            System.out.print("\nZadej x: ");
            cordX = sc.nextInt() - 1; 
            System.out.print("Zadej y: ");
            cordY = sc.nextInt() - 1; 
            System.out.println("");

            if (boardPl1[cordY][cordX] == true)
                System.out.println("Hrac opakuje kolo.");
            ghostBoardPl1[cordY][cordX] = true;

            Battleships.drawPl1();
        } while (boardPl1[cordY][cordX] == true);
    }

    public static void shootPl2() {
        int cordX, cordY;
        Scanner sc = new Scanner(System.in);

        Battleships.getGhostBoard();
        Battleships.drawPl2();
        do {
            System.out.print("\nZadej x: ");
            cordX = sc.nextInt() - 1; 
            System.out.print("Zadej y: ");
            cordY = sc.nextInt() - 1; 
            System.out.println("");

            if (boardPl2[cordY][cordX] == true)
                System.out.println("Hrac opakuje kolo.");
            ghostBoardPl2[cordY][cordX] = true;

            Battleships.drawPl2();
        } while (boardPl2[cordY][cordX] == true);
    }

    public static int closeGame(int end) {
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                if ((boardPl1[column][row] == true && ghostBoardPl1[column][row] == true) || 
                (boardPl2[column][row] == true && ghostBoardPl2[column][row] == true))
                    end = 0;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        Battleships.createBattleships();
        do {
            System.out.println("----------------\n---- Hrac 1 ----\n----------------");
            Battleships.shootPl1();
            System.out.println("----------------\n---- Hrac 2 ----\n----------------");
            Battleships.shootPl2();
        } while (Battleships.closeGame(0) == 0);
    }

}