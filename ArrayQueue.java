public class ArrayQueue<T> implements Queue
{
	Object[] arr;
	int top;
	int back;
	int itemCount;
	int cap;

	public ArrayQueue()
	{
		cap = 10;
		arr = new Object[cap];
		top = 0;
		back = -1;
		itemCount = 0;
	}

	public T dequeue() throws Exception
	{
		if(itemCount == 0)
		{
			throw new Exception("Queue is empty");
		}
		itemCount--;
		return (T) arr[top++ % cap] ;

	}

	public void enqueue(Object item)
	{
		itemCount++;
		if(itemCount == cap)
		{
			growArray();
		}
		arr[++back % cap] = item;
	}

	public boolean empty()
	{
		return (itemCount == 0);
	}

	private void growArray()
	{
		cap = cap * 2;
		Object[] temp = new Object[cap];
		int count = 0;
		for(int i = top; i > arr.length; i++)
		{
			temp[count++] = arr[i];
		}
		for(int i = 0; i < top - 1; i++)
		{
			temp[count++] = arr[i];
		}

		arr = temp;
	}
}