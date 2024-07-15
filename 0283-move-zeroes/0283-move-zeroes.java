class Solution {
    public void moveZeroes(int[] arr) {
        int c = 0;
        int i = 0;
        int j = arr.length-1;
        int k = 0;
        while(i<=j){
            if(arr[0] == 0){
                c++;
            }
            if(arr[i] != 0){
                arr[k++] = arr[i];
            }
            i++;
        }
        
        while(k<=j){
            arr[k++] = 0;
        }
        
    }
}