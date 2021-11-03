package Recursion;

public class Allcodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="35411";
//		String[] ans=getCodes(input, 0);
//		for(int i=0;i<ans.length;i++)
//			System.out.println(ans[i]);
		printCodes(input, 0, "");
	}
	public static String[] getCodes(String input,int si)
	{
		if(si>=input.length())
		{
			String[] ans= {""};
			return ans;
		}
		String ans1[]=getCodes(input, si+1);
		String ans2[]=getCodes(input, si+2);
		char c1=getChars(input.substring(si,si+1));
		char c2='!';
		if(input.length()-si>=2)
		{
			c2=getChars(input.substring(si,si+2));
			if(c2<'a'|| c2>'z')
				c2='!';
		}
		if(c2=='!')
		{
			for(int i=0;i<ans1.length;i++)
			{
				ans1[i]=c1+ans1[i];
			}
			return ans1;
		}
		String result[]=new String[ans1.length+ans2.length];
		for(int i=0;i<ans1.length;i++)
		{
			result[i]=c1+ans1[i];
		}
		for(int i=0;i<ans2.length;i++)
		{
			result[i+ans1.length]=c2+ans2[i];
		}
		return result;
	}
	private static char getChars(String x)
	{
		int a=Integer.parseInt(x);
		a+=96;
		char x1=(char)a;
		return x1;
	}
	public static void printCodes(String input,int si,String output)
	{
		if(si>=input.length())
		{
			System.out.println(output);
			return;
		}
		char c1=getChars(input.substring(si,si+1));
		char c2='!';
		if(input.length()-si>=2)
		{
			c2=getChars(input.substring(si,si+2));
			if(c2<'a'||c2>'z')
				c2='!';
		}
		printCodes(input, si+1,output+c1);
		if(c2!='!')
			printCodes(input, si+2,output+c2);
	}

}
