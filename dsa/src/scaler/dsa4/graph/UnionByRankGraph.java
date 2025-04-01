package scaler.dsa4.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class UnionByRankGraph {
    class Pair{
        int first;
        int second;

        Pair(int a, int b) {
            first = a;
            second = b;
        }
    }

    int V;
    ArrayList<Pair> adj;

    UnionByRankGraph(int v) {
        this.V = v;
        adj = new ArrayList<>();
    }

    void addEdge(int a, int b) {
        adj.add(new Pair(a, b));
    }

    int findSet(int a, int[] parent) {
        if(parent[a] == -1) {
            return a;
        }
        parent[a] = findSet(parent[a], parent);
        return parent[a];
    }

    void unionSet(int a, int b, int[] parent, int[] rank) {
        int s1 = findSet(a, parent);
        int s2 = findSet(b, parent);

        if(s1 != s2) {
            if(rank[s1] > rank[s2]) {
                parent[s2] = s1;
                rank[s1] += rank[s2];
            } else {
                parent[s1] = s2;
                rank[s2] += rank[s1];
            }
        }
    }

    boolean findCycle() {
        int[] parent = new int[V];
        int[] rank = new int[V];

        Arrays.fill(parent, -1);
        Arrays.fill(rank, 1);

        for(Pair p: adj) {
            int i = p.first;
            int j = p.second;

            int s1 = findSet(i, parent);
            int s2 = findSet(j, parent);

            if(s1 != s2) {
                unionSet(s1, s2, parent, rank);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UnionByRankGraph g = new UnionByRankGraph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(0, 4);
//        g.addEdge(5, 6);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        System.out.println(g.findCycle());
    }


}
