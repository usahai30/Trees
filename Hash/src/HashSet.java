
public class HashSet {
	
	static int n=6;
	static Integer[] arr;
	
	public HashSet()
	{
		arr = new Integer[n];
	}
	
	public Integer getIndex(Integer value)
	{
		return value%n;
	}
	
	public boolean insert(Integer value)
	{
		int c=0,i=1;
		int hash = getIndex(value);
		int index = hash;
		
		while(arr[index%n]!=null&&i<=n)
		{
			index=hash+i;
			i++;c++;
		}
		
		if(i==n)
		{
			System.out.println("Collisions: "+(c)+" Array is full");
			return false;
		}else
		{
			System.out.println("Collisions: "+(c)+" for "+value);
			arr[index%n]=value;
			return true;
		}
	}
	
	public void printArray()
	{
		for(Integer each: arr)
			System.out.print(each+" ");
		
		System.out.println();
	}
	
	public static void main(String args[])
	{
		HashSet hs = new HashSet();
		hs.printArray();
		hs.insert(6);
		hs.insert(2);
		hs.insert(10);
		hs.insert(11);
		hs.insert(4);
		hs.insert(14);
		hs.insert(16);
		hs.printArray();		
	}
	
}
