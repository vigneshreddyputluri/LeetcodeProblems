class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        
        List<Integer> ans = new ArrayList<Integer>();
        
        int left = 0;
        int top = 0;
        int bottom = mat.length - 1;
        int right = mat[0].length - 1;
        
        while (true){
            
            for (int i = left; i <= right; i++)
                ans.add(mat[top][i]);
            top++;
            if (top > bottom || left > right) break;
            
            for (int i = top; i <= bottom; i++)
                ans.add(mat[i][right]);
            right--;
            if (top > bottom || left > right) break;
            
            for (int i = right; i >= left; i--)
                ans.add(mat[bottom][i]);
            bottom--;
            if (top > bottom || left > right) break;
            
            for (int i = bottom; i >= top; i--)
                ans.add(mat[i][left]);
            left++;
            if (top > bottom || left > right) break;
        }
        
        return ans;
    }
}