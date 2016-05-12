/**
 * Created by CHEN on 10/30/2015.
 */
// an abstract class has abstract methods in it. abstract classes are INCOMPLETE!

abstract public class Element {
    abstract void Print();
    // sort of like virtue classes in C++
    
    // For polymorphisim
    abstract Element copy();
}

// later in the main() we cannot do:
// Element e = new Element;
