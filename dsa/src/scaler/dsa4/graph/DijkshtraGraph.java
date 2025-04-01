package scaler.dsa4.graph;

import java.util.*;

public class DijkshtraGraph {
    class Pair{
        int node;
        int weight;
        Pair(int a, int b) {
            this.node = a;
            this.weight = b;
        }
    }

    int V;
    ArrayList<Pair>[] adj;

    DijkshtraGraph(int v) {
        this.V = v;
        adj = new ArrayList[V];
    }

    void addEdge(int a, int b, int wt) {
        adj[a].add(new Pair(b, wt));
        adj[b].add((new Pair(a, wt)));
    }

    int[] dijkstra(int source) {
        int[] dist = new int[V];
        dist[source] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.offer(new Pair(source, 0));

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            int wt = p.weight;


        }



        return null;
    }



    public static void main(String[] args) {
        DijkshtraGraph graph = new DijkshtraGraph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 1);

        int src = 0, nodes = 5;
        int[] shortestPaths = graph.dijkstra(src);

        System.out.println("Shortest distances from node " + src + ": " + Arrays.toString(shortestPaths));
    }
}
