/**
 *  This class will implement the martric using the sequence class
 *  Implementation details: matrix indices start at 0 for now
 * */
 
public  class Matrix extends Sequence {
   
    private MyInteger numRow, numCol;   // will contain matrix dimensions
    private Sequence matrix;            // the matrix itself
  
    // constructor for creating a matrix of specific number of rows and columns
    public Matrix(int rowsize, int colsize){
      
    if(rowsize <= 0 || colsize <= 0){
      System.out.println("Impossible matrix size entered. Exiting!");
      System.exit(1);
    }  
      numRow = new MyInteger(rowsize);
      numCol = new MyInteger(colsize);
      matrix = new Sequence();

        //   Below is the sequence of sequences, each index has a column
        //   [ [1 2 3] [1 2 3] [1 2 3] ]
      
      // create the matrix as a sequence of sequences
      // ex: matrix(3,2) = [[0 0] [0 0] [0 0]]
      for (int i = 0; i< numRow.Get() ; i++) {
          Sequence row = new Sequence(); 
          
          // Create all the column field for the ith row
          for (int j = 0; j<numCol.Get(); j++){
            row.add(new MyInteger(), j);
          }
          
          //Add a row to the matrix as the ith row
          matrix.add(row,i);
      }
    }
    
    
    public void Set(int rowsize, int colsize, int value){ // set the value of an element
      
      // exit if matrix indices are out of bound.
      if(rowsize > numRow.Get() -1 || colsize > numCol.Get() - 1){
        System.out.println("Matrix indices out of bound. Exiting!");
        System.exit(1);
      }
      
      Sequence row = (Sequence) matrix.index(rowsize);
      MyInteger col = (MyInteger) row.index(colsize);    // This must be an Integer since we are dealing with integer matrix
      
      //set the value at the location found by combination of row and col
      col.Set(value);
    
    }
    
    public int Get(int rowsize, int colsize){ // get the value of an element
      // exit if matrix indices are out of bound.
      if(rowsize > numRow.Get() -1 || colsize > numCol.Get() -1 ){
        System.out.println("Matrix indices out of bound. Exiting!");
        System.exit(1);
      }
      
      Sequence row = (Sequence) matrix.index(rowsize);
      MyInteger col = (MyInteger) row.index(colsize);    // This must be an Integer since we are dealing with integer matrix
      
      //get the value at the location found by combination of row and col
      return col.Get();
    
    
    }
    

    public Matrix Sum(Matrix mat){ // return the sum of two matrices: mat & this
      
      if(numRow.Get() != mat.numRow.Get() || numCol.Get() != mat.numCol.Get()){
        System.out.println("Matrix can't be summed. Size conflict. Exiting!");
        System.exit(1);
      }
      
      Matrix finalMatrix = new Matrix(numRow.Get(), numCol.Get());
      
      
      for (int i = 0; i< numRow.Get() ; i++ ){
        for(int j = 0; j< numCol.Get(); j++ ) {
        
         // has cell addition result
          int cellResult = Get(i,j) + mat.Get(i,j);
          
          //set value of sum at i,j location of result matrix
          finalMatrix.Set(i,j, cellResult);
          
        }
      }
      
     return finalMatrix;
    }
    
    
    public Matrix Product(Matrix mat){ // return the product of two matrices: mat & this
      
      if(this.numCol.Get() != mat.numRow.Get()){
        System.out.println("Matrix dimensions incompatible for Product");
        System.exit(1);
      }
      
      
      Matrix resultMat = new Matrix(this.numRow.Get(), mat.numCol.Get());
        
        for (int i = 0; i <this.numRow.Get(); i++){
          for (int j = 0; j< mat.numCol.Get(); j++) {
            
            MyInteger rTimesC = rowTimesCol(this,i,mat,j); // holds the result of ith row times jth column
            resultMat.Set(i, j, rTimesC.Get());

        }
      }
      return resultMat;
    }
    
    /**
     * This function will be used by Product function for Matrix product
     * It multipies the ith element in rowNum row by ith element in colNum col 
     *    of m2 matrix. It adds  the results of those multiplication and returns it.
     *    Here i is a value between 0 and numCol of m1 matrix.
     **/ 
    
    public MyInteger rowTimesCol(Matrix m1, int rowNum, Matrix m2, int colNum){
      
        MyInteger sum = new MyInteger();    // will keep track of sum of the multiplication results

        for(int i = 0; i< m1.numCol.Get(); i++) { 
          
          //get and sum the appropraite elements of two matrices
          sum.plus(m1.Get(rowNum,i) * m2.Get(i,colNum));  // Sum: +=
          
        }
        return sum;
    }
    
  
    
    public void Print() { // print the elements of matrix
      // Check the format of printing.
      for (int i = 0; i<this.numRow.Get(); i++) {
        
        matrix.index(i).Print();
        System.out.println();

      }
    
    }
}
  
  
