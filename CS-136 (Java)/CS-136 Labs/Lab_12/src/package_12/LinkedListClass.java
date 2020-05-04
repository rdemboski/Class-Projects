package package_12; 


public class LinkedListClass 
{ 

   Student head; // head of list 

   // Method to insert a new node 
   public LinkedListClass insert(LinkedListClass list, int id, String name) 
      { 
         Student newNode = new Student(id, name);
         newNode.next = null;
         
         //last student in the list
         Student lastNode = list.head;
         
         //if the first element is null
         if (list.head == null)
         {
        	 //make that element the new node
        	 list.head = newNode;
         }
         
         else
         {
        	//while the list isn't at the last element
        	while (lastNode.next != null)
        	{
        		//iterate until it finds last element
        		lastNode = lastNode.next;
        	}
         
         //adds node to the end of the list
         lastNode.next = newNode;
         }
         return list;
      } 


   // Method to print the LinkedList.
   public void printList(LinkedListClass list) 
      { 
	     //start at the beginning of the list
	     Student selectedNode = list.head;
	     //print title
         System.out.println("LinkedList:");
         
         //while the selected student isn't the last one
         while (selectedNode != null)
         {
        	 //prints the name and id of the student
        	 System.out.println(selectedNode.name + " " + selectedNode.id);
        	 //advances to the next student until all are printed
        	 selectedNode = selectedNode.next;   
         }
      } 
}