package DP;

public class EditDistance {
	
	
	
//	You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings.
//	Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. In order to do so, you can perform the following three operations:
//	1. Delete a character
//	2. Replace a character with another one
//	3. Insert a character
//	Note :
//	Strings don't contain spaces in between.
	
	
	
	public static int editDistance(String s, String t) {
		//Your code goes here
        int m=s.length();
        int n=t.length();
        if(m==0) return n;
        if(n==0) return m;
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            dp[i][0]=i;
        for(int j=0;j<=n;j++)
            dp[0][j]=j;
        
        
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(m-i)==t.charAt(n-j))
                    dp[i][j]=dp[i-1][j-1];
                else
                {
                    int x=dp[i-1][j-1];
                    int y=dp[i-1][j];
                    int z=dp[i][j-1];
                    
                    dp[i][j]=Math.min(x,Math.min(y,z))+1;
                }
            }
        }
        return dp[m][n];
    }

}
