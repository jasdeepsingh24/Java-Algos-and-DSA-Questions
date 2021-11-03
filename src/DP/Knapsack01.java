package DP;

public class Knapsack01 {
	
	//memoization
	static int knapsackMEM(int[] weight, int[] value, int n, int maxWeight) {

        /* Your class should be named Solution
        * Don't write main().
        * Don't read input, it is passed as function argument.
        * Change in the given tree itself.
        * No need to return or print the output.
        * Taking input and printing output is handled automatically.
        */
    
	int data[][]=new int[weight.length+1][maxWeight+1];
    
    for(int i=0;i<data.length;i++)
        data[i][0]=0;
    for(int j=0;j<data[0].length;j++)
        data[0][j]=0;
    
    for(int i=1;i<data.length;i++)
    {
        for(int j=1;j<data[0].length;j++)
        {
            if(weight[i-1]<=j)
            {
                data[i][j]=Math.max(data[i-1][j],value[i-1]+data[i-1][j-weight[i-1]]);
            }
            else
            {
             	data[i][j]=data[i-1][j];   
            }
        }
    }
	return data[data.length-1][data[0].length-1];
    
	}
	
	
	
	//dp
	static int knapsackDP(int[] weight, int[] value, int n, int maxWeight) {

        /* Your class should be named Solution
        * Don't write main().
        * Don't read input, it is passed as function argument.
        * Change in the given tree itself.
        * No need to return or print the output.
        * Taking input and printing output is handled automatically.
        */
    int[][] dp=new int[weight.length+1][maxWeight+1];
    
    
    for(int i=1;i<dp.length;i++)
    {
        for(int j=1;j<dp[0].length;j++)
        {
            if(weight[i-1]<=j)
            {
                int w=value[i-1]+dp[i-1][j-weight[i-1]];
                dp[i][j]=Math.max(w,dp[i-1][j]);
            }
            else
                dp[i][j]=dp[i-1][j];
        }
    }
    return dp[dp.length-1][dp[0].length-1];

}
}
