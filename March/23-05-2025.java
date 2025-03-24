class Solution {
    private final int MOD = (int)1e9 + 7;
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }


        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        long[] distance = dij(adj, n);
        // System.out.println(Arrays.toString(distance));
        boolean[] visited = new boolean[n];
        long target = distance[n - 1];
        int[] dp = new int[n];
        
            Arrays.fill(dp, -1);
        
        return f(0, distance, adj, 0, n, dp);
    }

    private long[] dij(List<List<int[]>> adj, int n) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});
        while(!pq.isEmpty()) {
            long[] curr = pq.poll();
            int currNode = (int)curr[0];
            long currDist = curr[1];

            for(int[] nbr : adj.get(currNode)) {
                int nbrNode = nbr[0];
                int nbrDist = nbr[1];

                if(currDist + nbrDist < dist[nbrNode]) {
                    dist[nbrNode] = currDist + nbrDist;
                    pq.offer(new long[]{nbrNode, dist[nbrNode]});
                }
            }
        }
        
        return dist;
    }

   private int f(int node, long[] dist, List<List<int[]>> adj, long target, int n, int[] dp) {
        if(node == n - 1) {
            return 1;
        }

        if(dp[node] != -1) return dp[node];
        int count = 0;

        for(int[] nbr : adj.get(node)) {
            int nbrNode = nbr[0];
            int nbrDist = nbr[1];

            if(target + nbrDist == dist[nbrNode]) {
                count = (count + f(nbrNode, dist, adj, dist[nbrNode], n, dp)) % MOD;
            }
        }

        return dp[node] = (count % MOD);
        
   }
}