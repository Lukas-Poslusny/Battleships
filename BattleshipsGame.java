import java.util.Scanner;

public class BattleshipsGame {

    public static boolean[][] pole = new boolean[10][10];

    public static void Battleships() {

        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                pole[row][column] = false;
            }
        }

        // letadlova lod
        pole[0][1] = true;
        pole[0][2] = true;
        pole[0][3] = true;
        pole[0][4] = true;
        pole[0][5] = true;

        // kriznik
        pole[5][2] = true;
        pole[6][2] = true;
        pole[7][2] = true;
        pole[8][2] = true;

        // jachta 1
        pole[3][6] = true;
        pole[4][6] = true;
        pole[5][6] = true;

        // jachta 2
        pole[0][9] = true;
        pole[1][9] = true;
        pole[2][9] = true;

        // lodka 1
        pole[8][9] = true;
        pole[9][9] = true;

        // lodka 1
        pole[8][6] = true;
        pole[8][7] = true;
    }

    public static void DrawBoard() {
        System.out.println("Tabulka s zadanymi lodemi.");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (pole[i][j] == true)
                    System.out.print("X ");
                else if (pole[i][j] == false)
                    System.out.print("- ");
            }
            System.out.println("");
        }
    }

    public static void Shoot() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nZadej x: ");
        int x = sc.nextInt() - 1; 
        System.out.print("Zadej y: ");
        int y = sc.nextInt() - 1; 
        System.out.println("");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == y && j == x) {
                    if (pole[i][j] == true) {
                        System.out.print("# ");
                    }  
                    else if (pole[i][j] == false) {
                        System.out.print("~ ");
                    }
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int unlimited = 0;
        BattleshipsGame.Battleships();
        BattleshipsGame.DrawBoard();
        do {
            BattleshipsGame.Shoot();
        } while (unlimited<1);
    }
}

// X #
// - ~