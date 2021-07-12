/*	Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  February 18, 2018
 *
 *  class TestStackInteger 
 *    Test StackInteger class
 *
 *  License: CC0
 *  https://creativecommons.org/publicdomain/zero/1.0/legalcode
 *
 */
 
 
public class TestStackInteger {
  
  public static void main(String args[]) {
    StackInteger s = new StackInteger();
    System.out.println(s.toString());
    
    s.push(1);
    System.out.println(s.toString());
    
    s.push(2);
    System.out.println(s.toString());
    
    s.pop();
    System.out.println(s.toString());
    
    s.peek();
    System.out.println(s.toString());
    
    s.isEmpty();
    System.out.println(s.toString());
    
    s.pop();
    System.out.println(s.toString());
    
    s.isEmpty();
    System.out.println(s.toString());
    
    
    StackInteger t = new StackInteger(2, true);
    System.out.println(t.toString());
    
    t.push(1);
    System.out.println(t.toString());
    
    t.push(2);
    System.out.println(t.toString());
    
    t.push(3);
    System.out.println(t.toString());
    
    t.push(4);
    System.out.println(t.toString());
    
    t.push(5);
    System.out.println(t.toString());
    
    // Test popping from stack
    System.out.println("Popped: " + t.pop());
    System.out.println("Popped: " + t.pop());
    System.out.println("Popped: " + t.pop());
    System.out.println("Popped: " + t.pop());
    System.out.println("Popped: " + t.pop());
    
    System.out.println(t.toString());
    
    System.out.println("Next pop will fail!");
    try {
      t.pop();
    } catch(Exception e) {
      System.out.println("Exception caught: " + e);
    }  
    
    System.out.println("Peek will fail!");
    try {
      t.peek();
    } catch(Exception e) {
      System.out.println("Exception caught: " + e);
    }
    
  }
    
}



 
