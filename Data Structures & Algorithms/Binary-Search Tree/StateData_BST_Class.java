package p8_package;

/**
 * Binary Search Tree (BST) class for managing StateDataC;ass data
 * 
 * @author MichaelL
 */
public class StateData_BST_Class
   {
    /**
     * Traverse code - preorder
     */
    public static final int PRE_TRAVERSE = 101;
   
    /**
     * Traverse code - inorder
     */
    public static final int IN_TRAVERSE = 102;
   
    /**
     * Traverse code - postorder
     */
    public static final int POST_TRAVERSE = 103;

    /**
     * Root of tree
     */
    private StateDataClass rootNode;
    
    /**
     * Display counter
     */
    private int displayCounter;
    /**
     * Default class constructor, initializes BST
     */
    public StateData_BST_Class()
       {
        rootNode = null;
        
        displayCounter = 1;  
       }

    /**
     * Copy constructor
     * 
     * @param copied StateData_BST_Class reference to copied object
     */
    public StateData_BST_Class( StateData_BST_Class copied )
       {
        rootNode = copyConstructorHelper( copied.rootNode );
        
        displayCounter = 1;
       } 
    
    
    /**
     * Clears tree 
     */
    public void clearTree()
       {
        rootNode = null;
       }

    /**
     * Compares strings
     * <p>
     * If first string parameter is greater than the second,
     * method returns positive value; if first string parameter
     * is less than second, return negative value; if first
     * string parameter and second string parameter are equal,
     * returns zero
     * 
     * @param one first of two strings to compare
     * 
     * @param other second of two string to compare
     * 
     * @return integer value as specified
     */
    public int compareStrings( String one, String other )
       {
        int difference, index = 0;
        int strOneLen = one.length();
        int strOtherLen = other.length();
        
        while( index < strOneLen && index < strOtherLen )
           {
            difference = one.charAt( index ) - other.charAt( index );
            
            if( difference != 0 )
               {
                return difference;
               }
            
            index++;
           }
        
        return strOneLen - strOtherLen;
       }
    /**
     * Copy constructor helper
     * <p>
     * Recursively copies nodes using pre order traversal
     * 
     * @param wkgRef current working StudentDataClass reference in recursion
     * 
     * @return StateDataClass reference to link to StateDataClass node above
     * 
     */
    private StateDataClass copyConstructorHelper( StateDataClass wkgRef )
       {
        StateDataClass localRef = null;
        
        if( wkgRef != null )
           {
            localRef = new StateDataClass( wkgRef );
            
            localRef.leftChildRef 
                             = copyConstructorHelper( wkgRef.leftChildRef );
            
            localRef.rightChildRef 
                            = copyConstructorHelper( wkgRef.rightChildRef );            
           }
        
        return localRef;
       }
    
    /**
     * Provides inOrder traversal action using recursion
     * 
     * @param wkgRef StateDataClass tree root reference 
     * at the current recursion level
     */
    private void displayInOrder( StateDataClass wkgRef )
       {
        if( wkgRef != null )
           {
            displayInOrder( wkgRef.leftChildRef );
            System.out.format( "%2d: ", displayCounter );
            displayCounter++;
            System.out.println( wkgRef.toString() );
            displayInOrder( wkgRef.rightChildRef );
           }
       }
  
    /**
     * Provides postOrder traversal action using recursion
     * 
     * @param wkgRef StateDataClass tree root reference 
     * at the current recursion level
     */
    private void displayPostOrder( StateDataClass wkgRef )
       {
        if( wkgRef != null )
           {
            displayPostOrder( wkgRef.leftChildRef );
            displayPostOrder( wkgRef.rightChildRef );
            System.out.format( "%2d: ", displayCounter );
            displayCounter++;
            System.out.println( wkgRef.toString() );
           }
       }
    
    /**
     * Provides preOrder traversal action using recursion
     * 
     * @param wkgRef StateDataClass tree root reference 
     * at the current recursion level
     */
    private void displayPreOrder( StateDataClass wkgRef )
       {
        if( wkgRef != null )
           {
            System.out.format( "%2d: ", displayCounter );
            displayCounter++;
            System.out.println( wkgRef.toString() );
            displayPreOrder( wkgRef.leftChildRef );
            displayPreOrder( wkgRef.rightChildRef );
           }
       }
      
    /**
     * Provides user with three ways to display BST data
     * 
     * @param traverseCode integer code for selecting BST traversal method,
     * accepts PRE_TRAVERSE, IN_TRAVERSE, POST_TRAVERSE
     */
    public void displayTree( int traverseCode )
       {
        displayCounter = 1;
        
        switch( traverseCode )
           {
              case PRE_TRAVERSE:
                 displayPreOrder( rootNode );
                 break;
                 
              case POST_TRAVERSE:
                 displayPostOrder( rootNode );
                 break;
                 
              default:
                 displayInOrder( rootNode );
                 break;
           }
       }

    /** Insert method for BST
     * <p>
     * Note: calls the insert helper to implement 
     * all the data insertions
     * 
     * @param inData StateDataClas data to be added to BST
     */
    public void insert( StateDataClass inData )
       {
        rootNode = insertHelper( rootNode, inData );
       }
    
    /**
     * Recursive insert helper method for BST insert action
     * <p>
     * Adds new StateDataClass node to left or right 
     * of the current tree; if node is already in tree,
     * node is updated with the incoming data
     * 
     * @param wkgRef current working reference at the current recursion level
     * 
     * @param inData StateDataClass item to be added to BST
     * 
     * @return StateDataClass reference to current node insertion operation
     */
    private StateDataClass insertHelper( StateDataClass wkgRef, 
                                                         StateDataClass inData )
       {
        int comparisonValue;
        
        if( wkgRef != null )
           {
            comparisonValue = compareStrings( inData.state, wkgRef.state );
            
            if( comparisonValue  > 0 )
               {
                wkgRef.rightChildRef 
                                  = insertHelper( wkgRef.rightChildRef, inData );
               }
            
            else if( comparisonValue < 0 )
               {
                wkgRef.leftChildRef 
                                 = insertHelper( wkgRef.leftChildRef, inData );
               }
            
            else
               {
                wkgRef.setData( wkgRef );
               }
           }
       
        else
           {
            return new StateDataClass( inData );
           }
        
        return wkgRef;
       }
    
    /**
     * Test for empty tree
     * 
     * @return Boolean result of test
     */
    public boolean isEmpty()
       {
        return rootNode == null;
       }

    /**
     * Searches tree from given working reference to minimum value 
     * found below it in farthest left node,
     * stores data value found, unlinks the found node,
     * links the parent node's left node to the child's right node,
     * and returns the child/found node to the calling method
     * 
     * @param parentRef reference to current StateDataClass node
     * 
     * @param childRef reference to child StateDataClass node to be tested
     * and/or removed
     * 
     * @return StateDataClass reference containing removed StateDataClass node
     */
    private StateDataClass removeFromMin( StateDataClass parentRef,
                                                       StateDataClass childRef )
       {
        if( childRef.leftChildRef != null )
           {
            return removeFromMin( childRef, childRef.leftChildRef );
           }

        parentRef.leftChildRef = childRef.rightChildRef;
        
        return childRef;
       }
    
    /** 
     * Removes data StateDataClass node from tree using given key
     * <p>
     * Note: uses remove helper method
     * <p>
     * Note: uses search initially to get value, if it is in tree;
     * if value found, remove helper method is called, otherwise returns null
     * 
     * @param outData StateDataClass node that includes the necessary key
     * 
     * @return StateDataClass result of remove action
     */
    public StateDataClass removeItem( StateDataClass outData )
       {
        StateDataClass removedData = search( outData );
        
        if( removedData != null )
           {
            removedData = new StateDataClass( removedData );
            
            rootNode = removeItemHelper( rootNode, outData );
           } 
        
        return removedData;
       }
    
    /** 
     * Remove helper for BST remove action
     * <p>
     * Note: Recursive method returns updated local root to maintain
     * tree linkage
     * <p>
     * Note: uses removeFromMin method
     * 
     * @param wkgRef StateDataClass node reference 
     * at the current recursion level
     * 
     * @param outData StateDataClass item that includes the necessary key
     * 
     * @return StateDataClass reference result of remove helper action
     */
    private StateDataClass removeItemHelper( StateDataClass wkgRef, 
                                                        StateDataClass outData )
       {
        int compareResult;
        StateDataClass tempReplacementRef;
        
        compareResult = compareStrings( outData.state, wkgRef.state );
        
        if( compareResult > 0 )  
           {
           // not found, must be right
            wkgRef.rightChildRef 
                       = removeItemHelper( wkgRef.rightChildRef, outData );
           }
        
        else if( compareResult < 0 )  
           {
            // not found, must be left
            wkgRef.leftChildRef 
                      = removeItemHelper( wkgRef.leftChildRef, outData );
           }
        
        // found, test for no left child (or potentially no children)
        else if( wkgRef.leftChildRef == null )
           {
            wkgRef = wkgRef.rightChildRef;
           }
        
        // otherwise, test for no right child
        else if( wkgRef.rightChildRef == null )
           {
            wkgRef = wkgRef.leftChildRef;
           }
        
        // otherwise, found, has two children
        else
           {
            // check for right StateDataClass without left child
            if( wkgRef.rightChildRef.leftChildRef == null )
               {
                wkgRef.setData( wkgRef.rightChildRef );
                
                wkgRef.rightChildRef = wkgRef.rightChildRef.rightChildRef;
               }
            
            // right child has at least one left child
            else
               {
                tempReplacementRef 
                                = removeFromMin( wkgRef, wkgRef.rightChildRef );
            
                wkgRef.setData( tempReplacementRef );
               }
           }
        
        return wkgRef;
       }
    
    /** 
     * Searches for data in BST given StateDataClass referencewith necessary key
     * 
     * @param searchData StateDataClass reference containing key
     * 
     * @return StateDataClass reference to found data, or null if not found
     */
    public StateDataClass search( StateDataClass searchData )
       {
        return searchHelper( rootNode, searchData );
       }
    
    /**
     * Helper method for recursive BST search action
     * <p>
     *  
     * @param wkgRef StateDataClass tree node reference 
     * at the current recursion level
     * 
     * @param searchData StateDataClass reference containing key
     * 
     * @return StateDataClass item found, or null if not found
     */
    private StateDataClass searchHelper( StateDataClass wkgRef, 
                                                     StateDataClass searchData )
       {
        int compareResult;
        
        if( wkgRef != null )
           {
            compareResult = compareStrings( searchData.state, wkgRef.state );
            
            if( compareResult > 0 )
               {
                return searchHelper( wkgRef.rightChildRef, searchData );
               }
            
            else if( compareResult < 0 )
               {
                return searchHelper( wkgRef.leftChildRef, searchData );
               }
            
            // found - return data
            return wkgRef;
           }
                  
        return null;
       }
    
   }

