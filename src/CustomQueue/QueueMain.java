package CustomQueue;

public class QueueMain {

	public static void main(String[] args) throws EmptyQueueException{
		// TODO Auto-generated method stub
		QueueArray<Integer> q=new QueueArray<>();
		q.enqueue(10);
		q.enqueue(20);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(30);
		System.out.print(q.size());
		
	}

}
