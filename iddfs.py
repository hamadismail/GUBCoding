# def iddfs(graph, start, goal):
#     for depth_limit in range(len(graph)):
#         visited = set()
#         path = []
#         result = dls(graph, start, goal, depth_limit, visited, path)
#         if result is not None:
#             return result
#     return None

# def dls(graph, node, goal, depth_limit, visited, path):
#     visited.add(node)
#     path.append(node)

#     if node == goal:
#         return path

#     if depth_limit <= 0:
#         path.pop()
#         return None

#     for neighbor in graph[node]:
#         if neighbor not in visited:
#             result = dls(graph, neighbor, goal, depth_limit - 1, visited, path)
#             if result is not None:
#                 return result

#     path.pop()
#     return None

# # Example usage:
# graph = {
#     'A': ['B', 'C'],
#     'B': ['D', 'E'],
#     'C': ['F'],
#     'D': [],
#     'E': ['F'],
#     'F': []
# }

# start_node = 'A'
# destination_node = 'F'

# result = iddfs(graph, start_node, destination_node)
# if result is not None:
#     print("Path:", ' -> '.join(result))
#     print("Distance:", len(result) - 1)
# else:
#     print("No path found.")







# def iddfs(matrix, start, goal):
#     for depth_limit in range(len(matrix)):
#         visited = set()
#         path = []
#         result = dls(matrix, start, goal, depth_limit, visited, path)
#         if result is not None:
#             return result
#     return None

# def dls(matrix, node, goal, depth_limit, visited, path):
#     visited.add(node)
#     path.append(node)

#     if node == goal:
#         return path

#     if depth_limit <= 0:
#         path.pop()
#         return None

#     for neighbor in range(len(matrix[node])):
#         if matrix[node][neighbor] == 1 and neighbor not in visited:
#             result = dls(matrix, neighbor, goal, depth_limit - 1, visited, path)
#             if result is not None:
#                 return result

#     path.pop()
#     return None

# # Example usage:
# adjacency_matrix = [
#     #0  1  2  3  4  5
#     [0, 1, 1, 0, 0, 0], # 0
#     [0, 0, 0, 1, 1, 0], # 1
#     [0, 0, 0, 0, 0, 1], # 2
#     [0, 0, 0, 0, 0, 0], # 3
#     [0, 0, 0, 0, 0, 1], # 4
#     [0, 0, 0, 0, 0, 0]  # 5
# ]

# start_node = 0
# destination_node = 5

# result = iddfs(adjacency_matrix, start_node, destination_node)
# if result is not None:
#     print("Path:", ' -> '.join(map(str, result)))
#     print("Distance:", len(result) - 1)
# else:
#     print("No path found.")

# Adjacent Matrix
# G = [[0, 1, 1, 0, 1, 0],
#      [1, 0, 1, 1, 0, 1],
#      [1, 1, 0, 1, 1, 0],
#      [0, 1, 1, 0, 0, 1],
#      [1, 0, 1, 0, 0, 1],
#      [0, 1, 0, 1, 1, 0]]

# # Initiate the name of the nodes.
# node = "abcdef"
# t_ = {}
# for i in range(len(G)):
#     t_[node[i]] = i

# # Count the degree of all nodes.
# degree = []
# for i in range(len(G)):
#     degree.append(sum(G[i]))

# # Initiate the possible colors.
# colorDict = {}
# for i in range(len(G)):
#     colorDict[node[i]] = ["Blue", "Red", "Yellow", "Green"]

# # Sort the nodes based on the degree.
# sortedNode = []
# indices = []

# # Use selection sort.
# for _ in range(len(degree)):
#     max_degree = 0
#     max_idx = 0
#     for j in range(len(degree)):
#         if j not in indices:
#             if degree[j] > max_degree:
#                 max_degree = degree[j]
#                 max_idx = j
#     indices.append(max_idx)
#     sortedNode.append(node[max_idx])

# # The main process.
# theSolution = {}
# usedColors = set()  # Keep track of the colors used.

# for n in sortedNode:
#     setTheColor = colorDict[n]
#     theSolution[n] = setTheColor[0]
#     usedColors.add(setTheColor[0])
#     adjacentNode = G[t_[n]]
#     for j in range(len(adjacentNode)):
#         if adjacentNode[j] == 1 and (setTheColor[0] in colorDict[node[j]]):
#             colorDict[node[j]].remove(setTheColor[0])

# # Print the solution.
# for t, w in sorted(theSolution.items()):
#     print("Node", t, " = ", w)

# print("Total number of colors used:", len(usedColors))


import copy
import random

def take_input():
    #Accepts the size of the chess board
    while True:
        try:
            n = int(input('Input size of chessboard? n = '))
            if n <= 3:
                print("Enter a value greater than or equal to 4")
                continue
            return n
        except ValueError:
            print("Invalid value entered. Enter again")

def get_board(n):
    #Returns an n by n board
    board = ["x"]*n
    for i in range(n):
        board[i] = ["x"]*n
    return board

def print_solution(solutions, n):
    #Prints one of the solutions randomly
    x = random.randint(0,len(solutions)-1) #0 and len(solutions)-1 are inclusive
    for row in solutions[x]:
        print(" ".join(row))

def solve(board, col, n):
    #Use backtracking to find all solutions
    if col >= n:
        return
    
    for i in range(n):
        if is_safe(board, i, col, n):
            board[i][col] = "Q"
            if col == n-1:
                add_solution(board)
                board[i][col] = "x"
                return
            solve(board, col+1, n) #recursive call
            #backtrack
            board[i][col] = "x"
            
def is_safe(board, row, col, n):
    #Check if it's safe to place a queen at board[x][y]
    #check row on left side
    for j in range(col):
        if board[row][j] == "Q":
            return False
    
    i, j = row, col
    while i >= 0 and j >= 0:
        if board[i][j] == "Q":
            return False
        i=i-1
        j=j-1
    
    x, y = row,col
    while x < n and y >= 0:
        if board[x][y] == "Q":
            return False
        x=x+1
        y=y-1
    
    return True

def add_solution(board):
    #Saves the board state to the global variable: solutions
    global solutions
    saved_board = copy.deepcopy(board)
    solutions.append(saved_board)

#Taking size of the chessboard from user
n = take_input()

#Returns a square board of nxn dimension
board = get_board(n)

#Empty list of all possible solutions
solutions = []

#Solving using backtracking
solve(board, 0, n)

print()

print("One of the solutions is: \n")
print_solution(solutions, n)

print()
print("Total number of solutions=", len(solutions))