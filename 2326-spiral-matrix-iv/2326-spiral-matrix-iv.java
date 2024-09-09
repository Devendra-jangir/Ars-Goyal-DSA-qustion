/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(mat[i], -1);
        }

        int row = m - 1;   
        int col = n - 1;   
        int r = 0;         
        int c = 0;        

        ListNode temp = head;

        while (temp != null && r <= row && c <= col) {
            for (int i = c; i <= col && temp != null; i++) {
                mat[r][i] = temp.val;
                temp = temp.next;
            }
            r++;  

            for (int i = r; i <= row && temp != null; i++) {
                mat[i][col] = temp.val;
                temp = temp.next;
            }
            col--;  

            if (r <= row) {
                for (int i = col; i >= c && temp != null; i--) {
                    mat[row][i] = temp.val;
                    temp = temp.next;
                }
                row--; 
            }

            if (c <= col) {
                for (int i = row; i >= r && temp != null; i--) {
                    mat[i][c] = temp.val;
                    temp = temp.next;
                }
                c++;  
            }
        }
        return mat;
    }
}
