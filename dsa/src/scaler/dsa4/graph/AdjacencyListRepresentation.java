package scaler.dsa4.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListRepresentation {
    class Graph{
        int V;
        ArrayList<Integer>[] adj;

        Graph(int v) {
            this.V = v;
            adj = new ArrayList[V+1];
            for(int i = 1; i <= V; i++) {
                adj[i] = new ArrayList<>();
            }
        }
    }
}
