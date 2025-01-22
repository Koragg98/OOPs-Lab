package oopslab;
import java.util.Scanner;

public class TicTacToeMain {

    private static char grid[][] = new char[5][5];

    public TicTacToeMain() {
        grid[0][0] = '1'; grid[0][1] = '|'; grid[0][2] = '2'; grid[0][3] = '|'; grid[0][4] = '3';
        grid[1][0] = '-'; grid[1][1] = '-'; grid[1][2] = '-'; grid[1][3] = '-'; grid[1][4] = '-';
        grid[2][0] = '4'; grid[2][1] = '|'; grid[2][2] = '5'; grid[2][3] = '|'; grid[2][4] = '6';
        grid[3][0] = '-'; grid[3][1] = '-'; grid[3][2] = '-'; grid[3][3] = '-'; grid[3][4] = '-';
        grid[4][0] = '7'; grid[4][1] = '|'; grid[4][2] = '8'; grid[4][3] = '|'; grid[4][4] = '9';
    }

    public static void drawGrid() {
        for (char[] x : grid) {
            for (char y : x) {
                System.out.print(y);
            }
            System.out.println();
        }
    }

    public boolean move(int move, int user) {
        char symbol = (user == 0) ? 'X' : 'O';

        switch (move) {
            case 1 -> { if (grid[0][0] == 'X' || grid[0][0] == 'O') { invalidMove(); return false; } grid[0][0] = symbol; }
            case 2 -> { if (grid[0][2] == 'X' || grid[0][2] == 'O') { invalidMove(); return false; } grid[0][2] = symbol; }
            case 3 -> { if (grid[0][4] == 'X' || grid[0][4] == 'O') { invalidMove(); return false; } grid[0][4] = symbol; }
            case 4 -> { if (grid[2][0] == 'X' || grid[2][0] == 'O') { invalidMove(); return false; } grid[2][0] = symbol; }
            case 5 -> { if (grid[2][2] == 'X' || grid[2][2] == 'O') { invalidMove(); return false; } grid[2][2] = symbol; }
            case 6 -> { if (grid[2][4] == 'X' || grid[2][4] == 'O') { invalidMove(); return false; } grid[2][4] = symbol; }
            case 7 -> { if (grid[4][0] == 'X' || grid[4][0] == 'O') { invalidMove(); return false; } grid[4][0] = symbol; }
            case 8 -> { if (grid[4][2] == 'X' || grid[4][2] == 'O') { invalidMove(); return false; } grid[4][2] = symbol; }
            case 9 -> { if (grid[4][4] == 'X' || grid[4][4] == 'O') { invalidMove(); return false; } grid[4][4] = symbol; }
            default -> System.out.println("Invalid Move");
        }
        drawGrid();
        return true;
    }

    private void invalidMove() {
        System.out.println("Invalid Move!!!");
    }

    public boolean checkWin() {
        // Check rows, columns, and diagonals
        if (checkLine(0, 0, 0, 2, 0, 4) || checkLine(2, 0, 2, 2, 2, 4) || checkLine(4, 0, 4, 2, 4, 4) || // Rows
            checkLine(0, 0, 2, 0, 4, 0) || checkLine(0, 2, 2, 2, 4, 2) || checkLine(0, 4, 2, 4, 4, 4) || // Columns
            checkLine(0, 0, 2, 2, 4, 4) || checkLine(0, 4, 2, 2, 4, 0)) { // Diagonals
            return true;
        }
        return false;
    }

    private boolean checkLine(int r1, int c1, int r2, int c2, int r3, int c3) {
        return (grid[r1][c1] == grid[r2][c2]) && (grid[r1][c1] == grid[r3][c3]);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String option = "y";
        
        do {
            TicTacToeMain t = new TicTacToeMain();
            
            System.out.println("+------------------+");
            System.out.println("| Tic-Tac-Toe Game |");
            System.out.println("+------------------+");
            System.out.println("Play with computer[y/n]: ");
            String computerMode=sc.next();
            computerMode=computerMode.toLowerCase();
            
            t.drawGrid();
            int count = 1;
            int currentUser = 0;
            
            while (count <= 9 && computerMode.equals("n")) {
                System.out.print("Player " + (currentUser + 1) + " Move: ");
                int move = sc.nextInt();
                if (!t.move(move, currentUser)) continue;

                if (t.checkWin()) {
                    System.out.println("Player " + (currentUser + 1) + " wins!");
                    break;
                }

                currentUser = 1 - currentUser; // Alternate user between 0 and 1
                count++;
            }
            
            while (count <= 9 && computerMode.equals("y")) {
                if(currentUser==0)
                {
                    System.out.print("Player 1 Move: ");
                    int move = sc.nextInt();
                    if (!t.move(move, currentUser)) continue;
                }
                else
                {
                    int move=((int)(Math.random()*100)%9)+1;
                    System.out.println("Computer's Move: "+move);
                    if (!t.move(move, currentUser)) continue;
                }

                if (t.checkWin() && computerMode.equals("n")) {
                    System.out.println("Player " + (currentUser + 1) + " wins!");
                    break;
                }
                if (t.checkWin() && computerMode.equals("y"))
                {
                    System.out.println((currentUser == 0) ? "Player " + (currentUser + 1) + " wins!" : "Computer wins!");
                    break;
                }

                currentUser = 1 - currentUser; // Alternate user between 0 and 1
                count++;
            }

            if (count > 9) {
                System.out.println("It's a tie!");
            }

            System.out.println("Play Again [y/n]: ");
            option = sc.next().toLowerCase();

        } while (option.equals("y"));
    }
}
