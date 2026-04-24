MAX = 20

# Initialize variables
N = int(input("Enter number of queens (N): "))

board = [[0]*N for _ in range(N)]

column = [False]*N
leftDiagonal = [False]*(2*N)
rightDiagonal = [False]*(2*N)

# Print solution
def print_solution():
    print("\nSolution:")
    for i in range(N):
        for j in range(N):
            print(board[i][j], end=" ")
        print()

# Solve using Backtracking + Branch & Bound
def solve_n_queens(row):
    if row >= N:
        print_solution()
        return True

    for col in range(N):

        if (not column[col] and
            not leftDiagonal[row - col + N - 1] and
            not rightDiagonal[row + col]):

            # Place queen
            board[row][col] = 1
            column[col] = True
            leftDiagonal[row - col + N - 1] = True
            rightDiagonal[row + col] = True

            # Recur
            if solve_n_queens(row + 1):
                return True

            # Backtrack
            board[row][col] = 0
            column[col] = False
            leftDiagonal[row - col + N - 1] = False
            rightDiagonal[row + col] = False

    return False

# Run
if not solve_n_queens(0):
    print("No solution exists.")