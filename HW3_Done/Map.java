// Map class is modified from Sequence

public class Map {
    private Pair head;
    // ?????I don't think we need to keep track of the length right?
    
    // Default Constructor creates an empty map
    public Map() {
        this.head = new Pair(null, null);
    }
    
    // Might not need a second constructor.
    
    // Returns the first pair
    public MapIterator begin() {
        MapIterator begin_itr = new MapIterator(this.head);
        return begin_itr;
    }

    // Returns the ending dummy pair
    public MapIterator end() {
        MapIterator end_itr = new MapIterator( this.head );
        while(end_itr.getKey() != null && end_itr.getVal() != null) {
            end_itr.advance();
        } // will finish when 'end' is on the special element,
          // which is kept as null.
        return end_itr;
    }
    
    // Print
    public void Print() {
        System.out.print("[ ");
        Pair pairForPrint = head;
        while(pairForPrint != null) {
            // the following line of testing might not be necessary
            // In fact we just need to check whether the key of the pair is null
            // Since null key is already a sign for a dummy pair
            // But I still check for null val just in case of messing up
            if(pairForPrint.getKey() != null && pairForPrint.getVal() != null) {
                System.out.print("(");
                pairForPrint.getKey().Print();
                System.out.print(" ");
                pairForPrint.getVal().Print();
                System.out.print(") ");
            }

            pairForPrint = pairForPrint.getNext();
        }
        System.out.print("]");
    }
    
    // Add a pair
    public void add(Pair inval) {
        // the 2 cases that we are getting a new head
        // When the map is empty
        if ( ((this.head.getKey() == null && this.head.getVal() == null)) ||
        // When the head key is greater than inval key
        (this.head.getKey().Get() > inval.getKey().Get()) ) {
            inval.setNext(head);
            head = inval;
            return;
        }
        
        // the 2 cases that we need to insert the pair in the map
        for (MapIterator itr = this.begin(); !(itr.equal(this.end())); itr.advance()) {
            // if the next pair is a dummy pair
            // that means this inval has the greatest key vs all others
            if ( ((itr.getNextKey() == null &&
            itr.getNextVal() == null)) ||
            // the next pair has a key that is greater than that of inval
            // that means we should put inval after itr and before itr's next
            (itr.getNextKey().Get() > inval.getKey().Get()) ) {
                // The sequence of the following two lines are essential!
                // Applies to all linked list type of objects
                inval.setNext(itr.getNextPair());
                itr.getPair().setNext(inval);
                return;
            }
            // simply goes to the next itr if conditions are not met.
        }
    }
    
    // Find a pair with the key
    public MapIterator find(MyChar key) {
        for (MapIterator itr = this.begin(); !(itr.equal(this.end())); itr.advance()) {
            // Make sure you compare the DEEPEST element!! Anything above would be shallow compare!
            if (itr.getKey().Get() == key.Get()) { return (itr); }
        }
        return (this.end()); // This is arguable
                             // refer to the test case for detail
    }
    
}