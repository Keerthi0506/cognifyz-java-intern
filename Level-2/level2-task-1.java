import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Tic-Tac-Toe Game (2 Players)");
        boolean playAgain;

        do {
            initializeBoard();
            char currentPlayer = 'X';
            boolean gameWon = false;

            while (true) {
                printBoard();
                System.out.println("Player " + currentPlayer + ", enter your move (row and column: 1 1):");
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;

                    if (checkWin(currentPlayer)) {
                        printBoard();
                        System.out.println("🎉 Player " + currentPlayer + " wins!");
                        gameWon = true;
                        break;
                    } else if (isDraw()) {
                        printBoard();
                        System.out.println("🤝 It's a draw!");
                        break;
                    }

                    // Switch player
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            }

            // Ask if they want to play again
            System.out.print("Play another round? (yes/no): ");
            scanner.nextLine(); // Consume leftover newline
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        System.out.println("Thanks for playing!");
    }

    // Initialize or reset the board
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Display the board
    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // Check if a move is valid
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 &&
               col >= 0 && col < 3 &&
               board[row][col] == ' ';
    }

    // Check if the current player has won
    static boolean checkWin(char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++)
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player))
                return true;

        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    // Check if the game is a draw
    static boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }
}
