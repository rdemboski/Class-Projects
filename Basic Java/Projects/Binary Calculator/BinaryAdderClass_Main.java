package p9_project;

public class BinaryAdderClass_Main
   {
    public static final char DOUBLE_DASH = '=';
    
    public static void main(String[] args)
       {
        int firstValue = 98;
        int secondValue = 89;
        int width = 12;
        String tempStr;
       
        BinaryAdderClass binValOne = new BinaryAdderClass( firstValue );
        BinaryAdderClass binValTwo = new BinaryAdderClass( secondValue );
        BinaryAdderClass binValSum = new BinaryAdderClass( binValOne );
       
        binValSum.addValue( binValTwo );
       
        binValOne.displayBits( width );
       
        System.out.print( "  +" );
       
        binValTwo.displayBits( width - 3 );
       
        binValTwo.displayChars( width, DOUBLE_DASH );
        System.out.println();
        
        binValSum.displayBits( width );
       
        tempStr = binValSum.toString();
       
        System.out.println( "\nTo String: " + tempStr );
      }

   }
