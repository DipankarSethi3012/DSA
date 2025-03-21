/*There is an undirected weighted graph with n vertices labeled from 0 to n - 1.

You are given the integer n and an array edges, where edges[i] = [ui, vi, wi] indicates that there is an edge between vertices ui and vi with a weight of wi.

A walk on a graph is a sequence of vertices and edges. The walk starts and ends with a vertex, and each edge connects the vertex that comes before it and the vertex that comes after it. It's important to note that a walk may visit the same edge or vertex more than once.

The cost of a walk starting at node u and ending at node v is defined as the bitwise AND of the weights of the edges traversed during the walk. In other words, if the sequence of edge weights encountered during the walk is w0, w1, w2, ..., wk, then the cost is calculated as w0 & w1 & w2 & ... & wk, where & denotes the bitwise AND operator.

You are also given a 2D array query, where query[i] = [si, ti]. For each query, you need to find the minimum cost of the walk starting at vertex si and ending at vertex ti. If there exists no such walk, the answer is -1.

Return the array answer, where answer[i] denotes the minimum cost of a walk for query i. */

  class Solution {
    int[] parent;
    int[] rank;
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int[] cs = new int[n];

        Arrays.fill(cs, Integer.MAX_VALUE);
        
          for(int[] edge : edges) {
            unionByRank(edge[0], edge[1]);
        }

        // System.out.println(Arrays.toString(parent));
        // System.out.println(Arrays.toString(rank));

        for(int[] edge : edges) {
            int root = findUParent(edge[0]);
            cs[root] &= edge[2];
        }

        int[] res = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            int start = query[i][0];
            int end = query[i][1];

            if(findUParent(start) != findUParent(end)) {
                res[i] = -1;
            } else{
                int root = findUParent(start);
                res[i] = cs[root];
            }
        }
        return res;

    }

    private int findUParent(int node) {
        if(node == parent[node]) return node;

        return parent[node] = findUParent(parent[node]);
    }

    private void unionByRank(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if(ulp_u == ulp_v) return;

        if(rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        } else if(rank[ulp_u] > rank[ulp_v]) {
            parent[ulp_v] = ulp_u;
        } else{
            parent[ulp_u] = ulp_v;
            rank[ulp_v]++;
        }
    }
}