// package com.cc.hw3_tests;


public class Sequence extends Element {
    // Do NOT use Array
    // Should implement "linked list"
    // because we have to add things

    private Node head; // The first element in the sequence

    private int sequenceLength;

    // default constructor that creates an empty sequence
    public Sequence() {
        head = null;
        sequenceLength = 0;
    }

    // Customized constructor
    public Sequence(Node head, int sequenceLength) {
        this.head = head;
        this.sequenceLength = sequenceLength;
    }

    // Print() - print out everything in the sequence
    @Override
    public void Print() {
        System.out.print("[ ");
        Node nodeForPrint = head;
        while(nodeForPrint != null) {
            if(nodeForPrint.getElmt() != null) {
                nodeForPrint.getElmt().Print();
                System.out.print(" ");
            }

            nodeForPrint = nodeForPrint.getNext();
        }

        System.out.print("]");
    }

     // first() - get the first element of a Sequence
    public Element first() {
        return (head.getElmt());
    }
    // might contain char or int.

    // rest() - returns the sequence after the first element
    public Sequence rest() {
        Sequence restSequence = new Sequence(head.getNext(), sequenceLength-1);
        return restSequence;
        // TA said that it is possibly the hardest method?!?!
    }

    // length() - returns the length of the sequence
    public int length() {
      //traverse the whole list starting from the head
      int countSequenceLength = 0;
      Node accessNode = head;
      
      while (accessNode != null) {
        countSequenceLength++;
        accessNode = accessNode.getNext();
      }
      
      sequenceLength = countSequenceLength;
      return sequenceLength;
    }
    
    // add() - insert at position pos and SHIFT RIGHT
    public void add(Element elm, int pos) {
        this.length(); // Preventive measure, just in case someone changes rest()
        
        // Bound Checking
        if (pos < 0 || pos > sequenceLength) {
            System.err.println("position is not between 0 and " + sequenceLength + ".");
            System.exit(1);
        }

        // Case: pos == 0
        if (pos == 0) {
            head = new Node(elm, head);

            sequenceLength++;
        }

        else {
            // Other Cases:
            Node nodeB4Pos = head;  // Creates a new node to access node B4 pos
            // Starting with head
            for (int i = 0; i < (pos - 1); i++) { //get directly to pos
                nodeB4Pos = nodeB4Pos.getNext();
            }

            // e.g. When inserting to pos 2, we need the Node in pos 1, so that we can use pos 1
            // to point to the new node and use pos1.getNext() to assign the next of the new Node.

            // Create the new node pointing to the Node at pos
            Node newNode = new Node(elm, nodeB4Pos.getNext());
            // Change the next of the B4
            nodeB4Pos.setNext(newNode);

            sequenceLength++;
        }
    }




    public void delete(int pos) {
        this.length(); // Preventive measure, just in case someone change rest()
      
        if (pos == 0) { head = head.getNext(); sequenceLength--;}

        // Cases other than pos == 0
        if (pos > 0 && pos < sequenceLength) {
            Node nodeB4Pos = head;

            for (int i = 0; i < (pos - 1); i++) {
                nodeB4Pos = nodeB4Pos.getNext();
            } //get to the node before the node at 'pos'

            // Skip the Node that would be deleted and connect
            nodeB4Pos.setNext(nodeB4Pos.getNext().getNext());

            sequenceLength--;
        }
    }
    

    
    // Obtain the element at index position;
    //  if position out of bound, print the error and exit.
    public Element index(int pos) {
      if(pos<0 || pos > sequenceLength ){
        System.err.println("position " + pos + "out of bound");
        System.exit(1);
      }
      
      //indexedNode will reference the node at position pos
      Node indexedNode = this.head;
      for (int i = 1; i<= pos; i++) {
        indexedNode = indexedNode.getNext();
      }
      return indexedNode.getElmt();
      
    }
    
    
    
    // This will flatten a sequence
    // Ex. ([1 2 [1 3 [ [ ] ]  4] [ 's' a b [] ] ]) = [1 2 1 3 4 's' a b]
    // NOTE: the refernce to MyChar and MyInt are used in the new flattened Sequence
        // so if elements at those memory location are chaned by the original Sequence,
        //  the flattened sequence will automatically reflect that.
    
    public Sequence flatten() {
        Sequence currentSequence = this;
        Sequence flatSeq = new Sequence();
        
        MyInteger addAt = new MyInteger(0);
        flattenHelper(flatSeq,currentSequence, addAt);
        
        return flatSeq;
         
        
    }

    
    // This is a helper function for the recursive implementation of flatten() function
    // NOT FINISHED
    private void flattenHelper(Sequence flatSeq, Sequence currentSequence, MyInteger addAt ){
     
     
       // If this is an empty sequence, we don't need to do anything.
      if(currentSequence.sequenceLength == 0){
        return;
      }
      
     Node currentNode = currentSequence.head;
     
      for (int i = 0; i<currentSequence.sequenceLength; i++){
          
          Element currentNodeElement = currentNode.getElmt();
          
            // Check the type of the object and act accordingly
          if(currentNodeElement instanceof MyInteger) {
              flatSeq.add( currentNodeElement,addAt.Get());
              addAt.plusPlus();                 // increment by 1
              
          } 
          else if (currentNodeElement instanceof MyChar){
              flatSeq.add(currentNodeElement, addAt.Get() );
              addAt.plusPlus();
  
          }
          
          else if(currentNodeElement instanceof Sequence) {
              // call helper function to deal with this.
              // A recursive implemntation
              flattenHelper(flatSeq , (Sequence) currentNodeElement,addAt);
              
            
          }
          
          currentNode = currentNode.getNext(); // go thru the linked list according to the for loop
      
      }
    }
    
    
    // Performs deep copy using recursion and polymorphism
    public Sequence copy(){
        Sequence replicaSeq = new Sequence();
        MyInteger addAt = new MyInteger(0);  // will keep track of where to add
        
        
        Node currentNode = this.head;

        for(int i = 0; i<this.sequenceLength; i++){
          Element currentNodeElement = currentNode.getElmt();
          
          // The due to polymorphic behavior, the actual call to cop() will depend on
          //   whether currentNodeElement refers to a MyInteger, MyChar or Sequence.
          //   In the case of currentNodeElement = Sequence -> this funtion is called again recursively
          replicaSeq.add(currentNodeElement.copy(), addAt.Get());
          
          currentNode = currentNode.getNext();
          addAt.plusPlus();

          // copy the sequence.
        }
        
        
        return replicaSeq;
      
    }
    
    public SequenceIterator begin(){
        SequenceIterator begin_itr = new SequenceIterator(this.head);
        return begin_itr;
    }
    
    public SequenceIterator end(){
        SequenceIterator end_itr = new SequenceIterator( this.head );
        
        while(end_itr.get() != null){
            end_itr.advance();
        } // will finish when 'end' is on the special element, which is kept as null
        return end_itr;
    }
}
