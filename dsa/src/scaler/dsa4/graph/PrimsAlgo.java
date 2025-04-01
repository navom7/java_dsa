package scaler.dsa4.graph;


import scaler.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {

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

    PrimsAlgo(int V) {
        this.V = V;
        this.adj = new ArrayList[V];

        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int a, int b, int wt) {
        this.adj[a].add(new Pair(b, wt));
        this.adj[b].add(new Pair(a, wt));
    }

    int primsMst() {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));

        boolean[] visited = new boolean[V];
        pq.add(new Pair(0, 0));
        int ans = 0;

        while(!pq.isEmpty()) {
            Pair p = pq.poll();

            int wt = p.weight;
            int to = p.node;

            if(visited[to]) {
                continue;
            }
            ans += wt;
            visited[to] = true;
            for(Pair nbr: adj[to]) {
                int node = nbr.node;
                int weight = nbr.weight;

                if(visited[node] == false) {
                    pq.add(nbr);
                }
            }

        }

        return ans;


    }

    public static void main(String[] args) {
        PrimsAlgo graph = new PrimsAlgo(4);

        // Add edges to the graph
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 2);
        graph.addEdge(0, 3, 2);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 3);
        graph.addEdge(2, 3, 2);

        int mstWeight = graph.primsMst();
        System.out.println("Total Minimum Spanning Tree Weight: " + mstWeight);
    }
}
