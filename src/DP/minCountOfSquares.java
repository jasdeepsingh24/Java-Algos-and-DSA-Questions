package DP;

public class minCountOfSquares {
	
//	Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
//	That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. The output 
//	will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.
	
	public static int minCount(int n) 
    {
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            int min=Integer.MAX_VALUE;
            for(int j=1;j<=Math.sqrt(i);j++)
            {
            	min=Math.min(min,dp[i-(int)Math.pow(j,2)]);
            }
            dp[i]=min+1;
        }
        return dp[n];
    }
}
