
class Test {
  
  // Manual tests will be written here
  
  public static void main(String args[]){
    
    //------ Testing part 3 using simple cases --------------
    
    /*
    Sequence seq1 = new Sequence();
    Sequence seq2 = new Sequence();
    Sequence seq3 = new Sequence();
    
    
    MyChar char1 = new MyChar();
    char1.Set('y');
    
    MyChar char2 = new MyChar();
    char2.Set('g');
    
    seq1.add(new MyInteger(0),0);
    seq1.add(char1,1);
    seq1.add(seq2,2);
    
    seq2.add(new MyInteger(3),0);
    seq2.add(new MyInteger(4),1);
    seq2.add(seq3,2);
    
    seq3.add(char2,0);
    seq3.add(char1,1);
    
    System.out.print("seq1: ");
    seq1.Print();
    
    Sequence seq4 = seq1.flatten();
    
    System.out.println();
    System.out.print("seq4: ");
    seq4.Print();
    */
    
    //------------------Testing part 4 basic cases------------------------------
  
  
    
  
    Matrix m1 = new Matrix(1,3);
    

    m1.Set(0, 0,10);
    m1.Set(0,1,2);
    m1.Set(0,2,4);
    
    m1.Print();

    
    Matrix m2 = new Matrix(3,2);
    for (int i = 0; i<3; i++){
      for (int j = 0; j<2; j++){
        m2.Set(i,j,1);
      }
    }
    
    System.out.println();
    m2.Print();
    
    System.out.println("product is:");
    
    m1.Product(m2).Print();
    


    
  }
  
  
  
}