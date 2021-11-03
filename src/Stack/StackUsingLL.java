package Stack;

import CUstomLinkedList.Node;

public class StackUsingLL<T> {
	Node<T> head;
	int size;
	public StackUsingLL() {
		// TODO Auto-generated constructor stub
		size=0;
		head=null;
	}
	public void push(T data)
	{
		size++;
		Node<T> t=new Node<>(data);
		t.next=head;
		head=t;
	}
	public T pop() throws StackUnderflowException
	{
		if(isEmpty()) throw new StackUnderflowException();
		T val = head.data;
		head=head.next;
		size--;
		return val;
	}
	public boolean isEmpty()
	{
		if(head==null)
			return true;
		return false;
	}
	public T peek() throws StackUnderflowException
	{
		if(isEmpty()) throw new StackUnderflowException();
		return head.data;
	}
	public int size() {
		return size;
	}
	

}
