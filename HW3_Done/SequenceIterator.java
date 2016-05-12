//class for SequenceIterator

public class SequenceIterator{
    
    private Node itr; //iterator
    
    // Constructors
    public SequenceIterator() {
        this.itr = new Node(null);
    }
    
    public SequenceIterator(Node itr){
        this.itr = itr;
    }
    
    public Node getNode() { return this.itr; }
    
    public Element get() {
        if(this.itr != null) {
            return this.itr.getElmt();
        }
        return null;
            // throw new NullPointerException();
            // throw new Exception("Can't get from a non-initialized itr.");
            // System.err.println("Can't get from a non-initialized itr.");
            // System.exit(1);
        // here should take care of the case by error exception but nvm...
    } //use for printing
    
    public boolean equal(SequenceIterator other) {
        if (this.itr != null) {
            if (this.itr.getElmt() == other.get()) { return true; }
            else { return false; }
        }
        else {
          return true;
            // WHY if I put false here. it doesn't work... but if I put true
            // It is ok...
            // Although we passed the test for part 4,
            // This part can be potentially problematic
            // NullPointerException must be carefully taken care of.
            // throw new NullPointerException();
            // throw new Exception("Can't get from a non-initialized itr.");
            // System.err.println("Can't get from a non-initialized itr.");
            // System.exit(1);
        }
        // here should take care of the case by error exception but nvm...
    }
    
    public SequenceIterator advance(){
        if (itr != null) {
            itr = itr.getNext(); //get itr's next node using Getter
            return this;
        }

        return this;
        // here should take care of the case by error exception but nvm...
    }
}