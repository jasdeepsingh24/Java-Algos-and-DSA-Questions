package DP;

public class MaximumSquareMatrix {
	public static int findMaxSquareWithAllZeros(int[][] input){
		
//		Given an NxM matrix that contains only 0s and 1s, find out the size of the maximum square sub-matrix with all 0s. You need to return the size of the square matrix with all 0s.
        
		/* Your class should be named Solution.
		 * Don't write main() function.
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
	        if(input.length==0)
	            return  0;
			int dp[][]=new int[input.length][input[0].length];
	        int max=0;
	        for(int i=0;i<dp.length;i++)
	        {
	            dp[i][0]=input[i][0]^1;
	            max=Math.max(dp[i][0],max);
	        }
	        
	        for(int j=0;j<dp[0].length;j++)
	        {
	            dp[0][j]=input[0][j]^1;
	            max=Math.max(max,dp[0][j]);
	        }
	        for(int i=1;i<dp.length;i++)
	        {
	            for(int j=1;j<dp[0].length;j++)
	            {
	                if(input[i][j]==1)
	                {
	                    dp[i][j]=0;
	                } 
	                else
	                {
	                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
	                    max=Math.max(max,dp[i][j]);
	                }
	            }
	        }
	        return max;
	            
	        
	        
		}
}
