package package_5;

import javax.swing.JOptionPane;

public class ZellersCongruenceClass
   {
      private static final int DAYS_IN_WEEK = 7;
      private static final int MONTHS_IN_YEAR = 12;
      //I wasn't sure where to use this constant in my program.
      //private static final int THIRD_MONTH = 3;
      
      public static void main(java.lang.String[] args)
      {
       String monthStr;  
       String dayStr;
       String yearStr;
       String date;
       
       int monthInt, January = 1, February = 2;
       int dayInt;
       int yearInt; 
       int yearPart = 0;
       int centuryPart = 0;
       int solve = 0;
       int userBDay = 0;
       
       monthStr = JOptionPane.showInputDialog("Enter month of birth");
       dayStr = JOptionPane.showInputDialog("Enter day of birth");
       yearStr = JOptionPane.showInputDialog("Enter year of birth");
       
       monthInt = Integer.parseInt(monthStr);
       dayInt = Integer.parseInt(dayStr);
       yearInt = Integer.parseInt(yearStr);
       
       System.out.println("Birthday Program");
       System.out.println("=================\n");
       
       yearPart = yearInt % 100;
       centuryPart = yearInt / 100;
       
       if ((monthInt == January) || (monthInt == February))
          {
           monthInt = monthInt + MONTHS_IN_YEAR;
           yearPart -= 1;
          }
       
       
       solve = (dayInt + findSecondElement(monthInt) + yearPart + 
             findFourthElement(yearPart) + findFifthElement(centuryPart) + 
             findSixthElement(centuryPart));
       
       userBDay = (solve % DAYS_IN_WEEK);
       
       date = findBirthdayString(userBDay);
       
       System.out.println("For the date " + monthInt + "/" + dayInt + "/" 
             + yearInt + ", the person was born" + " on a " + date);
      }
      
      private static int findSecondElement(int month)
      {
         int answer;
         
         answer = (int) (Math.floor((13 * (month + 1) / 5)));

         return answer;
      }
      
      
      private static int findFourthElement(int yearPart)
      {
         int answer;
         
         answer = (int) (Math.floor((yearPart / 4)));
         
         return answer;
      }
      
      
      private static int findFifthElement(int centuryPart)
      {
         int answer;
         
         answer = (int) (Math.floor((centuryPart / 4)));
         
         return answer;
      }
      
      private static int findSixthElement(int centuryPart)
      {
         return (5 * centuryPart);
      }
      
      
      private static String findBirthdayString(int birthDayNumber)
      {
         
         String dayStr = "";

         if (birthDayNumber == 0)
            {
               dayStr = "Saturday";
            }
         else if (birthDayNumber == 1)
            {
               dayStr = "Sunday";
            }
         else if (birthDayNumber == 2)
            {
               dayStr = "Monday";
            }
         else if (birthDayNumber == 3)
            {
               dayStr = "Tuesday";
            }
         else if (birthDayNumber == 4)
            {
               dayStr = "Wednesday";
            }
         else if (birthDayNumber == 5)
            {
               dayStr = "Thursday";
            }
         else if (birthDayNumber == 6)
            {
               dayStr = "Friday";
            }
       return dayStr;
      }
      
      
   }
