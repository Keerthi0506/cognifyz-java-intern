import java.util.Scanner;

public class TicTacToe {
    static char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        while (true) {
            displayBoard();
            System.out.print("Player " + currentPlayer + ", enter position (1-9): ");
            int pos = scanner.nextInt();

            if (pos < 1 || pos > 9 || board[pos - 1] != ' ') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[pos - 1] = currentPlayer;

            if (checkWin(currentPlayer)) {
                displayBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isDraw()) {
                displayBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }
    public static void displayBoard() {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            System.out.print(" " + board[i]);
            if ((i + 1) % 3 == 0) System.out.println();
            else System.out.print(" |");
        }
        System.out.println();
    }
    public static boolean checkWin(char player) {
        int[][] winCombos = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},  // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},  // columns
            {0, 4, 8}, {2, 4, 6}              // diagonals
        };

        for (int[] combo : winCombos) {
            if (board[combo[0]] == player &&
                board[combo[1]] == player &&
                board[combo[2]] == player) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDraw() {
        for (char c : board) {
            if (c == ' ') return false;
        }
        return true;
    }
}
