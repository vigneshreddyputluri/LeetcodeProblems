class Solution {
    public int[][] generateMatrix(int n) {
        
        int count = 1;
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = n - 1;
        
        int[][] ans = new int[n][n];
        
        while (true){
            
            for (int i = left; i <= right; i++)
                ans[top][i] = count++;
            top++;
            if (count > n*n) break;
            
            for (int i = top; i <= bottom; i++)
                ans[i][right] = count++;
            right--;
            if (count > n*n) break;
            
            for (int i = right; i >= left; i--)
                ans[bottom][i] = count++;
            bottom--;
            if (count > n*n) break;
            
            for (int i = bottom; i >= top; i--)
                ans[i][left] = count++;
            left++;
            if (count > n*n) break;
        }
        
        return ans;
    }
}