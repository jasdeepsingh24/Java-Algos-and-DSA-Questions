package DP;

public class CoinExchange {
	
	public static int countWaysToMakeChange(int denominations[], int value){
        // Write your code here
        
        int[][] dp=new int[denominations.length+1][value+1];
        
        for(int i=0;i<dp.length;i++)
            dp[i][0]=1;
        
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(j<denominations[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-denominations[i-1]];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
		
	}

}
