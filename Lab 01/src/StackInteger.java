/*	Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  February 18, 2018
 *
 *  class StackInteger 
 *    Uses an integer array to implement stack ADT
 *
 *  Unlike standard array implementation allows autoGrow
 *  Has two constructors, one default with no args
 *    another specifying the initial array size
 *    and whether autoGrow should be allowed
 *
 *  Class uses RuntimeExceptions
 *  But, should have its own class of exceptions:
 *    StackOverflowError
 *    StackUnderflowError
 *  These are TODOs
 *
 */
 
 
public class StackInteger {
  
  public static final int INIT_SIZE = 1000;
  
  // Position in the stack = array index of top element
  // pos = -1 means stack is empty
  private int pos;
  private int pstack[]; // p is silent :)
  private int origSize;
  private boolean allowAuto;
  
  // Constructor with defaults
  public StackInteger() {
    origSize = INIT_SIZE;
    pstack = new int[origSize];
    pos = -1;
    allowAuto = true;
  }
	
  // A custom constructor
  // Decide how big to make the initial array
  //   and whether to allow autoGrow
  public StackInteger(int n, boolean allowAutoGrow) throws RuntimeException {
    if (n < 1) {
      throw new RuntimeException("ERROR: trying to create a stack implemented as an empty array");
    }
    origSize = n;
    pstack = new int[origSize];
    pos = -1;
    allowAuto = allowAutoGrow;
  }
  
  public void push(int n) throws RuntimeException {
    if (pos + 1 >= pstack.length) {
      if (allowAuto) {
        this.autoGrow(origSize);
      } else {
        throw new RuntimeException("ERROR: stack overflow");
      }
    }
    pos++;
    pstack[pos] = n;
  }
  
  public int pop() {
    int r = pstack[pos];
    pstack[pos] = 0;
    pos--;
    return r;
  }
  
  public int peek() {
    return pstack[pos];
  }
  
  public boolean isEmpty() {
    return pos == -1;
  }
  
  
  // Output contents of stack
  // space delimited
  // top element on right
  public String toString() {
    
    if (pos < 0) return "Empty Stack";
    String r = "";
    
    for (int i = 0; i <= pos; i++) {
      r += pstack[i] + " ";
    }
    return r;
  }
  
  private int autoGrow(int n) {
    int temp[] = new int[pstack.length + n];
    for (int i = 0; i <= pos; i++) {
      temp[i] = pstack[i];
    }
    pstack = temp;
    return pstack.length;
  }
  
}

