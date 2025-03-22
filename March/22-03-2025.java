class Solution {
    int[] parent;
    int[] rank;
    public int countCompleteComponents(int n, int[][] edges) {
        
       
        int[] indegree = new int[n];
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            indegree[u]++;
            indegree[v]++;
        }
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }


        for(int[] edge : edges) {
            unionByRank(edge[0], edge[1]);
            unionByRank(edge[1], edge[0]);
        }

        // System.out.println(Arrays.toString(parent));
        // System.out.println(Arrays.toString(indegree));

        int count = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            mp.put(parent[i], mp.getOrDefault(parent[i], 0) + 1);
        }

        Map<Integer, List<Integer>> mp1 = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int l = findUParent(i);
            mp1.putIfAbsent(l, new ArrayList<>());
            mp1.get(l).add(i);
        }

        for(Map.Entry<Integer, List<Integer>> e : mp1.entrySet()) {
            int key = e.getKey();
            List<Integer> value = e.getValue();
            boolean check = true;
            for(int i : value) {
                if(indegree[i] + 1 != value.size()) {
                    check = false;
                    break;
                }
            }
            if(check) count++;
        }

        return count;
    }

    private int findUParent(int node) {
        if(node == parent[node]) return node;

        return parent[node] = findUParent(parent[node]); //path-compression
    }

    private void unionByRank(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if(ulp_u == ulp_v) return;

        if(rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        }
        else if(rank[ulp_u] > rank[ulp_v]) {
            parent[ulp_v] = ulp_u;
        } else{
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
}