/*  Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  April 3, 2018
 *
 *  class Lab02
 *  main() is in this file
 *
 *  File I/O code is based on example from Dr. Erhan Guven
 *  https://blackboard.jhu.edu/webapps/blackboard/content/
 *    listContent.jsp?course_id=_154611_1&content_id=_5182936_1
 *
 *  Timing method from
 *    https://docs.oracle.com/javase/7/docs/api/java/lang/System.html#nanoTime()
 *
 */


import java.io.FileWriter;
import java.io.IOException;


/* 
 * Lab02 "Towers of Hanoi" application
 *
 *   Creates a cheatsheet to help solve the 
 *   "Towers of Hanoi" puzzle for n disks
 */
public class Lab02 {
  
  private static String version = "1.1";
  private static int disks = 0;
  private static boolean recursive = true;
  private static String fOutPath = "";
  private static String fTimingsPath = "output\\timings.txt";
  private static FileWriter fOut = null;
  private static FileWriter fTimings = null;
  private static final int MAX_DISKS = 50;
  
  
  
  /* main method
   *
   *   arg 0 is an integer, the number of disks
   *   arg 1 is the name of the output file
   *   arg 2 is whether to run interative or recursive
   *     0 = iterative
   *     1 = recursive
   *   arg 3 is an optional file to put timings in 
   *     if not supplied output/timings.txt is used
   *
   * See populateVars for details
   *
   */
  public static void main(String[] args) throws 
      IOException, NumberFormatException {
    
    populateVars(args);
    
    try {
      fOut = new FileWriter(fOutPath);
      fTimings = new FileWriter(fTimingsPath, true);  // open for append
      
      // Write the header of the cheatsheet
      fOut.write("==========================================\n");
      fOut.write("Cheatsheet for solving Towers of Hanoi\n");
      fOut.write("With n = " + disks + " disks\n");
      fOut.write("Program version: " + version + ", " + 
          (recursive ? "recursive" : "iterative") + "\n");
      fOut.write("Time to create shown at end of file\n");
      fOut.write("==========================================\n\n");
      
      
      
      long start_nano = System.nanoTime();    
      if (recursive) {
        hanoiRecursive(disks, 1, 3);
      } else {
        hanoiIterative(disks, 1, 3);
      }
      long duration_nano = System.nanoTime() - start_nano;
      
      
      // This is the end matter of the cheatsheet
      //   including the time to execute
      fOut.write("\n");
      fOut.write("==========================================\n");
      fOut.write("Time to create: " + duration_nano + " nanoseconds\n");
      fOut.write("                " + 
          ((double)(duration_nano) / 1000000000.0) + " seconds\n");
      fOut.write("==========================================\n\n");
      
      // Write the execution time with enough info
      //   to be able to identify it later!
      fTimings.write("disks\t" + disks + "\tmethod\t" + 
          (recursive ? "recursive" : "iterative") + "\tversion\t" + 
          version + "\tduration\t" + duration_nano + "\n");
    
    } catch(Exception e) {
      IOExceptionToStdErr(e);
    } finally {
      if (fOut != null) fOut.close();
      if (fTimings != null) fTimings.close();
    }
  }
  

  
  /* Recursively create a cheatsheet
   *   to solve the "Towers of Hanoi" puzzle
   *   
   *   n        the number of disks in the puzzle
   *   sPeg     "source peg"
   *            the one with the (sub-)tower we are moving
   *   tPeg     "target peg"
   *            where we want to move the (sub-)tower
   *
   * Pegs are expressed as integers: 1, 2, 3
   *   this gets converted in moveString to A, B, and C
   *   for display in the cheatsheet
   *
   * fPeg = "free peg"
   *   use this as the staging peg, calc from other two
   * 
   */
  private static void hanoiRecursive (
        int n, int sPeg, int tPeg) 
        throws IOException, RuntimeException {
    
    if (n < 1) throw new RuntimeException(
          "ERROR: n must be greater than 0");
    
    if (sPeg == tPeg) throw new RuntimeException(
          "ERROR: source peg cannot be the same as target peg");
    
    if (sPeg < 1 || sPeg > 3 || 
        tPeg < 1 || tPeg > 3) throw new RuntimeException(
          "ERROR: pegs must be 1, 2, or 3");
    
    int fPeg = 0;
    
    for (int i = 1; i < 4; i++) {
      if (sPeg != i && tPeg != i) {
        fPeg = i;
        break;
      }
    }
    if (n > 1) {
      hanoiRecursive(n - 1, sPeg, fPeg);
      fOut.write(moveString(n, sPeg, tPeg) + "\n");
      hanoiRecursive(n - 1, fPeg, tPeg);
    } else {
      fOut.write(moveString(n, sPeg, tPeg) + "\n");
    }
    
  }
  
  
  
  /* Iteratively create a cheatsheet
   *   to solve the "Towers of Hanoi" puzzle
   *   
   *   n        the number of disks in the puzzle
   *   sPeg     "source peg"
   *            the one with the (sub-)tower we are moving
   *   tPeg     "target peg"
   *            where we want to move the (sub-)tower
   *
   * Pegs are expressed as integers: 1, 2, 3
   *   this gets converted in moveString to A, B, and C
   *   for display in the cheatsheet
   *
   * fPeg = "free peg"
   *   use this as the staging peg, calc from other two
   * 
   */
  private static void hanoiIterative (
        int n, int sPeg, int tPeg) 
        throws IOException, RuntimeException {
    
    if (sPeg == tPeg) throw new RuntimeException(
          "ERROR: source peg cannot be the same as target peg");
    
    if (n < 1) throw new RuntimeException(
          "ERROR: n must be greater than 0");
    
    if (n > MAX_DISKS) throw new RuntimeException(
          "ERROR: n cannot be greater than " + MAX_DISKS + "");
    
    if (sPeg < 1 || sPeg > 3 || 
        tPeg < 1 || tPeg > 3) throw new RuntimeException(
          "ERROR: pegs must be 1, 2, or 3");
    
    int fPeg = 0;
    for (int i = 1; i < 4; i++) {
      if (sPeg != i && tPeg != i) {
        fPeg = i;
        break;
      }
    }
    
    // This routine treats every puzzle as 
    // starting on peg 1 and ending on peg 3
    // Names are assigned based on sPeg, tPeg, fPeg
    // so that the instructions conform to what the 
    // user has requested
    
    // Names for the pegs, 
    //   since target and source are args
    int pegs[] = new int[3];
    pegs[0] = sPeg;
    pegs[1] = fPeg;
    pegs[2] = tPeg;
    
    // Please see DOCX file for details about method used here
    long m = ((long)1 << n) - 1;   // number of moves
    System.out.println(Long.toBinaryString(m));
    
    int d = 0;               // zero-indexed disk to move
    int pos[] = new int[n];  // array of curr positions of disks
    int from = 0;            // peg moving from 
    int to = 0;              // peg moving to
    int ppar = 0;            // the parity of the puzzle
    int dpar = 0;            // the parity of the disk to move
    
    for (int i = 0; i < n; i++) {
      pos[i] = 0;
    }
    
    if (n % 2 == 0) {
      ppar = 1;
    } else {
      ppar = -1;
    }
    
    for (long i = 1; i <= m; i++) {
      d = Long.numberOfTrailingZeros(i);
      dpar = (d % 2) == 0 ? 1 : -1;
      from = pos[d];
      to = (from + 3 + dpar * ppar) % 3;
      pos[d] = to;
      fOut.write(
        moveString(d + 1, pegs[from], pegs[to]) + "\n");
    }
    
  }
  
  
  
  /* method to separate arg checking from interesting stuff
   *   args[0] is an integer
   *   args[1] is the name of the output file 
   *   args[2] is whether to run interative or recursive
   */
  private static void populateVars(String[] args) {
    
    int size = args.length;
    int n = 0;
    
    if (size < 3) {
      // Print usage and exit
      usageToStdErr();
      System.exit(1);
    }
    
    try {
      n = Integer.valueOf(args[0]);
    } catch(Exception e) {
      System.err.println(
        "ERROR: arg1 must be an integer greater than 0: \n" + e + "\n");
      usageToStdErr();
      System.exit(1);
    }
    
    if (n < 1) {
      System.err.println(
        "ERROR: arg1 must be an integer greater than 0\n");
      usageToStdErr();
      System.exit(1);
    }
    
    if (n > MAX_DISKS) {
      System.err.println(
        "ERROR: arg1 is just way too big.\n");  
      usageToStdErr();
      System.exit(1);
    }
    
    disks = n;
    fOutPath = args[1];
    
    if (args[2].equals("1")) {
      recursive = true;
    } else if (args[2].equals("0")) {
      recursive = false;
    } else {
      System.err.println(
        "ERROR: arg3 must be 0 or 1.  arg3 = " + args[2] + "\n");
      usageToStdErr();
      System.exit(1);
    }
    
    if (size == 4) fTimingsPath = args[3];
    
  }  
  
  
  /* moveString
   *   encapsulate the move strings in to one place
   *   keep things tidy!
   */
  private static String moveString(int disk, int fPeg, int tPeg) {
    return "Move disk " + disk + " from tower " + 
             (char)(64 + fPeg) + " to tower " + (char)(64 + tPeg);
  }

  
  /* usageToStdErr
   *   A standard usage output for when input errors are present
   */
  private static void usageToStdErr() {
    System.err.println("Lab02 Towers of Hanoi");
    System.err.println("Requires three command line arguments:");
    System.err.println("  n          an integer between 1 and " + MAX_DISKS + "");
    System.err.println("  out        filename to put the output");
    System.err.println("  recursive  0 or 1");
    System.err.println("             1 runs recursive method");
    System.err.println("             0 runs iterative");
    System.err.println("  timings    (optional) file to append timings to");
    System.err.println("             if not passed will use 'output\\timings.txt'");
    System.err.println("Examples:");
    System.err.println("  java -cp src\\ Lab02 5 output\\tower-5r.txt 1");
    System.err.println("  java -cp src\\ Lab02 8 output\\tower-8i.txt 0");
    System.err.println("  java -cp src\\ Lab02 4 output\\tower-8i.txt 1 time.txt");
    System.err.println("\n");
  }
  
  
  private static void IOExceptionToStdErr(Exception e) {
    System.err.println("ERROR: An IOException has occurred: " + e);
    System.err.println('\n');
    System.err.println("     Contact Adam Rich for assistance");
    System.err.println("     adamleerich@gmail.com");
    System.err.println("     +1 860 839 9778");
    System.err.println('\n');
  }

  
  
}  // end Class Lab02



