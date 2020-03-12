package package_7;

public class ArrayClass
{
	//Constants
	private static final int DEFAULT_CAPACITY = 10;
	private static final String EMPTY_STRING = "";
	
	//Member variables
	private int arrayCapacity;
	private String[] stringArray;
	
	
	//Default constructor
	public ArrayClass()
	{
		int index;
		
		arrayCapacity = DEFAULT_CAPACITY;
		stringArray = new String[arrayCapacity];
		
		for (index = 0; index < this.arrayCapacity; index++)
		{
			this.stringArray[index] = EMPTY_STRING;
		}
	}
	
	//Initialize constructor
	public ArrayClass(int capacity)
	{
		int index;
		
		arrayCapacity = capacity;
		stringArray = new String[arrayCapacity];
		
		for (index = 0; index < this.arrayCapacity; index++)
		{
			this.stringArray[index] = EMPTY_STRING;
		}
	}
	
	//Copy constructor
	public ArrayClass(ArrayClass copied)
	{
		int index;
		
		this.arrayCapacity = copied.arrayCapacity;
		this.stringArray = new String[this.arrayCapacity];
		
		for (index = 0; index < this.arrayCapacity; index++)
		{
			this.stringArray[index] = copied.stringArray[index];
		}
	}
	
	
	public String accessItemAt(int accessIndex)
	{
	     if(accessIndex >= 0 && accessIndex < this.arrayCapacity)
	     {
	    	 return this.stringArray[accessIndex];
	     }
	     else
	     {
	    	 return EMPTY_STRING;
	     }
	}
	
	
	public int getCurrentCapacity()
	{
		return this.arrayCapacity;
	}
	
	
	public boolean arrayAtCapacity()
	{
		int index;
		
		for (index = 0; index < this.arrayCapacity; index++)
		{
			if (this.stringArray[index] == null)
			{
				return false;
			}
		}
		return true;
	}
	
	
	public void listNames()
	{
	    int index = 0;
	    System.out.println("\nArrayClass Name List:");
	    
	    while (index < this.arrayCapacity)
	    {
	        if (this.stringArray[index] != null && 
	        	this.stringArray[index] != EMPTY_STRING)
	        {
	            System.out.println("Name: " + this.stringArray[index]);
	        }
	        index++;
	    }
	}
	
	
	public boolean resize(int newCapacity)
	{
		int index;
		String[] resizedArray;
		
		if (newCapacity > arrayCapacity)
		{
			resizedArray = new String[newCapacity];
			
			for (index = 0; index < this.arrayCapacity; index++)
			{
				resizedArray[index] = stringArray[index];
			}
			stringArray = resizedArray;
			arrayCapacity = newCapacity;
			
			return true;
		}
		return false;
	}
	
	
	public boolean setItemAt(int indexToSet,
							 String newValue)
	{	
		if (indexToSet < 0 || indexToSet > this.arrayCapacity)
		{
			return false;
		}
		
		this.stringArray[indexToSet] = newValue;
		return true;
	}
	
}
