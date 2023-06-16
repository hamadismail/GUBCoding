# graph = {
#     'A' : ['B','C'],
#     'B' : ['D','E'],
#     'C' : ['F'],
#     'D' : [],
#     'E' : ['F'],
#     'F' : []
# }

# visited = []
# queue = []

# source = 'A'
# goal = 'D'


visited = []
adjacency_matrix = [
    #0  1  2  3  4  5
    [0, 1, 1, 0, 0, 0], # 0
    [0, 0, 0, 1, 1, 0], # 1
    [0, 0, 0, 0, 0, 1], # 2
    [0, 0, 0, 0, 0, 0], # 3
    [0, 0, 0, 0, 0, 1], # 4
    [0, 0, 0, 0, 0, 0]  # 5
]

start_node = 0
destination_node = 5

# def bfs(visited, matrix, source, goal):
#     visited.append(source)
#     queue = [(source, 0, [source])]

#     while queue:
#         node, distance, path = queue.pop(0)
#         print(node, end=" ")

#         if node == goal:
#             path = [str(node) for node in path]  # Convert path elements to strings
#             print("\nTotal Distance:", distance)
#             print("Path:", "->".join(path))
#             return

#         for neighbour in range(len(matrix[node])):
#             if matrix[node][neighbour] == 1 and neighbour not in visited:
#                 visited.append(neighbour)
#                 queue.append((neighbour, distance + 1, path + [neighbour]))


# print("Following is the Breadth-First Search:")
# bfs(visited, adjacency_matrix, start_node, destination_node)







# def bfs(visited, graph, source):
#     visited.append(source)
#     queue.append(source)

#     while queue:
#         s = queue.pop(0)
#         print(s, end=" ")

#         for neighbour in graph[s]:
#             if neighbour not in visited:
#                 visited.append(neighbour)
#                 queue.append(neighbour)




# def bfs(visited, graph, source, goal):
#     visited.append(source)
#     queue = [(source, 0, [source])]  # Queue now contains tuples of (node, distance)

#     while queue:
#         node, distance, path = queue.pop(0)
#         print(node, end=" ")

#         if node == goal:
#             print("\nTotal Distance:", distance)
#             print("Path:", "->".join(path))
#             return

#         for neighbour in graph[node]:
#             if neighbour not in visited:
#                 visited.append(neighbour)
#                 queue.append((neighbour, distance + 1, path + [neighbour]))





# def dfs(visited, graph, node, dis=0):
#     if node not in visited:
#         print(node, dis)
#         visited.append(node)
#     for neighbour in graph[node]:
#         dfs(visited,graph,neighbour, dis+1)



# def dfs(visited, graph, source, goal, dis=0, path=[]):
#     visited.append(source)
#     path.append(source)

#     if source == goal:
#         print("Path:", '->'.join(path), "Distance:", dis)

#     for neighbour in graph[source]:
#         if neighbour not in visited:
#             dfs(visited,graph,neighbour,goal, dis+1, path)
#     path.pop()




def dfs(visited, matrix, source, goal, dis=0, path=[]):
    visited.append(source)
    path.append(source)

    # print(source, end=" ")
    
    if source == goal:
        print("\nPath:", '->'.join(map(str, path)), "Distance:", dis)

    for neighbour in range(len(matrix[source])):
        if matrix[source][neighbour] == 1 and neighbour not in visited:
            dfs(visited, matrix, neighbour, goal, dis + 1, path)

    path.pop()

print("Following is the Depth-First Search:")
dfs(visited, adjacency_matrix, start_node, destination_node)



#dfs(visited, graph, source, goal)
#bfs(visited, graph, source, goal)

