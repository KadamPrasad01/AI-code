import java.util.*;

public class NQueens {

    static int N;

    // Check if it's safe to place queen at (row, col)
    static boolean isSafe(int[][] board, int row, int col) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Backtracking function
    static boolean solve(int[][] board, int row) {

        // Base case: all queens placed
        if (row == N) {
            return true;
        }

        // Try all columns in current row
        for (int col = 0; col < N; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 1; // place queen

                if (solve(board, row + 1)) {
                    return true;
                }

                board[row][col] = 0; // backtrack
            }
        }

        return false;
    }

    // Print solution
    static void printBoard(int[][] board) {
        System.out.println("Solution:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        N = sc.nextInt();

        int[][] board = new int[N][N];

        if (solve(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }

        sc.close();
    }
}