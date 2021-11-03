package Graph;

import java.util.*;

public class BFS {
	
	public static void print(int[][] edges)
	{
		boolean[] vis=new boolean[edges.length];
		for(int i=0;i<edges.length;i++)
		{
			if(!vis[i])
			{
				bfs(edges,vis,i);
				System.out.println();
			}
		}
	}
	private static void bfs(int[][] edges,boolean[] vis,int fv)
	{
		Queue<Integer> q=new LinkedList<>();
		q.add(fv);
		vis[fv]=true;
		
		
		while(!q.isEmpty())
		{
			int x=q.poll();
			System.out.print(x+" ");
			for(int i=0;i<edges.length;i++)
			{
				if(!vis[i] && edges[x][i]==1)
				{
					q.add(i);
					vis[i]=true;
				}
			}
		}
	}

}
