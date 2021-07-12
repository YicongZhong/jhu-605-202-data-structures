/*	Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  February 27, 2018
 *
 *  class SinglyLinkedListInteger 
 *    Use linked nodes to implement a singly-linked list of integers
 *
 *  License: CC0
 *  https://creativecommons.org/publicdomain/zero/1.0/legalcode
 *
 */
 
public class SinglyLinkedListInteger {
  
  private SinglyLinkedNodeInteger h;
  private int psize = 0;
  
  public SinglyLinkedListInteger() {}
  
  public SinglyLinkedListInteger(SinglyLinkedNodeInteger node) {
    h = node;
    psize = this.calcSize();
  }
  
  public int size() {
    return psize;
  }
  
  public boolean isEmpty() {
    return (h == null);
  }
  
  public String toString() {
    String s = "";
    if (psize > 0) {
      SinglyLinkedNodeInteger node = h;
      for (int i = 1; i <= psize; i++) {
        s += i + ": " + node + "\n";
        node = node.next();
      }
      return s;
    } else {
      return "List is null";
    }
  }
  
  public void insert(int value, int rank) {
    
    if (rank != psize + 1 && !validNode(rank)) {
      // TODO raise error
      return;
    }
    
    SinglyLinkedNodeInteger gnew = new SinglyLinkedNodeInteger(value);
    
    if (rank == 1) {
      gnew.next(h);
      h = gnew;
      psize++;
      return;
    }
    
    SinglyLinkedNodeInteger pre = this.ptrTo(rank - 1);
    gnew.next(pre.next());
    pre.next(gnew);
    psize++;
    return;
    
  }
  
  public int delete(int rank) {
    
    if (!this.validNode(rank)) {
      // TODO raise error
      return 0;
    }
    
    SinglyLinkedNodeInteger node;
    SinglyLinkedNodeInteger pre;
    int r;
    
    if (rank > 1) {
      pre = this.ptrTo(rank - 1);
      node = pre.next();
      pre.next(node.next());
    } else {
      node = h;
      h = node.next();
    }
    
    r = node.data();
    node.clear();
    psize--;
    return r;
    
  }
  
  private int calcSize() {
    SinglyLinkedNodeInteger node = h;
    int s = 0;
    while (node != null) {
      s++;
      node = node.next();
    }
    return s;
  }
  
  // TODO copy method
  
  private boolean validNode(int rank) {
    return ((rank > 0) && (rank <= psize));
  }
  
  private SinglyLinkedNodeInteger ptrTo(int rank) {
    if (this.validNode(rank)) {
      SinglyLinkedNodeInteger node = h;
      for (int i = 1; i < rank; i++) {
        node = node.next();
      }
      return node;
    } else {
      return null;
    }
  }
  
	
  
}

