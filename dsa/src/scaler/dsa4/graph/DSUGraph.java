package scaler.dsa4.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DSUGraph {
    class Pair{
        int st;
        int en;
        Pair(int a, int b) {
            this.st = a;
            this.en = b;
        }
    }
    int V;
    ArrayList<Pair> adj;
    DSUGraph(int V) {
        this.V = V;
        adj = new ArrayList<>();
    }

    void addEdge(int a, int b) {
        this.adj.add(new Pair(a, b));
    }

    int findSet(int node, int[] parent) {
        if(parent[node] == -1) {
            return node;
        }
        return findSet(parent[node], parent);
    }

    void union(int a, int b, int[] parent) {
        int ra = findSet(a, parent);
        int rb = findSet(b, parent);

        if(ra != rb) {
            parent[ra] = rb;
        }
    }

    boolean contains_cycle() {
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        for(Pair p: adj) {
            int i = p.st;
            int j = p.en;

            int a = findSet(i, parent);
            int b = findSet(j, parent);

            if(a != b) {
                union(a, b, parent);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DSUGraph g = new DSUGraph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
//        g.addEdge(3, 0);

        System.out.println(g.contains_cycle());
    }


}
