class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        int totWealth = 0;
        
        for (int i = 0; i < accounts.length; i++){
            totWealth = 0;
            
            for (int j = 0; j < accounts[i].length; j++){
                totWealth += accounts[i][j];
            }
            
            if (maxWealth < totWealth){
                maxWealth = totWealth;
            }
        }
        
        return maxWealth;
    }
}