/*  Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  May 8, 2018
 *
 *  class TestArrayStringParser
 *  main() is in this file
 *
 */

import java.io.IOException;

 
public class TestArrayStringParser {
  
  public static void main(String[] args) throws IOException {
    ArrayStringParser asp = new ArrayStringParser(1000, 1000);
    String s = "";
    int[] p;
    
    System.out.println("\nTest 1: empty string");
    s = "";
    p = asp.parse(s);
    System.out.println("s = " + s.substring(0, Math.min(100, s.length())));
    System.out.println(Utils.arrayToString(p));
    
    System.out.println("\nTest 2: string with bad characters");
    s = " 100, - 5, 4, 3 3  2  1\n\r 946 1823 1 3 4 5 6982 29378 192 234 -9389 -4784- - - - ";
    p = asp.parse(s);
    System.out.println("s = " + s.substring(0, Math.min(100, s.length())));
    System.out.println(Utils.arrayToString(p));
    
    System.out.println("\nTest 3: one integer per line");
    s = Utils.fileToString(".\\input\\given-10000-asc.dat");
    p = asp.parse(s);
    System.out.println("s = " + s.substring(0, Math.min(100, s.length())));
    System.out.println(Utils.arrayToString(p));
    
    System.out.println("\nTest 4: tab separated");
    s = Utils.fileToString(".\\input\\given-05000-rev.dat");
    p = asp.parse(s);
    System.out.println("s = " + s.substring(0, Math.min(100, s.length())));
    System.out.println(Utils.arrayToString(p));
    
  }
  
}

