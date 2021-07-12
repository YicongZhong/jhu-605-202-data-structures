/*	Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  February 27, 2018
 *
 *  class SinglyLinkedListInteger 
 *    Test SinglyLinkedListInteger class
 *
 *  License: CC0
 *  https://creativecommons.org/publicdomain/zero/1.0/legalcode
 *
 */
 
 
public class SinglyLinkedListIntegerTest {
  
  public static void main(String args[]) {
    
        
    System.out.println("\n\nInitialize s, t, and u");
    System.out.println("SinglyLinkedNodeInteger s = new SinglyLinkedNodeInteger(5);");
    System.out.println("SinglyLinkedNodeInteger t = new SinglyLinkedNodeInteger(10, s);");
    System.out.println("SinglyLinkedNodeInteger u = new SinglyLinkedNodeInteger(20);");
    SinglyLinkedNodeInteger s = new SinglyLinkedNodeInteger(5);
    SinglyLinkedNodeInteger t = new SinglyLinkedNodeInteger(10, s);
    SinglyLinkedNodeInteger u = new SinglyLinkedNodeInteger(20);
    
    System.out.println("s.toString(): " + s.toString());
    System.out.println("t.toString(): " + t.toString());
    System.out.println("u.toString(): " + u.toString());
    System.out.println("s.data(): " + s.data());
    System.out.println("t.data(): " + t.data());
    System.out.println("u.data(): " + u.data());
    System.out.println("s.next(): " + s.next());
    System.out.println("t.next(): " + t.next());
    System.out.println("u.next(): " + u.next());
    
    System.out.println("\n\nSet s.data");
    System.out.println("s.data(2);");
    s.data(2);
    
    System.out.println("s.toString(): " + s.toString());
    System.out.println("t.toString(): " + t.toString());
    System.out.println("u.toString(): " + u.toString());
    System.out.println("s.data(): " + s.data());
    System.out.println("t.data(): " + t.data());
    System.out.println("u.data(): " + u.data());
    System.out.println("s.next(): " + s.next());
    System.out.println("t.next(): " + t.next());
    System.out.println("u.next(): " + u.next());
    
    System.out.println("\n\nRepoint u and t to s");
    System.out.println("u.next(s);");
    System.out.println("t.next(s);");
    u.next(s);
    t.next(s);
    
    System.out.println("s.toString(): " + s.toString());
    System.out.println("t.toString(): " + t.toString());
    System.out.println("u.toString(): " + u.toString());
    System.out.println("s.data(): " + s.data());
    System.out.println("t.data(): " + t.data());
    System.out.println("u.data(): " + u.data());
    System.out.println("s.next(): " + s.next());
    System.out.println("t.next(): " + t.next());
    System.out.println("u.next(): " + u.next());
    
    System.out.println("\n\nClear s");
    System.out.println("s.clear();");
    s.clear();
    
    System.out.println("s.toString(): " + s.toString());
    System.out.println("t.toString(): " + t.toString());
    System.out.println("u.toString(): " + u.toString());
    System.out.println("s.data(): " + s.data());
    System.out.println("t.data(): " + t.data());
    System.out.println("u.data(): " + u.data());
    System.out.println("s.next(): " + s.next());
    System.out.println("t.next(): " + t.next());
    System.out.println("u.next(): " + u.next());
    
    
    System.out.println("\n\nMake a chain");
    System.out.println("s.data(1);");
    System.out.println("t.data(2);");
    System.out.println("u.data(3);");
    System.out.println("s.next(t);");
    System.out.println("t.next(u);");
    System.out.println("u.next(null);");
    s.data(1);
    t.data(2);
    u.data(3);
    s.next(t);
    t.next(u);
    u.next(null);
    
    
    System.out.println("s.toString(): " + s.toString());
    System.out.println("t.toString(): " + t.toString());
    System.out.println("u.toString(): " + u.toString());
    System.out.println("s.data(): " + s.data());
    System.out.println("t.data(): " + t.data());
    System.out.println("u.data(): " + u.data());
    System.out.println("s.next(): " + s.next());
    System.out.println("t.next(): " + t.next());
    System.out.println("u.next(): " + u.next());
    
    

    // SinglyLinkedListInteger
    System.out.println("\n\nInitialize l");
    System.out.println("SinglyLinkedListInteger l = new SinglyLinkedListInteger();");
    SinglyLinkedListInteger l = new SinglyLinkedListInteger();
    System.out.println("l.toString():\n" + l.toString());
    
    System.out.println("\n\nInitialize m with node");
    System.out.println("SinglyLinkedListInteger m = new SinglyLinkedListInteger(u);");
    SinglyLinkedListInteger m = new SinglyLinkedListInteger(u);
    System.out.println("m.toString():\n" + m.toString());
    
    System.out.println("\n\nInitialize n with node");
    System.out.println("SinglyLinkedListInteger n = new SinglyLinkedListInteger(t);");
    SinglyLinkedListInteger n = new SinglyLinkedListInteger(t);
    System.out.println("n.toString():\n" + n.toString());
    
    System.out.println("\n\nInitialize p with node");
    System.out.println("SinglyLinkedListInteger p = new SinglyLinkedListInteger(s);");
    SinglyLinkedListInteger p = new SinglyLinkedListInteger(s);
    System.out.println("p.toString():\n" + p.toString());
    
    
    
    System.out.println("\n\nInsert into p");
    System.out.println("p.size(): " + p.size());
    System.out.println("p.insert(0, 1);");
    p.insert(0, 1);
    System.out.println("p.size(): " + p.size());
    System.out.println("p.toString():\n" + p.toString());
    
    System.out.println("\n\nInsert into p");
    System.out.println("p.size(): " + p.size());
    System.out.println("p.insert(9, 6);");
    p.insert(9, 6);
    System.out.println("p.size(): " + p.size());
    System.out.println("p.toString():\n" + p.toString());
    
    System.out.println("\n\nInsert into p");
    System.out.println("p.size(): " + p.size());
    System.out.println("p.insert(-1, 2);");
    p.insert(-1, 2);
    System.out.println("p.size(): " + p.size());
    System.out.println("p.toString():\n" + p.toString());
    
    
    
    System.out.println("\n\nDelete from p");
    System.out.println("p.size(): " + p.size());
    System.out.println("p.delete(2): " + p.delete(2));
    System.out.println("p.size(): " + p.size());
    System.out.println("p.toString():\n" + p.toString());
    
    System.out.println("\n\nDelete from p");
    System.out.println("p.size(): " + p.size());
    System.out.println("p.delete(10): " + p.delete(10));
    System.out.println("p.size(): " + p.size());
    System.out.println("p.toString():\n" + p.toString());
    
    System.out.println("\n\nDelete from p");
    System.out.println("p.size(): " + p.size());
    System.out.println("p.delete(4): " + p.delete(4));
    System.out.println("p.size(): " + p.size());
    System.out.println("p.toString():\n" + p.toString());
    
    System.out.println("\n\nDelete from p");
    System.out.println("p.size(): " + p.size());
    System.out.println("p.delete(1): " + p.delete(1));
    System.out.println("p.size(): " + p.size());
    System.out.println("p.toString():\n" + p.toString());
    
    System.out.println("\n\nDelete from p");
    System.out.println("p.size(): " + p.size());
    System.out.println("p.delete(1): " + p.delete(1));
    System.out.println("p.size(): " + p.size());
    System.out.println("p.toString():\n" + p.toString());
    
    System.out.println("\n\nDelete from p");
    System.out.println("p.size(): " + p.size());
    System.out.println("p.delete(1): " + p.delete(1));
    System.out.println("p.size(): " + p.size());
    System.out.println("p.toString():\n" + p.toString());
    
    System.out.println("\n\nDelete from p");
    System.out.println("p.size(): " + p.size());
    System.out.println("p.delete(1): " + p.delete(1));
    System.out.println("p.size(): " + p.size());
    System.out.println("p.toString():\n" + p.toString());
    
  }
    
}



 
