package p9_package;
/**
 * Binary Search Tree (BST) class with self-balancing attributes
 * specifically using the Adelson-Velsky and Landis (AVL) strategy
 * 
 * @author Michael Leverington
 *
 */
public class AVL_TreeClass
   {
    /**
     * Null character returned if data not available
     */
    private final char NULL_CHAR = '\0';
   
    /**
     * Class global variable used to display tree structure
     */
    private boolean rowStartFlag;
   
    /**
     * Constant used to represent space
     * 
     */
    private static final char SPACE = ' ';
   
    /**
     * Constant used to represent dash
     * 
     */
    private static final char DASH = '-';
         
      /**
       * Binary Search Tree node class for managing
       * character data within an AVL Tree
       * 
       * @author MichaelL
       *
       */
      private class Node
         {
           /**
            * Character data for Node class
            */
           private char data;
           
           /**
            * left child reference for tree
            */
           private Node leftChildRef;
           
           /**
            * right child reference for tree
            */
           private Node rightChildRef;

           /**
            * Initialization constructor for Node class
            * 
            * @param inData char quantity
            */
           public Node( char inData )
              {
               data = inData;
               
               leftChildRef = null;
               
               rightChildRef = null;
              }

            /**
            * Initialization constructor for data
            * and child references
            * 
            * @param inData char quantity
            * 
            * @param leftRef reference for left child
            * 
            * @param rightRef reference for right child
            */
           public Node( char inData, Node leftRef, Node rightRef )
              {
               data = inData;
               
               leftChildRef = leftRef;
               
               rightChildRef = rightRef;
              }         

           /**
            * Copy constructor for AVL tree node
            * 
            * @param copied Node object to be copied
            */
           public Node( Node copied )
              {
               this( copied.data, null, null );
              }           
         }
      
      /**
       * Root of AVL Tree
       */
      private Node treeRoot;
      
      /**
       * Default class constructor
       */
      public AVL_TreeClass()
         {
          treeRoot = null;
          
          rowStartFlag = false;
         }
      
      /**
       * Copy constructor
       * 
       * @param copied AVL_TreeClass object to be copied
       */
      public AVL_TreeClass( AVL_TreeClass copied )
         {
          treeRoot = null;
          
          rowStartFlag = copied.rowStartFlag;
          
          if( copied.treeRoot != null )
             {
              treeRoot = copyConstructorHelper( copied.treeRoot );                           
             }
         }
      
      /**
       * clears tree
       */
      public void clearTree()
         {
          treeRoot = null;
         }
      
      /**
       * Recursive copy constructor helper
       * <p>
       * Note: Uses preorder strategy to copy nodes
       * 
       * @param wkgCopiedRef Node reference at which method starts
       * at each level of recursion
       * 
       * @return Node reference to link current node information
       * to methods/Nodes calling this method
       */
      private Node copyConstructorHelper( Node wkgCopiedRef )
         {
          Node wkgLocalNode = null;
         
          if( wkgCopiedRef != null )
             {          
              wkgLocalNode = new Node( wkgCopiedRef );
      
              // must create child references with new (local) node references
              wkgLocalNode.leftChildRef 
                       = copyConstructorHelper( wkgCopiedRef.leftChildRef );
      
              wkgLocalNode.rightChildRef 
                      = copyConstructorHelper( wkgCopiedRef.rightChildRef );
             }
                 
          return wkgLocalNode;
         }

      /**
       * Local recursive method to display a specified number
       * of a specified character
       * 
       * @param numChars number of characters to display
       * 
       * @param outChar character to display
       */
      private void displayChars( int numChars, char outChar )
         {
          if( numChars > 0 )
             {
              System.out.print( outChar );
              
              displayChars( numChars - 1, outChar );
             }
         }

      /**
       * provides tree height to user
       * <p>
       * Note: uses getTreeHeight
       * 
       * @return integer height of tree
       */
      public int findTreeHeight()
         {
          return getTreeHeight( treeRoot );
         }
      
      /**
       * gets balance factor indicating if tree
       * is unbalanced from given root down
       * 
       * @param wkgLocalRef Node from which balance factor is found
       * 
       * @return integer balance factor 
       */
      private int getBalanceFactor( Node wkgLocalRef )
         {
          if( wkgLocalRef == null )
             {
              return 0;
             }
          
          return getTreeHeight( wkgLocalRef.leftChildRef ) 
                             - getTreeHeight( wkgLocalRef.rightChildRef );
         }
      
      /**
       * Finds maximum of two given numbers
       * 
       * @param one one of two values to be tested
       * 
       * @param other other of two values to be tested
       * 
       * @return greater of the two values
       */
      private int getMax( int one, int other )
         {
          int max = one;
          
          if( other > max )
             {
              max = other;
             }
          
          return max;
         }
      
      /**
       * Tree height helper method
       * 
       * @param wkgLocalRef Node node from which height is found
       * 
       * @return integer height of tree
       */
      private int getTreeHeight( Node wkgLocalRef )
         {
          if( wkgLocalRef == null )
             {
              return -1;
             }
          
          return getMax( getTreeHeight( wkgLocalRef.leftChildRef ), 
                               getTreeHeight( wkgLocalRef.rightChildRef ) ) + 1;
         }
     
      /**
       * In order display of tree
       */
      public void inOrderDisplay()
         {
          inOrderDisplayHelper( treeRoot );
         }
      
      /**
       * Provides inOrder traversal action
       * 
       * @param wkgLocalRef Node tree root reference 
       * at the current recursion level
       */
      private void inOrderDisplayHelper( Node wkgLocalRef )
         {
          if( wkgLocalRef != null )
             {
             inOrderDisplayHelper( wkgLocalRef.leftChildRef );

              System.out.print( wkgLocalRef.data );
              System.out.print( SPACE );

              inOrderDisplayHelper( wkgLocalRef.rightChildRef );
             }
         }
      
      /** Insert method for AVL Tree
       * <p>
       * Note: uses insert helper method which returns
       * the root node reference to this method
       * 
       * @param inData char data to be added to AVL Tree
       */
      public void insert( char inData )
         {
          System.out.println( "Inserting " + inData + " and balancing");                 
          
          treeRoot = insertHelper( treeRoot, inData );
         }
      
      /**
       * Insert helper method for AVL Tree insert action
       * <p>
       * Note: Does not allow duplicate keys
       * 
       * @param wkgLocalRef Node tree root reference 
       * at the current recursion level
       * 
       * @param inData char item to be added to AVL Tree
       * 
       * @return Node reference to current AVL Tree root
       */
      private Node insertHelper( Node wkgLocalRef, char inData )
         {
          int balanceFactor;
          
          if( wkgLocalRef == null )
             {
              return new Node( inData ); 
             }
          
          if( inData < wkgLocalRef.data )
             {
              wkgLocalRef.leftChildRef = insertHelper( wkgLocalRef.leftChildRef, 
                                                                       inData );
             }
          
          else if( inData > wkgLocalRef.data )
             {
              wkgLocalRef.rightChildRef = insertHelper( wkgLocalRef.rightChildRef,  
                                                                       inData );
             }

          else
             {
              return wkgLocalRef;  // doesn't allow duplicate entries
             }
          
          balanceFactor = getBalanceFactor( wkgLocalRef );
          
          // left left case
          if( balanceFactor > 1 && inData < wkgLocalRef.leftChildRef.data )
             {
              displayChars( findTreeHeight(), SPACE );          
              System.out.println( "Identified: Left Left Case" );

              return rotateRight( wkgLocalRef );
             }
          
          // right right case
          if( balanceFactor < -1 && inData > wkgLocalRef.rightChildRef.data )
             {
              displayChars( findTreeHeight(), SPACE );          
              System.out.println( "Identified: Right Right Case" );
             
              return rotateLeft( wkgLocalRef );
             }
          
          // left right case
          if( balanceFactor > 1 && inData > wkgLocalRef.leftChildRef.data )
             {
              displayChars( findTreeHeight(), SPACE );          
              System.out.println( "Identified: Left Right Case" );
              
              wkgLocalRef.leftChildRef = rotateLeft( wkgLocalRef.leftChildRef );
              
              return rotateRight( wkgLocalRef );
             }
          
          // right left case
          if( balanceFactor < -1 && inData < wkgLocalRef.rightChildRef.data )
             {
              displayChars( findTreeHeight(), SPACE );          
              System.out.println( "Identified: Right Left Case" );
             
              wkgLocalRef.rightChildRef = rotateRight( wkgLocalRef.rightChildRef );
              
              return rotateLeft( wkgLocalRef );
             }
          
          return wkgLocalRef;  // doesn't allow duplicate entries      
         }
      
      /**
       * Test for empty tree
       * 
       * @return Boolean result of test
       */
      public boolean isEmpty()
         {
          return treeRoot == null;
         }

      /**
       * Rotates local tree left or CCW
       * 
       * @param wkgLocalRef reference of current item
       * 
       * @return Node resulting current root
       */
      private Node rotateLeft( Node wkgLocalRef )
         {
          Node rightChild = wkgLocalRef.rightChildRef;
          Node rightChildsLeftChild = rightChild.leftChildRef;
         
          displayChars( findTreeHeight() + 2, SPACE );
          System.out.println( "- Rotating Left" );
          
          rightChild.leftChildRef = wkgLocalRef;
          wkgLocalRef.rightChildRef = rightChildsLeftChild;
                    
          return rightChild;
         }

      /**
       * Rotates local tree right or CW   
       * 
       * @param wkgLocalRef reference of current item
       *
       * @return Node resulting current root
       */
      private Node rotateRight( Node wkgLocalRef )
         {
          Node leftChild = wkgLocalRef.leftChildRef;
          Node leftChildsRightChild = leftChild.rightChildRef;
          
          displayChars( findTreeHeight() + 2, SPACE );
          System.out.println( "- Rotating Right" );
          
          leftChild.rightChildRef = wkgLocalRef;
          wkgLocalRef.leftChildRef = leftChildsRightChild;
          
          return leftChild;
         }
      
      /** 
       * 
       * Searches for data in AVL Tree given char with necessary key
       * 
       * @param searchData char item containing key
       * 
       * @return char reference to found data
       */
      public char search( char searchData )
         {
          return searchHelper( treeRoot, searchData );
         }
      
      /**
       * Helper method for AVL Tree search action
       * 
       * @param wkgLocalRef Node tree root reference 
       * at the current recursion level
       * 
       * @param searchData char item containing key
       * 
       * @return char result of search
       */
      private char searchHelper( Node wkgLocalRef, char searchData )
         {
          if( wkgLocalRef != null )
             {
              if( searchData < wkgLocalRef.data )
                 {
                  return searchHelper( wkgLocalRef.leftChildRef, searchData );
                 }
              
              else if( searchData > wkgLocalRef.data )
                 {
                  return searchHelper( wkgLocalRef.rightChildRef, searchData );
                 }
              
              return wkgLocalRef.data;
             }
                    
          return NULL_CHAR;
         }
      
      /**
       * Local recursive method to calculate exponentiation
       * with integers
       * 
       * @param base base of exponentiation
       * 
       * @param exponent exponent of exponentiation
       * 
       * @return result of exponentiation calculation
       */
      private int toPower( int base, int exponent )
         {
          if( exponent > 0 )
             {
              return toPower( base, exponent - 1 ) * base;
             }
          
          return 1;
         }

      /**
       * [NOT ASSIGNED] Displays text-graphical representation of one level/line
       * of the AVL tree
       * 
       * @param workingNode node reference at current recursive level
       * 
       * @param nodeHeight height of tree plus two
       * for current height of nodes, including lowermost null children
       * 
       * @param displayLevel level of tree at which the current line
       * of display is to be presented
       * 
       * @param workingLevel current level during recursive actions
       */
      private void displayAtTreeLevel( Node workingNode, int nodeHeight, 
                                         int displayLevel, int workingLevel )
         {
          char charOut = workingNode.data;
          
          if( workingLevel == displayLevel )
             {
              displayValue( charOut, nodeHeight, workingLevel );
      
              return;
             }
          
          if( workingNode.leftChildRef != null )
             {
              displayAtTreeLevel( workingNode.leftChildRef, nodeHeight,
                                             displayLevel, workingLevel + 1 );
             }
          
          else
             {
              displayEmptyNodeSpaces( nodeHeight, displayLevel, workingLevel + 1 );
             }
              
          if( workingNode.rightChildRef != null )
             {
              displayAtTreeLevel( workingNode.rightChildRef, nodeHeight,
                          displayLevel, workingLevel + 1 );
             }
      
          else
             {
              displayEmptyNodeSpaces( nodeHeight, displayLevel, workingLevel + 1 );
             }              
         }

      /**
       * [NOT ASSIGNED] Method that displays null or blank nodes
       * for a tree at null locations
       * <p>
       * Note: used by displayAtTreeLevel
       * 
       * @param nodeHeight height of tree plus two
       * for current height of nodes, including lowermost null children
       * 
       * @param displayLevel level of the tree at which
       * the display will be applied
       * 
       * @param workingLevel level of tree just below
       * non-null node at which method is currently working
       */
      private void displayEmptyNodeSpaces( int nodeHeight, 
                                          int displayLevel, int workingLevel )
         {
          int nodesToDisplay = toPower( 2, displayLevel - workingLevel ); 
          char charOut = SPACE;
          
          if( displayLevel == workingLevel )
             {
              charOut = DASH;
             }
          
          while( nodesToDisplay > 0 )
             {
              displayValue( charOut, nodeHeight, displayLevel );
              
              nodesToDisplay--;
             }
         }

      /**
       * [NOT ASSIGNED] Displays text-graphical representation of AVL tree
       *  
       */
      public void displayTreeStructure()
         {
          int displayLevel, nodeHeight = getTreeHeight( treeRoot ) + 2;
          int workingLevel = 1;
          
          if( treeRoot != null )
             {
              for( displayLevel = 1; displayLevel <= nodeHeight; displayLevel++ )
                 {
                  rowStartFlag = true;
                  
                  displayAtTreeLevel( treeRoot, nodeHeight, 
                                               displayLevel, workingLevel );
                  
                  System.out.println();
                 }
             }
          
          else
             {
              System.out.println( "\nEmpty Tree - No Display");
             }
         }

      /**
       * [NOT ASSIGNED] Method used to display a character or color letter
       * along with calculated leading spaces
       * <p>
       * Note: used in displayAtTreeLevel and displayEmptyNodeSpaces
       * 
       * @param data data value to display, either letter or color data
       * 
       * @param nodeHeight height of tree plus two
       * for current height of nodes, including lowermost null children
       * 
       * @param workingLevel current level during recursive actions
       */
      private void displayValue( char data, int nodeHeight, int workingLevel )
         {
          int leadingSpaces;
          
          if( rowStartFlag )
             {
              leadingSpaces = toPower( 2, nodeHeight - workingLevel );
      
              rowStartFlag = false;
             }
          
          else
             {
              leadingSpaces = toPower( 2, nodeHeight - workingLevel + 1 ) - 1;
             }
      
          displayChars( leadingSpaces, SPACE );
          
          System.out.print( data );         
         }

   }

