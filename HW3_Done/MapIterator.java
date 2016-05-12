public class MapIterator {
    private Pair itr; //iterator
    
    //constructors
    public MapIterator() {
        this.itr = null;
    }
    
    public MapIterator(Pair itr) {
        this.itr = itr;
    }
    
    // 4 get functions to get the reference to pair/key/val
    public Pair getPair() { return this.itr; }
    
    // This is seesntially the same as getPair, for testing purpose.
    public Pair get() { return this.itr; }

    public MyChar getKey() {
        if (this.itr != null) {
            return this.itr.getKey();
        }
        else { return null; }
    }
    
    public Element getVal() { return this.itr.getVal(); }
    
    // equal function checks whether two pair references
    // are pointing to the same pair.
    public boolean equal(MapIterator other) {
        if ( this.itr == other.getPair() ) {
            return true;
        }
        else {
            return false;
        }
    }
    
    // return the reference to the next pair
    public Pair getNextPair() { return (itr.getNext()); }
    
    public MyChar getNextKey() { return (itr.getNext().getKey()); }
    
    public Element getNextVal() { return (itr.getNext().getVal()); }
    
    // refer to the next pair
    public MapIterator advance() {
        if (this.itr != null) {
            itr = itr.getNext(); //get itr's next pair using Getter
        }
        return this;
    }
};