package Stack;

import java.util.*;

public class StackArray <T> {
	T[] data;
	int nextElement;
	int capacity;
	public StackArray() {
		// TODO Auto-generated constructor stub
		data = (T[]) new Object[10];
		nextElement=0;
		capacity=10;
	}
	public void push(T element)
	{
		if(nextElement == capacity)
		{
			T[] temp=data;
			capacity=capacity*2;
			data=(T[]) new Object[capacity];
			for(int i=0;i<temp.length;i++)
			{
				data[i]=temp[i];
			}
		}
		data[nextElement++] = element;
	}
	public void print()
	{
		for(int i=0;i<nextElement;i++)
			System.out.println(data[i]);
	}
	public int size() {
		return nextElement;
	}
	public T pop() throws StackUnderflowException
	{
		if(isEmpty())
		{
			throw new StackUnderflowException();
		}
		return data[--nextElement];
	}
	public T peek() throws StackUnderflowException
	{
		if(isEmpty()) throw new StackUnderflowException();
		return data[nextElement-1];
	}
	public boolean isEmpty() {
		if(nextElement == 0)
			return true;
		return false;
	}

}
