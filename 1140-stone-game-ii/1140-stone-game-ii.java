class Solution {
    private Integer[][][] memo;

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        memo = new Integer[n][n + 1][2];
        
        return func(0, 1, true, piles);
    }

    private int func(int idx, int M, boolean aliceTurn, int[] arr) {
       
        if (idx >= arr.length) return 0;



        if (memo[idx][M][aliceTurn ? 1 : 0] != null) {
            return memo[idx][M][aliceTurn ? 1 : 0];
        }

        int Res = 0; // Variable to store the result of the current state
        int Res1 = Integer.MIN_VALUE; // Initialize for Alice's maximum score
        int Res2 = Integer.MAX_VALUE; // Initialize for Bob's minimum score for Alice.
        int currScore = 0; // Cumulative score of the current move

        // Try taking from 1 to 2 * M stones
        for (int x = 1; x <= 2 * M && x <= arr.length - idx; x++) {
            // Recursively compute the result for the next state
            // Update the maximum pile size and switch turn
            int other = func(idx + x, Math.max(M, x), !aliceTurn, arr);
            
            if (aliceTurn) {
                // If it's Alice's turn, update the cumulative score
                currScore += arr[idx + x - 1];
                // Alice wants to maximize her score, so take the maximum of the current result
                Res1 = Math.max(Res1, currScore + other);
                // Store the result in Res
                Res = Res1;
            } else {
           // During Bob's turn, he seeks to minimize Alice's score (or maximize his own indirectly)
               Res2 = Math.min(Res2, other);
            // Update Res with Bob's optimal result
               Res = Res2;
            }
        }

        // Store the computed result in the memoization table
        memo[idx][M][aliceTurn ? 1 : 0] = Res;
        return Res; // Return the result for the current state
    }
}