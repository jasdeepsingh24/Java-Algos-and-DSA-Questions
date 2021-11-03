package Graph;
import java.util.*;

public class Krushkal {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int v=sc.nextInt();
		int e=sc.nextInt();
		Edge[] input=new Edge[v];
		Edge[] output=new Edge[v-1];
		int[] parent=new int[v];
		fillArray(parent);
		
		for(int i=0;i<e;i++)
		{
			int source=sc.nextInt();
			int destination=sc.nextInt();
			int weight=sc.nextInt();
			
			Edge t=new Edge(source, destination, weight);
			
			input[i]=t;
		}
		Arrays.sort(input);
		
		int j=0;
		for(int i=0;i<input.length;i++)
		{
			if(j==v-1)
				break;
			
			int source=input[i].source;
			int destination=input[i].destination;
			int weight=input[i].weight;
			
			int v1=getParent(source,parent);
			int v2=getParent(destination, parent);
			
			if(v1!=v2)
			{
				Edge t=new Edge(Math.min(destination, source), Math.max(destination, source), weight);
				output[j++]=t;
				parent[v1]=v2;
			}
		}
		printEdges(output);
		

	}
	private static void printEdges(Edge[] output)
	{
		for(int i=0;i<output.length;i++)
		{
			System.out.println(output[i].source+" "+output[i].destination+" "+ output[i].weight);
		}
	}
	private static void fillArray(int[] parent)
	{
		for(int i=0;i<parent.length;i++)
			parent[i]=i;
	}
	private static int getParent(int v,int[] parent)
	{
		while(v!=parent[v])
		{
			v=parent[v];
		}
		return v;
	}

}
class Edge implements Comparable<Edge>{
	int source;
	int destination;
	int weight;
	
	public Edge(int source,int destination,int weight)
	{
		this.source=source;
		this.destination=destination;
		this.weight=weight;
	}
	
	public int compareTo(Edge e)
	{
		return weight-e.weight;
	}
}
