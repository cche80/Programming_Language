// Pair class that is in the private member of map class
// ('key', element value)

    public class Pair {
        Pair next;  // an object reference to the next pair in map
        MyChar key; // key can only be MyChar
        Element val;// value object that can be any Element 

        // Constructor for the Pair class

        // Constructor 1: set the next pointer to null and initialize data
        public Pair (MyChar key, Element val) {
            this.next = null;
            this.key = key;
            this.val = val;
        }

        // Constructor 2: specify the next Node and initialize data.
        public Pair (Pair next, MyChar key, Element val) {
            this.next = next;
            this.key = key;
            this.val = val;
        }
        
        // A group of set and get methods for data and next;
        // Might be more than the program needs but just in case
        // next
        public Pair getNext() { return this.next; }
        public void setNext(Pair next) { this.next = next; }
        
        // key
        public MyChar getKey() { return this.key; }
        public void setKey(MyChar key) { this.key = key; }
        
        // val
        public Element getVal() { return this.val; }
        public void setVal(Element val) { this.val = val; }
        
        public void Print() {
            System.out.print("(");
            this.key.Print();
            System.out.print(" ");
            this.val.Print();
            System.out.print(")");
        }

        // Not used
        // public boolean equal(Pair other) {
        //    if(this.key == other.getKey() || this.val == other.getVal()) {
        //        return true;
        //   }
        //    else { return false; }
        //}
  }