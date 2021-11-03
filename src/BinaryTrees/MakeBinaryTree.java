package BinaryTrees;

public class MakeBinaryTree {
	
	public static BinaryTreeNode<Integer> fromPreorderInorder(int[] preOrder,int[] inOrder)
	{
		return fromPreorderInorder(preOrder, inOrder,0,preOrder.length-1,0,inOrder.length-1);
	}
	private static BinaryTreeNode<Integer> fromPreorderInorder(int[] preOrder,int[] inOrder,int ps,int pe,int is,int ie)
	{
		if(is>ie || ps>pe) return null;
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(preOrder[ps]);
		if(is==ie)
		{
			return root;
		}
		int p=-1;
		for(int i=is;i<=ie;i++)
		{
			if(inOrder[i]==preOrder[ps])
			{
				p=i;
				break;
			}
		}
		if(p==-1) return null;
		
		int leftInS=is;
		int leftInE=p-1;
		int leftPreS=ps+1;
		int leftPreE=leftInE-leftInS+leftPreS;
		
		int rightInS=p+1;
		int rightInE=ie;
		int rightPreS=leftPreE+1;
		int rightPreE=pe;
		
		root.left=fromPreorderInorder(preOrder, inOrder, leftPreS, leftPreE, leftInS, leftInE);
		root.right=fromPreorderInorder(preOrder, inOrder, rightPreS, rightPreE, rightInS, rightInE);
		return root;
	}

}
