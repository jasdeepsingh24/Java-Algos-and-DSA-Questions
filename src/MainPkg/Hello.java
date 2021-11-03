package MainPkg;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(2%3);

	}
	public static void fun() {
		System.out.println("fun");
	}
	int[] a;
	private static int fibo(int n)         //100
	{
		if(n==0 || n==1)
		{
			return n;
		}
		if(a[n-1]!=-1)
		{
			
		}
		return fibo(n-1)+fibo(n-2);
	}

}


