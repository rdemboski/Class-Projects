package package_8;

public class ArrayLabClass 
{
	
	private int[] intArray;
	private int min, max;
	private double average;
	
	public ArrayLabClass( int[] intArray)
	{
		
		this.intArray = intArray;
	}
	public int calcMin()
	{
		int index, min, test;
		min=0;
		boolean firstRun = true;
		for( index = 0; index < intArray.length; index++)
		{
			test = intArray[index];
			if(firstRun)
			{
				min = intArray[index];
				firstRun = false;
			}
			else if(test<min)
			{
				min = test;
			}
				
		}
	 this.min = min;
	 return min;
	}
	
	public int calcMax()
	{
		int index, max, test;
		max=0;
		boolean firstRun = true;
		for( index = 0; index < intArray.length; index++)
		{
			test = intArray[index];
			if(firstRun)
			{
				max = intArray[index];
				firstRun = false;
			}
			else if(test > max)
			{
				max = test;
			}
				
		}
	 this.max = max;
	 return max;
	}
	
	public double calcAverage()
	{
		int index;
		double average, sum;
		
		sum = 0;
		
		for( index = 0; index < intArray.length; index++)
		{
			sum = sum + intArray[index];
		}
		
		average = sum / intArray.length;
		
		this.average = average;
		return average;
	}
	
	
	public int getMin()
	{
		return min;
	}
	
	
	public int getMax()
	{
		return max;
	}
	
	
	public double getAverage()
	{
		return average;
	}
	
	
	public void printArray()
	{
		int index;
		System.out.println("Array values");
		
		for(index = 0; index < intArray.length; index++)
		{
			if(index==(intArray.length - 1))
			{
				System.out.print(intArray[index]);	
			}
			else
			{
				System.out.print(intArray[index] + ", ");
			}
		}
		
	}
}
