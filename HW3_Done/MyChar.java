/**
 * Created by CHEN on 10/30/2015.
 */
public class MyChar extends Element {
    private char c;

    public MyChar() {c = '0';}
    
    //copy constructor
    public MyChar(MyChar x) {
      this.c = x.c;
    }
    
    public char Get() {return this.c;}
    public void Set (char charInput) {
      this.c = charInput;
      
    }

    @Override
    public void Print() {System.out.print("'" + this.c + "'");}
    
    //Copy function that will be used for deep copy via polymorphism
    public MyChar copy(){

      return new MyChar(this);
  
    }
}