public class ArrayStack<T> implements Stack
{
	Object[] arr;
	T peek;
	int top;
	int cap;

	public ArrayStack()
	{
		this(10);
	}

	public ArrayStack(int cap)
	{
		this.cap = cap;
		arr = new Object[cap];
		peek = null;
		top = 0;
	}

	public void push(Object item)
	{
		if(top+1 >= cap)
		{
			this.doubleArray();
		}
		peek = (T) item;
		arr[top++] = (T) item;
	}
	public T pop() throws Exception
	{
		return (T) arr[--top];
	}
	public T peek() throws Exception
	{
		return peek;
	}
	public boolean empty()
	{
		return (top == 0);
	}
	private void doubleArray()
	{
		cap = cap * 2;
		Object[] temp = new Object[cap];
		for(int i = 0; i < top; i++)
		{
			temp[i] = arr[i];
		}
		arr = temp;
	}
}