package Recursion;

public class CheckIfArrayIsSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,7,3,4,5,6};
		System.out.print(check(a));

	}
	private static boolean check(int a[])
	{
		if(a.length<=1)
			return true;
		int small[] = new int[a.length-1];
		for(int i=1;i<a.length;i++)
		{
			small[i-1]=a[i];
		}
		boolean ans=check(small);
		if(!ans) return false;
		if(a[0]<=a[1])
			return true;
		else return false;
	}

}
