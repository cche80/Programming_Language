    // A Node class to be used as field in the Sequence class
    // It stores a local data and a pointer that points to the next Node (element)
    public class Node {
        Node next;  // an object reference to another Node
        Element elmt;

        // Constructor for the Node class

        // Constructor 1: set the next pointer to null and initialize data
        public Node (Element elmtInput) {
            next = null;
            elmt = elmtInput;
        }

        // Constructor 2: specify the next Node and initialize data.
        public Node (Element elmtInput, Node nextNode) {
            next = nextNode;
            elmt = elmtInput;
        }
        
      

        // A group of set and get methods for data and next;
        public Element getElmt() { return elmt; }
        public void setElmt(Element elmtInput) { elmt = elmtInput; }
        public Node getNext() { return next; }
        public void setNext(Node nextNode) { next = nextNode;}
        
    
      
  }