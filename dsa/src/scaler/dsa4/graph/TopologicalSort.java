package scaler.dsa4.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


//kahn's algorithm
public class TopologicalSort {
    int V;
    ArrayList<Integer>[] adj;

    TopologicalSort(int v) {
        this.V = v;
        adj = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int x, int y) {
        adj[x].add(y);
    }

    void topologicalSort() {
        int[] indegree = new int[V];
        Arrays.fill(indegree, 0);

        for(int i = 0; i < V; i++) {
            for(int x: adj[i]) {
                indegree[x]++;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                pq.offer(i);
            }
        }

        while(!pq.isEmpty()) {
            int front = pq.poll();
            System.out.println(front);
            for(int x: adj[front]) {
                indegree[x]--;
                if(indegree[x] == 0) {
                    pq.offer(x);
                }
            }
        }
    }


    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(1, 4);
        g.addEdge(1, 2);

        g.topologicalSort();

    }
}
