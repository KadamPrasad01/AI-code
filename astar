import heapq

# Goal State
GOAL_STATE = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 0]
]

# Directions (Up, Down, Left, Right)
MOVES = [(-1, 0), (1, 0), (0, -1), (0, 1)]


# Manhattan Distance Heuristic
def manhattan_distance(state):
    distance = 0
    for i in range(3):
        for j in range(3):
            if state[i][j] != 0:
                value = state[i][j]
                goal_x = (value - 1) // 3
                goal_y = (value - 1) % 3
                distance += abs(i - goal_x) + abs(j - goal_y)
    return distance


# Convert state to tuple (for hashing)
def to_tuple(state):
    return tuple(tuple(row) for row in state)


# Find blank position
def find_blank(state):
    for i in range(3):
        for j in range(3):
            if state[i][j] == 0:
                return i, j


# Generate neighbors
def get_neighbors(state):
    neighbors = []
    x, y = find_blank(state)

    for dx, dy in MOVES:
        nx, ny = x + dx, y + dy

        if 0 <= nx < 3 and 0 <= ny < 3:
            new_state = [row[:] for row in state]
            new_state[x][y], new_state[nx][ny] = new_state[nx][ny], new_state[x][y]
            neighbors.append(new_state)

    return neighbors


# A* Algorithm
def a_star(start_state):
    open_list = []
    heapq.heappush(open_list, (manhattan_distance(start_state), 0, start_state))

    visited = set()
    parent = {}

    while open_list:
        f, g, current = heapq.heappop(open_list)

        if current == GOAL_STATE:
            return reconstruct_path(parent, current)

        visited.add(to_tuple(current))

        for neighbor in get_neighbors(current):
            if to_tuple(neighbor) not in visited:
                parent[to_tuple(neighbor)] = current
                heapq.heappush(
                    open_list,
                    (g + 1 + manhattan_distance(neighbor), g + 1, neighbor)
                )

    return None


# Reconstruct path
def reconstruct_path(parent, current):
    path = [current]

    while to_tuple(current) in parent:
        current = parent[to_tuple(current)]
        path.append(current)

    path.reverse()
    return path


# -------- MAIN PROGRAM --------
print("Enter the initial state (use space, 0 for blank):")

start = []
for i in range(3):
    row = list(map(int, input().split()))
    start.append(row)

solution = a_star(start)

if solution:
    print("\nSolution found in", len(solution) - 1, "moves.\n")
    for step in solution:
        for row in step:
            print(row)
        print("------")
else:
    print("No solution exists.")