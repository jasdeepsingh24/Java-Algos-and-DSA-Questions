package Recursion;

public class FirstIndexOfNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,4,2,5,7,2};
		System.out.println(firstIndex(a,0,2));
		
	}
	private static int firstIndex(int a[],int i,int t)
	{
		if(i>=a.length) return -1;
		if(a[i]==t) return i;
		return firstIndex(a, i+1, t);
	}

}

