/*  Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  April 3, 2018
 *
 *  class PowersOfTwo
 *  main() is in this file
 *
 *
 */


public class PowersOfTwo {
  
  public static void main(String[] args) {
    
    long m;
    
    for (long i = 0; i < 50; i++) {
      
      m = ((long)1 << i);
      System.out.println("(1 << " + i + ") = " + Long.toBinaryString(m));
      
    }
  }
   
}



