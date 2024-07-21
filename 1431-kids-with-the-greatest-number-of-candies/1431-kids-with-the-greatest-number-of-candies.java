class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = max(candies);
        List<Boolean> ans = new ArrayList<Boolean>();
        
        for (int i = 0; i < candies.length; i++){
            if (candies[i] + extraCandies < maxCandies)
                ans.add(false);
            else
                ans.add(true);
        }
        
        return ans;
    }
    
    public int max(int[] candies){
        int ans = candies[0];
        
        for (int candy : candies){
            ans = Math.max(ans, candy);
        }
        
        return ans;
    }
}