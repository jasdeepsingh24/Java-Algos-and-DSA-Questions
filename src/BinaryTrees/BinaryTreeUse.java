package BinaryTrees;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

// import sun.awt.image.ImageWatched.Link;

public class BinaryTreeUse {

	public static void printzigzag(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;

		System.out.println(root.data);
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.add(root);

		ArrayList<BinaryTreeNode<Integer>> l = new ArrayList<>();
		BinaryTreeNode<Integer> flag = root;
		BinaryTreeNode<Integer> ss = null;
		int c = 1;
		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> curr = q.poll();
			if (curr.left != null) {
				l.add(curr.left);
				q.add(curr.left);
				ss = curr.left;
			}
			if (curr.right != null) {
				l.add(curr.right);
				q.add(curr.right);
				ss = curr.right;
			}
			if (flag == curr) {
				if (!l.isEmpty()) {
					if (c % 2 == 1) {
						for (int i = l.size() - 1; i >= 0; i--) {
							System.out.print(l.get(i).data + " ");
						}
					} else {
						for (int i = 0; i < l.size(); i++) {
							System.out.print(l.get(i).data + " ");
						}
					}
					System.out.println();
				}
				l = new ArrayList<BinaryTreeNode<Integer>>();
				flag = ss;
				c++;
			}
		}
	}

	public static ArrayList<LinkedList<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {
		ArrayList<LinkedList<Integer>> l = new ArrayList<>();
		if (root == null)
			return null;
		LinkedList<Integer> l1 = new LinkedList<>();
		l1.add(root.data);
		l.add(l1);

		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.add(root);

		LinkedList<Integer> temp = new LinkedList<>();
		BinaryTreeNode<Integer> flag = root;
		BinaryTreeNode<Integer> ss = null;

		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> curr = q.poll();
			if (curr.left != null) {
				temp.add(curr.left.data);
				ss = curr.left;
				q.add(curr.left);
			}
			if (curr.right != null) {
				temp.add(curr.right.data);
				ss = curr.right;
				q.add(curr.right);
			}
			if (curr == flag) {
				l.add(temp);
				temp = new LinkedList<>();
				flag = ss;
			}
		}
		return l;
	}

	public static BinaryTreeNode<Integer> takeInput(Scanner s) {
		System.out.println("Enter node data");
		int rootData = s.nextInt();
		if (rootData == -1)
			return null;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		root.left = takeInput(s);
		root.right = takeInput(s);
		return root;
	}

	public static void print(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		String s = root.data + " : ";
		if (root.left != null)
			s += root.left.data + ",";
		if (root.right != null)
			s += root.right.data;
		System.out.println(s);
		print(root.left);
		print(root.right);

	}

	public static BinaryTreeNode<Integer> takeInputLevelwise() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = sc.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> curr = q.poll();
			System.out.print("Enter left node data for " + curr.data);
			int leftData = sc.nextInt();
			if (leftData != -1) {
				curr.left = new BinaryTreeNode<Integer>(leftData);
				q.add(curr.left);
			}
			System.out.print("Enter right node data for " + curr.data);
			int rightData = sc.nextInt();
			if (rightData != -1) {
				curr.right = new BinaryTreeNode<Integer>(rightData);
				q.add(curr.right);
			}
		}
		return root;
	}

	public static void printLevelwise(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		System.out.println(root.data);
		BinaryTreeNode<Integer> flag = root;
		BinaryTreeNode<Integer> temp = null;

		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> curr = q.poll();
			if (curr.left != null) {
				System.out.print(root.left.data + " ");
				temp = root.left;
				q.add(root.left);
			}
			if (curr.right != null) {
				System.out.print(root.right.data);
				temp = root.right;
				q.add(root.right);
			}
			if (flag == curr) {
				System.out.println();
				flag = temp;
			}
		}

	}

	public static Pair diameter(BinaryTreeNode<Integer> root) {
		Pair ans = new Pair();
		if (root == null) {
			ans.h = -1;
			ans.d = 0;
			return ans;
		}
		Pair x = diameter(root.left);
		Pair y = diameter(root.right);

		if (x.h == -1 && y.h == -1) {
			ans.h = 0;
			ans.d = 0;
			return ans;
		}

		int h = 1 + Math.max(x.h, y.h);
		int d = Math.max(2 + x.h + y.h, Math.max(x.d, y.d));
		ans.h = h;
		ans.d = d;
		return ans;
	}

	public static void main(String[] args) {
		// Scanner sc=new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevelwise();
		//// printLevelwise(root);
		// System.out.println(diameter(root).d);
		// print(root);
		// System.out.println(isBalanced(root).isBal);
		// ArrayList<LinkedList<Integer>> l=constructLinkedListForEachLevel(root);

		printzigzag(root);
		// for(int i=0;i<l.size();i++)
		// {
		// LinkedList<Integer> t=l.get(i);
		// for(int j=0;j<t.size();j++)
		// System.out.print(t.get(j));
		// System.out.println();
		//
		// }
	}

	public static boolPair isBalanced(BinaryTreeNode<Integer> root) {
		if (root == null) {
			boolPair ans = new boolPair();
			ans.h = 0;
			ans.isBal = true;
			return ans;
		}

		boolPair l = isBalanced(root.left);
		boolPair r = isBalanced(root.right);
		if (l.isBal == false) {
			return l;
		}
		if (r.isBal == false) {
			return r;
		}
		boolPair ans = new boolPair();
		ans.h = Math.max(r.h, l.h) + 1;
		if (Math.max(r.h, l.h) - Math.min(r.h, l.h) <= 1)
			ans.isBal = true;
		else
			ans.isBal = false;
		return ans;

	}
}

class Pair {
	int h;
	int d;

	public Pair() {
		// TODO Auto-generated constructor stub
	}

	public Pair(int h, int d) {
		// TODO Auto-generated constructor stub
		this.h = h;
		this.d = d;
	}
}

class boolPair {
	int h;
	boolean isBal;
}
