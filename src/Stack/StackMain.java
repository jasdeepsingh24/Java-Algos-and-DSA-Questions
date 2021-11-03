package Stack;

import CUstomLinkedList.Node;

public class StackMain {

	public static void main(String[] args) throws StackUnderflowException {
		// TODO Auto-generated method stub
//		StackArray<Integer> s=new StackArray<>();
//		s.push(1);
//		s.push(2);
//		System.out.println(s.peek());
//		s.print();
		
		StackUsingLL<Integer> s=new StackUsingLL<>();
		s.push(10);
		s.push(20);
		System.out.println(s.size());
		System.out.println(s.pop());
		System.out.println(s.peek());
		s.pop();
		System.out.println(s.size());
	}

}
