package Graph;

public class DFS {
	
	public static void print(int[][] edges)
	{
		boolean vis[]=new boolean[edges.length];
		
		for(int i=0;i<edges.length;i++)
		{
			if(!vis[i])
			{
				dfs(edges,vis,i);
				System.out.println();
			}
		}
	}
	private static void dfs(int[][] edges,boolean[] vis,int fv)
	{
		vis[fv]=true;
		System.out.print(fv+" ");
		for(int i=0;i<edges.length;i++)
		{
			if(!vis[i] && edges[fv][i]==1)
			{
				dfs(edges,vis,i);
			}
		}
	}

}
