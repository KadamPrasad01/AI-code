import java.util.*;

public class Prims {
    public static void main(String[] args) {
        int V = 5;
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        boolean[] visited = new boolean[V];
        visited[0] = true;

        int edges = 0;

        System.out.println("Edges in MST:");

        while (edges < V - 1) {
            int min = Integer.MAX_VALUE;
            int x = 0, y = 0;

            for (int i = 0; i < V; i++) {
                if (visited[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!visited[j] && graph[i][j] != 0 && graph[i][j] < min) {
                            min = graph[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + " : " + graph[x][y]);
            visited[y] = true;
            edges++;
        }
    }
}