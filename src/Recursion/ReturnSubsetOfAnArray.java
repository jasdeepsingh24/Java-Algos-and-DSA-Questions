package Recursion;

public class ReturnSubsetOfAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {15,20,12};
//		int ans[][]=subsets(a,0);
//		for(int i=0;i<ans.length;i++)
//		{
//			for(int j=0;j<ans[i].length;j++)
//				System.out.print(ans[i][j]+" ");
//			System.out.println();
//		}
		printSubsets(a,"",0);
		
	}
	public static int[][] subsets(int[] input,int si)
	{
		if(si==input.length)
		{
			int[][] ans= {{}};
			return ans;
		}
		int smallAns[][]=subsets(input,si+1);
		int result[][]=new int[smallAns.length*2][];
		for(int i=0;i<smallAns.length;i++)
		{
			result[i]=new int[smallAns[i].length];
			for(int j=0;j<smallAns[i].length;j++)
			{
				result[i][j]=smallAns[i][j];
			}
		}
		for(int i=0;i<smallAns.length;i++)
		{
			result[smallAns.length+i]=new int[smallAns[i].length+1];
			result[smallAns.length+i][0]=input[si];
			for(int j=0;j<smallAns[i].length;j++)
			{
				result[smallAns.length+i][1+j]=smallAns[i][j];
			}
		}
		return result;
	}
	public static void printSubsets(int[] input,String output,int si)
	{
		if(si==input.length)
		{
			System.out.println(output);
			return;
		}
		printSubsets(input, output, si+1);
		printSubsets(input, output+input[si]+" ", si+1);
	}
	

}
