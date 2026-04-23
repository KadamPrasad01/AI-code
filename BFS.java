import java.util.*;

public class BFS{

    static void bfsRecursive(Queue<Integer> q, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        if (q.isEmpty()) {
            return;
        }

        int node = q.poll();
        System.out.print(node + " ");

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                q.add(neighbor);
            }
        }

        bfsRecursive(q, visited, adj);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input vertices and edges
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Input edges
        System.out.println("Enter edges (u v): ");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            // Undirected graph
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Starting node
        System.out.print("Enter starting node for BFS: ");
        int start = sc.nextInt();

        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        System.out.println("BFS Traversal:");

        visited[start] = true;
        q.add(start);

        bfsRecursive(q, visited, adj);

        sc.close();
    }
}