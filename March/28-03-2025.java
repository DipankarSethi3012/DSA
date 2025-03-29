class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length, m = grid[0].length;
        int[] res = new int[queries.length];

        int[][] dirr = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int[][] sq = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sq[i][0] = queries[i];
            sq[i][1] = i;
        }

        Arrays.sort(sq, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][m];

        int totalPoints = 0;

        pq.add(new int[] { grid[0][0], 0, 0 });
        visited[0][0] = true;

        for (int[] query : sq) {
            int v = query[0], idx = query[1];

            while (!pq.isEmpty() && pq.peek()[0] < v) {
                int[] curr = pq.poll();
                int cv = curr[0], cr = curr[1], cc = curr[2];

                totalPoints++;

                for (int[] dir : dirr) {
                    int newRow = cr + dir[0];
                    int newCol = cc + dir[1];

                if (newRow >= 0 && newCol >= 0 &&newRow < n && newCol < m &&!visited[newRow][newCol]){
                        pq.add( new int[] { grid[newRow][newCol], newRow, newCol });
                        
                        visited[newRow][newCol] = true;
                    }
                }
            }
            
            res[idx] = totalPoints;
        }
        return res;
    }
}29