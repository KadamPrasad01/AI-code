import java.util.*;

class Edge implements Comparable<Edge> {
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public int compareTo(Edge e) {
        return this.w - e.w;
    }
}

public class Kruskal {
    static int[] parent;

    static int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    static void union(int u, int v) {
        parent[find(u)] = find(v);
    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        Collections.sort(edges);

        parent = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        System.out.println("Edges in MST:");

        for (Edge e : edges) {
            if (find(e.u) != find(e.v)) {
                System.out.println(e.u + " - " + e.v + " : " + e.w);
                union(e.u, e.v);
            }
        }
    }
}