package Recursion;

public class SubsetSumToK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {5,12,3,17,1,18,15,3,17};
		int k=6;
//		int[][] ans=subsetsToK(a, k,0);
//		for(int i=0;i<ans.length;i++)
//		{
//			for(int j=0;j<ans[i].length;j++)
//				System.out.print(ans[i][j]+" ");
//			System.out.println();
//		}
		printSubsetsToK(a, 0, k, "");
	}
	public static int[][] subsetsToK(int[] input,int k,int si)
	{
		if(k==0)
		{
			int[][] ans= new int[1][0];
			return ans;
		}
		if(si==input.length)
		{
			int[][] ans=new int[0][0];
			return ans;
		}
		int[][] include=subsetsToK(input, k-input[si],si+1);
		int[][] exclude=subsetsToK(input, k, si+1);
		int[][] result=new int[include.length+exclude.length][];
		for(int i=0;i<include.length;i++)
		{
			result[i]=new int[include[i].length+1];
			result[i][0]=input[si];
			for(int j=0;j<include[i].length;j++)
				result[i][j+1]=include[i][j];
		}
		for(int i=0;i<exclude.length;i++)
		{
			result[i+include.length]=new int[exclude[i].length];
			for(int j=0;j<exclude[i].length;j++)
				result[i+include.length][j]=exclude[i][j];
		}
		return result;
	}
	public static void printSubsetsToK(int[] input,int si,int k,String output)
	{
		if(k==0)
		{
			System.out.println(output);
			return;
		}
		if(si>=input.length)
			return;
		printSubsetsToK(input, si+1, k-input[si], input[si]+" "+output);
		printSubsetsToK(input, si+1, k,output);
	}

}
