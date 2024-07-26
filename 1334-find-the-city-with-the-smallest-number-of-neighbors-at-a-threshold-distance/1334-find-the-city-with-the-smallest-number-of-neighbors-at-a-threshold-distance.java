class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] distance = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == col) distance[row][col] = 0;
                else distance[row][col] = Integer.MAX_VALUE;
            }
        }

        for (int[] edge : edges) {
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2]; 
        }

        for (int city = 0; city < n; city++) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (distance[row][city] != Integer.MAX_VALUE && distance[city][col] != Integer.MAX_VALUE) {
                        distance[row][col] = Math.min(distance[row][city] + distance[city][col], distance[row][col]);
                    }
                }
            }
        }

        int result = 0;
        int minCount = Integer.MAX_VALUE;

        for (int row = 0; row < n; row++) {
            int count = 0;
            for (int col = 0; col < n; col++) {
                if (distance[row][col] <= distanceThreshold) count++;
            }
            if (count <= minCount) {
                minCount = count;
                result = row;
            }
        }

        return result;

    }
}