package package_10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOLab
   {
      /**
       * Class Global FileReader variable so methods can be used
       */
      public static FileReader fileIn;  
	
      /**
       * Class Global FileWriter variable so methods can be used
       */
      public static FileWriter toFile;
      
      /**
       * Global constant variable to check for end of file marker
       * 
       */
      public static final int END_OF_LINE = -1;


      public static void main(String[] args)
         {
            // Create local variable for file input
    	  	int index = 0;
    	  	String fileName = "lab_10.txt";
            
            //Create code to write to a file
            //make sure and use try/catch 
            //once you open the file you will need to write something to it
            //remember to flush and close file
            //Catch an IOException and printStackTrace
          
            //Your code goes here!!
            try
            {
            	toFile = new FileWriter(fileName);
            	toFile.write("CS136 Lab is more fun online!");
            	toFile.flush();
            	toFile.close();
            }
            
            catch(IOException ioe)
            {
            	ioe.printStackTrace();
            }
            
            //Create code to read from the file just created
            //make sure and use try/catch 
            //remember to close file
            //Catch an IOException and printStackTrace
            //Catch a FileNotFoundException printStackTrace
           
            
            //Your code goes here!!
            try
            {
            	fileIn = new FileReader(fileName);
            	
            	while (index != END_OF_LINE)
            	{
            		index = fileIn.read();
            		System.out.print((char)index);
            		index++;
            	}

            }

            catch(FileNotFoundException fnfe)
            {
            	fnfe.printStackTrace();
            }
            
            catch(IOException ioe)
            {
            	ioe.printStackTrace();
            }
            
         }

   }