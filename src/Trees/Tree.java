package Trees;

import java.util.*;

public class Tree{
	
	public static TreeNode<Integer> takeInput(Scanner s)
	{
		int n;
		System.out.println("Enter next node data");
		n=s.nextInt();
		TreeNode<Integer> root = new TreeNode<>(n);
		System.out.println("Enter number of childrens of "+n);
		int childCount = s.nextInt();
		for(int i=0;i<childCount;i++)
		{
			root.children.add(takeInput(s));
		}
		return root;
	}
	public static void print(TreeNode<Integer> root)
	{
		String s=root.data+":";
		for(TreeNode<Integer> child:root.children)
		{
			s+=child.data+",";
		}
		System.out.println(s);
	}
	public static TreeNode<Integer> takeInputLevelwise()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter node data");
		int d=sc.nextInt();
		TreeNode<Integer> root=new TreeNode<Integer>(d);
		Queue<TreeNode<Integer>> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			TreeNode<Integer> current=q.poll();
			System.out.println("Enter number of childrens for "+current.data);
			int children=sc.nextInt();
			
			for(int i=0;i<children;i++)
			{
				System.out.println("Enter "+(i+1)+" number child of "+current.data);
				int x=sc.nextInt();
				TreeNode<Integer> child=new TreeNode<Integer>(x);
				current.children.add(child);
				q.add(child);
			}
		}
		return root;
	}
	public static void printLevelwise(TreeNode<Integer> root)
	{
		System.out.println(root.data);
		Queue<TreeNode<Integer>> q=new LinkedList<>();
		q.add(root);
		TreeNode<Integer> flag=root;
		TreeNode<Integer> temp=null;
		while(!q.isEmpty())
		{
			TreeNode<Integer> current=q.poll();
			for(int i=0;i<current.children.size();i++)
			{
				System.out.print(current.children.get(i).data+" ");
				q.add(current.children.get(i));
				temp=current.children.get(i);
			}
			if(flag==current)
			{
				System.out.println();
				flag=temp;
			}
		}
	}
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
//		TreeNode<Integer> root=takeInput(s);
		TreeNode<Integer> root=takeInputLevelwise();
//		print(root);
		printLevelwise(root);
	}
}
