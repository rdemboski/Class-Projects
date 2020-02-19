package package_5;

import javax.swing.JOptionPane;

public class ZellersCongruenceClass
   {
      private static final int DAYS_IN_WEEK = 7;
      private static final int MONTHS_IN_YEAR = 12;
      private static final int THIRD_MONTH = 3;
      
      public static void main(java.lang.String[] args)
      {
       String monthStr;  
       String dayStr;
       String yearStr;
       String day = "lol";
       String date = "lol";
       
       int monthInt;
       int dayInt;
       int yearInt;
       int bDayNum = 0;  
       
       
       monthStr = JOptionPane.showInputDialog("Enter month of birth");
       dayStr = JOptionPane.showInputDialog("Enter day of birth");
       yearStr = JOptionPane.showInputDialog("Enter year of birth");
       
       monthInt = Integer.parseInt(monthStr);
       dayInt = Integer.parseInt(dayStr);
       yearInt = Integer.parseInt(yearStr);
       
       System.out.println("Birthday Program");
       System.out.println("=================\n");
       
       day = findBirthdayString(bDayNum);
       
       System.out.println("For the date " + date + ", the person was born"
             + " on a " + day);
      }
      
      
      private static int findSecondElement(int month)
      {
         int January = 1, February = 2;
         
         if ((month == January) || (month == February))
            {
                 return (month + MONTHS_IN_YEAR);   
            }
      }
      
      
      private static int findFourthElement(int yearPart)
      {
         return 0;
      }
      
      
      private static int findFifthElement(int centuryPart)
      {
         return 0;
      }
      
      private static int findSixthElement(int centuryPart)
      {
         return 0;
      }
      
      
      private static String findBirthdayString(int birthDayNumber)
      {
         if (birthDayNumber == 0)
            {
               return "Saturday";
            }
         else if (birthDayNumber == 1)
            {
               return "Sunday";
            }
         else if (birthDayNumber == 2)
            {
               return "Monday";
            }
         else if (birthDayNumber == 3)
            {
               return "Tuesday";
            }
         else if (birthDayNumber == 4)
            {
               return "Wednesday";
            }
         else if (birthDayNumber == 5)
            {
               return "Thursday";
            }
         else if (birthDayNumber == 6)
            {
               return "Friday";
            }
      }
      
      
   }
