package Graph;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkastra {

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
			int weight=sc.nextInt();
			edges[fv][sv]=edges[sv][fv]=weight;
		}
		dijkastra(edges,v);
	}
	private static void dijkastra(int[][] edges,int v)
	{
		boolean[] vis=new boolean[v];
		int[] distance=new int[v];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0]=0;
		
		for(int i=0;i<v;i++)
		{
			int minVertex=getMinVertex(distance,vis);
			vis[minVertex]=true;
			
			for(int j=0;j<v;j++)
			{
				if(!vis[j] && edges[minVertex][j]!=0)
				{
					if(distance[j]>edges[minVertex][j])
					{
						distance[j]=edges[minVertex][j];
					}
				}
			}
		}
	}
	private static int getMinVertex(int[] distance,boolean[] vis)
	{
		int minVertex=-1;
		for(int i=0;i<distance.length;i++)
		{
			if(!vis[i] && (minVertex==-1 || distance[i]<distance[minVertex]))
				minVertex=i;
		}
		return minVertex;
	}

}
