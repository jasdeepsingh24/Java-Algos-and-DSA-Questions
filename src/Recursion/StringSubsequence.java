package Recursion;

public class StringSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x="xyz";
		String[] ans=subsequence(x);
		
		for(int i=0;i<ans.length;i++)
			System.out.println(ans[i]);
	}
	private static String[] subsequence(String s)
	{
		if(s.length()==0)
		{
			String[] ans= {" "};
			return ans;
		}
		String[] smallAns=subsequence(s.substring(1));
		String[] ans=new String[2*smallAns.length];
		for(int i=0;i<smallAns.length;i++)
		{
			ans[i]=smallAns[i];
		}
		for(int i=0;i<smallAns.length;i++)
		{
			ans[i+smallAns.length]=s.charAt(0)+smallAns[i];
		}
		return ans;
	}

}
