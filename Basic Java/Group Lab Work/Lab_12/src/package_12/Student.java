package package_12;

public class Student
   {
        
         int id;
         String name;
         Student next; 

         // Constructor 
         Student( int id, String name ) 
            { 
             this.id = id; 
             this.next = null; 
             this.name = name;
            } 
      
   }