
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;
        
        int rowStart = 0;
        int colStart = 0;
        List<Integer> ls = new ArrayList<>();
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Traverse Right
            for (int col = colStart; col <= colEnd; col++) {
                ls.add(matrix[rowStart][col]);
            }
            rowStart++;
            
            // Traverse Down
            for (int row = rowStart; row <= rowEnd; row++) {
                ls.add(matrix[row][colEnd]);
            }
            colEnd--;
            
            // Traverse Left
            if (rowStart <= rowEnd) {
                for (int col = colEnd; col >= colStart; col--) {
                    ls.add(matrix[rowEnd][col]);
                }
                rowEnd--;
            }
            
            // Traverse Up
            if (colStart <= colEnd) {
                for (int row = rowEnd; row >= rowStart; row--) {
                    ls.add(matrix[row][colStart]);
                }
                colStart++;
            }
        }
        
        return ls;
    }
}
