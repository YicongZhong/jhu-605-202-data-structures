/*	Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  February 27, 2018
 *
 *  class SinglyLinkedNodeInteger 
 *    Use linked nodes to implement a singly-linked list of integers
 *
 *  License: CC0
 *  https://creativecommons.org/publicdomain/zero/1.0/legalcode
 *
 */
 
public class SinglyLinkedNodeInteger {
  private int d;
  private SinglyLinkedNodeInteger n;
  
  public SinglyLinkedNodeInteger(int data) {
    d = data;
    n = null;
    /**/// System.out.println("\nSinglyLinkedNodeInteger(int data)");
    /**/// System.out.println("    d = " + d);
    /**/// System.out.println("    n = " + (n == null ? "null" : n.data()));
    /**/// System.out.println("\n");
  }

  public SinglyLinkedNodeInteger(int data, SinglyLinkedNodeInteger next) {
    d = data;
    n = next;
    /**/// System.out.println("\nSinglyLinkedNodeInteger(int data, SinglyLinkedNodeInteger next)");
    /**/// System.out.println("    d = " + d);
    /**/// System.out.println("    n = " + (n == null ? "null" : n.data()));
    /**/// System.out.println("\n");
  }
  
  // Get 
  public int data() {
    return d;
  }
  
  // Set and return
  public int data(int data) {
    d = data;
    return d;
  }
  
  // Get 
  public SinglyLinkedNodeInteger next() {
    return n;
  }
  
  // Set and return
  public SinglyLinkedNodeInteger next(SinglyLinkedNodeInteger next) {
    n = next;
    return n;    
  }
  
  public void clear() {
    d = 0;
    n = null;
  }
  
  public String toString() {      
    String sd = "";
    String sn = "";
    sd = "data: " + d;
    if (n == null) {
      sn = "next: null";
    } else {
      sn = "next: " + n.data();
    }
    return sd + "; " + sn;
  }
  
}
 

