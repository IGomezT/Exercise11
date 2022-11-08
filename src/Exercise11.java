import java.util.Scanner;
public class Exercise11 {
    public static void main(String[] argv) {
        // When you learn it you will use methods here
        // and not all in a long main method.
        final int NUM_ROWS = 8;
        final int NUM_COLS = 8;
        final int TOTAL_SHIPS = 10;
        char board[][] = new char[NUM_ROWS][NUM_COLS];
        char rowLetter;
        int colNumber;
        int shots = 0, sunkShips = 0;
        boolean gameOver = false;
        Scanner input = new Scanner(System.in);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = ' ';
            }
        }
        // Creation of the ships
        int shipCounter = 0;
        int rowRand, colRand;
        while (shipCounter < TOTAL_SHIPS) {
            rowRand = (int) (Math.random() * NUM_ROWS);
            colRand = (int) (Math.random() * NUM_COLS);
            // You have to avoid placeng a ship
            // where already was one
            if (board[rowRand][colRand] == ' ') {
                board[rowRand][colRand] = 'S';
                shipCounter ++;
            }
        }
        System.out.println("-----------------");
        System.out.println("SHOTS: " + shots);
        System.out.println("SUNK SHIPS: " + sunkShips);
        do {
            System.out.print("Enter row (letter):");
            rowLetter = input.next().toUpperCase().charAt(0);
            System.out.print("Enter column (number):");
            colNumber = input.nextInt() - 1;
            //convert the letter to the number
            int rowNumber = rowLetter - 'A';
            // Make sure the col and row are good
            if (rowNumber < 0 || rowNumber >= NUM_ROWS ||
                    colNumber < 0 || colNumber >= NUM_COLS) {
                continue;
            }
            if (board[rowNumber][colNumber] == ' ') {
                // water
                board[rowNumber][colNumber] = 'O';
            } else {
                if (board[rowNumber][colNumber] == 'S') {
                    // sink ship
                    board[rowNumber][colNumber] = 'X';
                    sunkShips++;
                    if (sunkShips == TOTAL_SHIPS) {
                        gameOver = true;
                    }
                }
            }
            shots++;
            // Print results
            System.out.println("SHOTS: " + shots);
            System.out.println("SUNK SHIPS " + sunkShips + "\n");
            // PRINT BOARD
            System.out.print(" ");
            for (int col = 1; col <= board[0].length; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
            char letterBoard = 'A';
            for (int row = 0; row < board.length; row++) {
                System.out.print(letterBoard + " ");
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == 'S') {
                        // We don't print ships'
                        System.out.print(" ");
                    } else {
                        System.out.print(board[row][col] + " ");
                    }
                }
                System.out.println();
                letterBoard++;
            }
        } while (!gameOver);
        System.out.println("YOU WIN. ALL SHIPS SUNK.");
    }
}