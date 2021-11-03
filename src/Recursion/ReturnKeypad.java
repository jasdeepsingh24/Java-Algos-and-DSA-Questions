package Recursion;

public class ReturnKeypad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=23;
		int f=checkFor01(n+"");
		if(f==-1)
		{
			System.out.println("Invalid input");
			return;
		}
//		String[] x=keypad(n);
//		for(int i=0;i<x.length;i++)
//			System.out.println(x[i]);
		
		printKeypad(n,"");
	}
	private static void printKeypad(int s,String output)      //// It will print all the possible outcome on the console.
	{
		if(s<=1)
		{
			System.out.println(output);
			return;
		}
		String smallAns=getKeys(s%10);
		for(int i=0;i<smallAns.length();i++)
		{
			printKeypad(s/10,smallAns.charAt(i)+output);
		}
	}
	private static int checkFor01(String s)				// It checks if the input contains 0 or 1 if yes 
	{													// then it will return -1, indicating that provided input was wrong.
		if(s.contains("1") || s.contains("0"))
			return -1;
		return 1;
	}
	private static String[] keypad(int s)         // It will return all the possible outcome in an array.
	{
		if(s<=1)
		{
			String ans[]= {""};
			return ans;
		}
		String[] smallAns=keypad(s/10);
		String keys=getKeys(s%10);
		String ans[]=new String[smallAns.length*keys.length()];
		int k=0;
		for(int j=0;j<smallAns.length;j++)
		{
			for(int i=0;i<keys.length();i++)
				ans[k++]=smallAns[j]+keys.charAt(i);
		}
		return ans;
	}
	private static String getKeys(int n)    // It provides all possible alphabets that can be typed by pressing a single number on keypad
	{
		String ans="";
		switch(n)
		{
			case 2:
				ans="abc";
				break;
			case 3:
				ans="def";
				break;
			case 4:
				ans="ghi";
				break;
			case 5:
				ans="jkl";
				break;
			case 6:
				ans="mno";
				break;
			case 7:
				ans="pqrs";
				break;
			case 8:
				ans="tuv";
				break;
			case 9:
				ans="wxyz";
				break;
		}
		return ans;
	}
}
