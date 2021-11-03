package DP;

public class minStepsToOne {
	
//	Given a positive integer 'n', find and return the minimum number of 
//	steps that 'n' has to take to get reduced to 1. You can 
//	perform any one of the following 3 steps:
	
	public static int countMinStepsToOne(int n) {
		//Your code goes here
        
        int[] dp=new int[n+1];
        
        for(int i=2;i<=n;i++)
        {
            int x=dp[i-1];
            int y=Integer.MAX_VALUE;
            int z=Integer.MAX_VALUE;
            if(i%2==0)
                y=dp[i/2];
            if(i%3==0)
                z=dp[i/3];
            dp[i]=Math.min(x,Math.min(y,z))+1;
        }
        return dp[n];
	}
}
