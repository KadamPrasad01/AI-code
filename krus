# Edge list input
edges = []

V = int(input("Enter number of vertices: "))
E = int(input("Enter number of edges: "))

print("Enter edges (u v weight):")
for _ in range(E):
    u, v, w = map(int, input().split())
    edges.append((u, v, w))

# Sort edges by weight
edges.sort(key=lambda x: x[2])

# Disjoint Set (Union-Find)
parent = [i for i in range(V)]

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])   # Path compression
    return parent[x]

def union(x, y):
    px = find(x)
    py = find(y)
    parent[px] = py

# Kruskal's Algorithm
mst = []

for u, v, w in edges:
    if find(u) != find(v):
        mst.append((u, v, w))
        union(u, v)

# Output
print("\nEdges in Minimum Spanning Tree:")
for u, v, w in mst:
    print(f"{u} - {v} : {w}")