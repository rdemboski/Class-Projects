package package_11;

public class LinkedListClass
{

	private StudentClass headRef;
	
	
	//CONSTRUCTORS
	public LinkedListClass()
	{
		headRef = null;
	}
	
	
	public LinkedListClass(LinkedListClass copied)
	{
		if (copied.headRef != null)
		{
			this.headRef = new StudentClass(copied.headRef);
			StudentClass cpdWkgRef = copied.headRef.nextRef;
			StudentClass thisWkgRef = this.headRef;
			
			while (cpdWkgRef != null)
			{
				thisWkgRef.nextRef = new StudentClass(cpdWkgRef);
				cpdWkgRef.nextRef = cpdWkgRef;
				thisWkgRef.nextRef = thisWkgRef;
			}
		}
	}
	
	
	//METHODS
	public void appendData(StudentClass data)
	{
		this.headRef = appendDataHelper(headRef, data);
	}
	
	
	private StudentClass appendDataHelper(StudentClass wkgRef,
			                              StudentClass newData)
	{
		
		if (wkgRef != null)
		{
				wkgRef.nextRef = appendDataHelper(wkgRef.nextRef, newData);
				
				return wkgRef;
		}
		
		
		return new StudentClass(newData);
	}
	
	
	public void clearList()
	{
		headRef = null;
	}
	
	
	public void displayList()
	{
		if (headRef != null)
		{
			displayListHelper(headRef);
		}
		else
		{
			System.out.println("Empty List");		
		}
	}
	
	
	private void displayListHelper(StudentClass wkgRef)
	{
		if(wkgRef != null)
		{
			System.out.println(wkgRef.toString());
			displayListHelper(wkgRef.nextRef);
		}
	}
	
	
	public StudentClass getNodeData(StudentClass requestedData)
	{
		StudentClass wkgRef = this.headRef;
		
		while (wkgRef != null && wkgRef.compareTo(requestedData) != 0)
		{
			wkgRef = wkgRef.nextRef;
		}
		return wkgRef;
	}
	
	
	public void insertAtHead(StudentClass newData)
	{
		StudentClass newNode = newData;
		
		newNode.nextRef = this.headRef;
		headRef = newNode;
	}
	
	
	public boolean insertNodeAfter(StudentClass specifiedNode,
			                       StudentClass newData)
	{
		StudentClass wkgRef = this.headRef;
		//StudentClass newRef = this.headRef;
		StudentClass newNode = newData;
		
		while (wkgRef != null && wkgRef.compareTo(specifiedNode) != 0)
		{
			wkgRef = wkgRef.nextRef;
		}
		
		if (wkgRef != null)
		{
			wkgRef.nextRef = newNode;
			return true;
		}
		
		return false;
	}
	
	
	public boolean insertNodePrior(StudentClass specifiedNode,
			                       StudentClass newData)
	{
		StudentClass wkgRef = this.headRef;
		StudentClass newNode = newData;
		
		//special case
		if (headRef != null && headRef.compareTo(specifiedNode) == 0)
		{
			insertAtHead(newNode);
		}
		
		while (wkgRef.nextRef != null &&
			   wkgRef.nextRef.compareTo(specifiedNode) != 0)
		{
			wkgRef = wkgRef.nextRef;
		}
		
		if (wkgRef.nextRef != null)
		{
			newNode.nextRef = wkgRef.nextRef;
			wkgRef.nextRef = newNode;
			
			return true;
		}
		
		return false;
	}
	
	
	public StudentClass removeItem(StudentClass toBeRemoved)
	{
		StudentClass wkgRef = this.headRef;
		
		//special case
		if (headRef != null && headRef.compareTo(toBeRemoved) == 0)
		{
			headRef = headRef.nextRef;
		}
		
		while (wkgRef.nextRef != null &&
			   wkgRef.nextRef.compareTo(toBeRemoved) != 0)
		{	
			wkgRef = wkgRef.nextRef;
			
			if (wkgRef.nextRef != null)
			{
				wkgRef = toBeRemoved.nextRef;
			}
		}
		
		
		
		return wkgRef;
	}
}
