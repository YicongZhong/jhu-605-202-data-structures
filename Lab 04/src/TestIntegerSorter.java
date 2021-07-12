/*  Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  May 8, 2018
 *
 *  class TestIntegerSorter
 *  main() is in this file
 *
 */

import java.io.IOException;
 
public class TestIntegerSorter {
  
  public static void main(String[] args) throws IOException {
    
    String sIn = Utils.fileToString("input\\given-00050-ran.dat");
    IntegerSorter sorter = null;
    ArrayStringParser asp = new ArrayStringParser(1000, 1000);
    // int[] a = asp.parse("5 6 1 10 3 2 4 8 9 7 45 1231 -87 0 12 74 2 -2 -5 -6 ");
    int[] a = asp.parse(sIn);
    
    
    sorter = new IntegerSorter(a);
    
    sorter.quickSortR(2, 2);
    sorter.resetTimer();
    
    
    sorter.quickSortIS(2, 2);
    sorter.resetTimer();
    
    
    sorter.quickSortIA(2, 2);
    sorter.resetTimer();
    
    
    sorter.heapSort();
    sorter.resetTimer();
    
    
    // To make sure that unary increment and decrement are diff in Java
    //   int i = 10;
    //   System.out.println("i = " + i);
    //   System.out.println("i++ = " + (i++));
    //   System.out.println("i = " + i);
    //   System.out.println("++i = " + (++i));
    //   System.out.println("i = " + i);
    
  }
  
}

