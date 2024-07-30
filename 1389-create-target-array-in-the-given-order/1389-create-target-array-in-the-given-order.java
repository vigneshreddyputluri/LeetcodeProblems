class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] ans = new int[n];
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        
        for (int i = 0; i < n; i++){
            a.add(index[i], nums[i]);
        }
        
        for (int i = 0; i < n; i++){
            ans[i] = a.get(i);
        }
            
        return ans;
    }
}