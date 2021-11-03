package CustomQueue;

public class QueueArray <T>{
	T[] data;
	int size;
	int capacity;
	int front;
	int nextElement;
	
	public QueueArray()
	{
		data = (T[]) new Object[1];
		size = 0;
		capacity = 1;
		front = -1;
		nextElement = 0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty()
	{
		return size == 0;
	}
	public boolean isFull() {
		return capacity == size;
	}
	public void enqueue(T element) 
	{
		if(isFull()) {
			T[] temp = data;
			capacity = capacity * 2;
			data = (T[]) new Object[capacity];
			for(int i=front;i<temp.length;i++)
				data[i-front] = temp[i];
			for(int i=0;i<front;i++)
				data[temp.length - front + i] = temp[i]; 
			
			front = 0;
			nextElement = temp.length;
		}
		data[nextElement] = element;
		nextElement = (nextElement+1) % capacity;
		if(front == -1)
			front = 0;
		size++;
	}
	public T dequeue() throws EmptyQueueException
	{
		if(isEmpty()) throw new EmptyQueueException();
		T val = data[front];
		front = (front + 1) % capacity;
		size--;
		if(size == 0)
		{
			front = -1;
			nextElement = 0;
		}
		return val;
	}
	
}
