package Graph;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int v=sc.nextInt();
		int e=sc.nextInt();
		int[][] edges=new int[v][v];
		
		for(int i=0;i<e;i++)
		{
			int fv=sc.nextInt();
			int sv=sc.nextInt();
			edges[fv][sv]=1;
			edges[sv][fv]=1;	
		}
//		DFS.print(edges);
		BFS.print(edges);
	}

}
