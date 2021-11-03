package PriorityQueue;

import java.util.ArrayList;

public class PriorityQueue {
	private ArrayList<Integer> heap;
	
	public PriorityQueue() {
		heap=new ArrayList<>();
	}
	public boolean isEmpty() {
		return heap.size()==0;
	}
	public int getMin() throws EmptyPriorityQueueException
	{
		if(isEmpty())
			throw new EmptyPriorityQueueException();
		return heap.get(0);
	}
	public void insert(int element)
	{
		heap.add(element);
		
		int childIndex=heap.size()-1;
		int parentIndex=(childIndex-1)/2;
		while(childIndex>0)
		{
			if(heap.get(childIndex)<heap.get(parentIndex))
			{
				int temp=heap.get(parentIndex);
				heap.set(parentIndex, heap.get(childIndex));
				heap.set(childIndex, temp);
				
				childIndex=parentIndex;
				parentIndex=(childIndex-1)/2;
			}
			else
				return;
		}
	}
	public int removeMin() throws EmptyPriorityQueueException
	{
		if(isEmpty())
			throw new EmptyPriorityQueueException();
		int x=heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int index=0;
		int minIndex=0;
		int leftChildIndex=1;
		int rightChildIndex=2;
		
		while(leftChildIndex<heap.size())
		{
			if(heap.get(leftChildIndex)<heap.get(minIndex))
			{
				minIndex=leftChildIndex;
			}
			if(rightChildIndex<heap.size() && heap.get(rightChildIndex)<heap.get(minIndex))
			{
				minIndex=rightChildIndex;
			}
			if(minIndex==index)
				break;
			else
			{
				int temp=heap.get(index);
				heap.set(index, heap.get(minIndex));
				heap.set(minIndex, temp);
				
				index=minIndex;
				leftChildIndex=2*minIndex+1;
				rightChildIndex=2*minIndex+2;
			}
		}
		return x;
	}
	
}
