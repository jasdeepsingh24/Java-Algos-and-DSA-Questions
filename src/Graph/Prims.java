package Graph;

import java.util.Arrays;
import java.util.Scanner;

public class Prims {

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
			edges[fv][sv]=weight;
			edges[sv][fv]=weight;
		}
		prims(edges,v,e);
	}
	private static void prims(int[][] edges,int v,int e)
	{
		boolean[] vis=new boolean[v];
		int[] parent=new int[v];
		int[] weight=new int[v];
		Arrays.fill(weight,Integer.MAX_VALUE);
		weight[0]=0;
		parent[0]=-1;
		
		for(int i=0;i<v;i++)
		{
			int minVertex=getMinVertex(weight, vis);
			vis[minVertex]=true;
			
			for(int j=0;j<v;j++)
			{
				if(!vis[j] && edges[minVertex][j]!=0)
				{
					if(weight[j]>edges[minVertex][j])
					{
						weight[j]=edges[minVertex][j];
						parent[j]=minVertex;						
					}
				}
			}
		}
		
		//Printing
		for(int i=0;i<v;i++)
		{
			System.out.println(Math.min(i, parent[i])+" "+Math.max(i, parent[i])+" "+weight[i]);
		}
	}
	private static int getMinVertex(int[] weight,boolean[] vis)
	{
		int minVertex=-1;
		for(int i=0;i<weight.length;i++)
		{
			if(!vis[i] && (minVertex==-1 || weight[i]<weight[minVertex]))
				minVertex=i;
		}
		return minVertex;
	}

}
