public class MyInteger extends Element {
    private int val;

    public MyInteger() {val = 0;}
    public MyInteger(int x){val = x;}
    
    //copy constructor
    public MyInteger(MyInteger x) {
      this.val = x.val;
    }
    
    public int Get() {return val;}
    public void Set(int valInput) {this.val = valInput;}
    public void plusPlus(){
      this.val = this.val + 1;
    }

    @Override
    public void Print() {System.out.print(this.val);}
    
    
    //Copy function that will be used to make deep copy via polymorphism.
    public MyInteger copy(){
      MyInteger newInteger = new MyInteger(this.val);
      return newInteger;
    }
    
    // multiplies the result of two MyIntegers and returns it as a object of MyInteger
    public MyInteger mult(MyInteger integer){
      return new MyInteger(this.val * integer.val);
      
    }
    
    // adds the result of two MyIntegers and returns it as a object of MyInteger
    public MyInteger add(MyInteger integer){
      return new MyInteger(this.val + integer.val);
    } 
    
    // adds the result of two MyIntegers to THIS object and doesn't return anything

    public void plus(MyInteger integer){
      this.val += integer.val;
    }
    
    //adds the integer to THIS MyInteger and stores the result in THIS integer
    public void plus(int integer){
      this.val += integer;
    }
    
}

