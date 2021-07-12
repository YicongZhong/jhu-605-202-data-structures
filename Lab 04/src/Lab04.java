/*  Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  May 8, 2018
 *
 *  class Lab04
 *  main() is in this file
 *
 */

import java.io.IOException;

/*
 * Lab04 "Sort Comparison"
 * 
 *   Sorts arrays using a bunch of different methods
 *   Creates output files using a specific filename picture
 *   Also outputs timing metrics to a timings file
 *
 */
public class Lab04 {
  
  private static String fInPath = "";
  private static String fOutFolder = "";
  private static String fOutPre = "";
  private static String fTimingsPath = "";
  private static String label = "";
  
  private static String fOut = "";
  private static long duration = 0;
  private static String sortLabel = "";
  
  /* main method
   *
   *   arg 0    path to input file
   *   arg 1    output folder
   *   arg 2    prefix for output files (there will be five per input)
   *   arg 3    (optional) timings file
   *   arg 4    (optional) label for timings file
   *
   * See populateVars for details
   *
   */  
  public static void main(String[] args) throws IOException {
    populateVars(args);
    ArrayStringParser asp = new ArrayStringParser(1000, 1000);
    int[] nums = asp.parse(Utils.fileToString(fInPath));
    IntegerSorter sorter = null;
    String out = null;
    
    System.out.println("Sort Comparison...");
    System.out.println("  fInPath = " + fInPath);
    System.out.println("  fOutFolder = " + fOutFolder);
    System.out.println("  fOutPre = " + fOutPre);
    System.out.println("  fTimingsPath = " + fTimingsPath);
    System.out.println("  label = " + label);

    sorter = new IntegerSorter(nums);
    
    System.out.println("  nums.length = " + nums.length);

    
    // out = Utils.arrayToString(nums);
    // fOut = fOutFolder + "\\" + fOutPre + "-qa-2-1.dat";
    // System.out.println("  fOut = " + fOut);
    // Utils.stringToFile(out, fOut);
    
    
    // Quick sort method 1A
    //   Select the first item of the partition as the pivot. 
    //   Treat a partition of size one and two as a stopping case.
    sortLabel = "qa-2-1";
    sorter.quickSortIA(2, 1);
    out = Utils.arrayToString(sorter.x());
    fOut = fOutFolder + "\\" + fOutPre + "-" + sortLabel + ".dat";
    duration = sorter.lastTimedDuration();
    Utils.stringToFile(out, fOut);
    Utils.stringToFile(timingString(), fTimingsPath, true);
    
    // Quick sort method 2A
    //   Select the first item of the partition as the pivot. 
    //   Process down to a stopping case of a partition of size k = 100. 
    //   Use an insertion sort to finish.
    sortLabel = "qa-100-1";
    sorter.quickSortIA(100, 1);
    out = Utils.arrayToString(sorter.x());
    fOut = fOutFolder + "\\" + fOutPre + "-" + sortLabel + ".dat";
    duration = sorter.lastTimedDuration();
    Utils.stringToFile(out, fOut);
    Utils.stringToFile(timingString(), fTimingsPath, true);
    
    // Quick sort method 3A
    //   Select the first item of the partition as the pivot. 
    //   Process down to a stopping case of a partition of size k = 50. 
    //   Use an insertion sort to finish.
    sortLabel = "qa-50-1";
    sorter.quickSortIA(50, 1);
    out = Utils.arrayToString(sorter.x());
    fOut = fOutFolder + "\\" + fOutPre + "-" + sortLabel + ".dat";
    duration = sorter.lastTimedDuration();
    Utils.stringToFile(out, fOut);
    Utils.stringToFile(timingString(), fTimingsPath, true);
    
    // Quick sort method 4A
    //   Select the median-of-three as the pivot. 
    //   Treat a partition of size one and two as a stopping case.
    sortLabel = "qa-2-2";
    sorter.quickSortIA(2, 2);
    out = Utils.arrayToString(sorter.x());
    fOut = fOutFolder + "\\" + fOutPre + "-" + sortLabel + ".dat";
    duration = sorter.lastTimedDuration();
    Utils.stringToFile(out, fOut);
    Utils.stringToFile(timingString(), fTimingsPath, true);
    
    // Heap sort
    sortLabel = "heap";
    sorter.heapSort();
    out = Utils.arrayToString(sorter.x());
    fOut = fOutFolder + "\\" + fOutPre + "-" + sortLabel + ".dat";
    duration = sorter.lastTimedDuration();
    Utils.stringToFile(out, fOut);
    Utils.stringToFile(timingString(), fTimingsPath, true);

    // Quick sort method 1S
    //   Select the first item of the partition as the pivot. 
    //   Treat a partition of size one and two as a stopping case.
    sortLabel = "qs-2-1";
    sorter.quickSortIS(2, 1);
    out = Utils.arrayToString(sorter.x());
    fOut = fOutFolder + "\\" + fOutPre + "-" + sortLabel + ".dat";
    duration = sorter.lastTimedDuration();
    Utils.stringToFile(out, fOut);
    Utils.stringToFile(timingString(), fTimingsPath, true);
    
    // Quick sort method 2S
    //   Select the first item of the partition as the pivot. 
    //   Process down to a stopping case of a partition of size k = 100. 
    //   Use an insertion sort to finish.
    sortLabel = "qs-100-1";
    sorter.quickSortIS(100, 1);
    out = Utils.arrayToString(sorter.x());
    fOut = fOutFolder + "\\" + fOutPre + "-" + sortLabel + ".dat";
    duration = sorter.lastTimedDuration();
    Utils.stringToFile(out, fOut);
    Utils.stringToFile(timingString(), fTimingsPath, true);
    
    // Quick sort method 3S
    //   Select the first item of the partition as the pivot. 
    //   Process down to a stopping case of a partition of size k = 50. 
    //   Use an insertion sort to finish.
    sortLabel = "qs-50-1";
    sorter.quickSortIS(50, 1);
    out = Utils.arrayToString(sorter.x());
    fOut = fOutFolder + "\\" + fOutPre + "-" + sortLabel + ".dat";
    duration = sorter.lastTimedDuration();
    Utils.stringToFile(out, fOut);
    Utils.stringToFile(timingString(), fTimingsPath, true);
    
    // Quick sort method 4S
    //   Select the median-of-three as the pivot. 
    //   Treat a partition of size one and two as a stopping case.
    sortLabel = "qs-2-2";
    sorter.quickSortIS(2, 2);
    out = Utils.arrayToString(sorter.x());
    fOut = fOutFolder + "\\" + fOutPre + "-" + sortLabel + ".dat";
    duration = sorter.lastTimedDuration();
    Utils.stringToFile(out, fOut);
    Utils.stringToFile(timingString(), fTimingsPath, true);

    try {
      // Quick sort method 1R
      //   Select the first item of the partition as the pivot. 
      //   Treat a partition of size one and two as a stopping case.
      sortLabel = "qr-2-1";
      sorter.quickSortR(2, 1);
      out = Utils.arrayToString(sorter.x());
      fOut = fOutFolder + "\\" + fOutPre + "-" + sortLabel + ".dat";
      duration = sorter.lastTimedDuration();
      Utils.stringToFile(out, fOut);
      Utils.stringToFile(timingString(), fTimingsPath, true);
    } catch(Exception e) {
      System.err.println("ERROR: Recursion failed for input " + fInPath + ", method = " + sortLabel);
      System.err.println("       " + e);
    }
    
    try {
      // Quick sort method 2R
      //   Select the first item of the partition as the pivot. 
      //   Process down to a stopping case of a partition of size k = 100. 
      //   Use an insertion sort to finish.
      sortLabel = "qr-100-1";
      sorter.quickSortR(100, 1);
      out = Utils.arrayToString(sorter.x());
      fOut = fOutFolder + "\\" + fOutPre + "-" + sortLabel + ".dat";
      duration = sorter.lastTimedDuration();
      Utils.stringToFile(out, fOut);
      Utils.stringToFile(timingString(), fTimingsPath, true);
    } catch(Exception e) {
      System.err.println("ERROR: Recursion failed for input " + fInPath + ", method = " + sortLabel);
      System.err.println("       " + e);
    }
    
    try {
      // Quick sort method 3R
      //   Select the first item of the partition as the pivot. 
      //   Process down to a stopping case of a partition of size k = 50. 
      //   Use an insertion sort to finish.
      sortLabel = "qr-50-1";
      sorter.quickSortR(50, 1);
      out = Utils.arrayToString(sorter.x());
      fOut = fOutFolder + "\\" + fOutPre + "-" + sortLabel + ".dat";
      duration = sorter.lastTimedDuration();
      Utils.stringToFile(out, fOut);
      Utils.stringToFile(timingString(), fTimingsPath, true);
    } catch(Exception e) {
      System.err.println("ERROR: Recursion failed for input " + fInPath + ", method = " + sortLabel);
      System.err.println("       " + e);
    }
    
    try {
      // Quick sort method 4R
      //   Select the median-of-three as the pivot. 
      //   Treat a partition of size one and two as a stopping case.
      sortLabel = "qr-2-2";
      sorter.quickSortIS(2, 2);
      out = Utils.arrayToString(sorter.x());
      fOut = fOutFolder + "\\" + fOutPre + "-qr-2-2.dat";
      duration = sorter.lastTimedDuration();
      Utils.stringToFile(out, fOut);
      Utils.stringToFile(timingString(), fTimingsPath, true);
    } catch(Exception e) {
      System.err.println("ERROR: Recursion failed for input " + fInPath + ", method = " + sortLabel);
      System.err.println("       " + e);
    }
    

    
  }
  
  private static String timingString() {
    return "InputFile\t" + fInPath + "\tOutputFile\t" + fOut + "\tmethod\t" + sortLabel + "\tlabel\t" + label + "\tduration\t" + duration + "\n";
  }
  
  /* populateVars
   *
   *   Lab specific function to just isolate arg processing
   *   Keep main clean!
   *
   */
  private static void populateVars(String[] args) {
  
    int size = args.length;
    // String sLoops = "";
    // int iLoops = 1;
  
    if (size < 3 || size > 5) {
      System.err.println(
        "ERROR: incorrect number of arguments");
      usageToStdErr();
      System.exit(1);
    }
    
    fInPath       = args[0];
    fOutFolder    = args[1];
    fOutPre       = args[2];
    fTimingsPath  = (size <= 3) ? "timings.txt" : args[3];
    label         = (size <= 4) ? "" : args[4];
    // sLoops        = (size <= 5) ? "1" : args[5];
    
    // try {
    //   iLoops = Integer.valueOf(sLoops);
    //   if (iLoops < 1) throw new IOException("" + iLoops + " is less than 1, Dr. Watson!");
    // } catch(Exception e) {
    //   System.err.println(
    //     "ERROR: arg6 must be an integer greater than 0: \n    " + e + "\n");
    //   usageToStdErr();
    //   System.exit(1);
    // }
    
  }

  /* usageToStdErr
   *   A standard usage output for when input errors are present
   *   arg 0    path to input file
   *   arg 1    output folder
   *   arg 2    prefix for output files (there will be five per input)
   *   arg 3    (optional) timings file
   *   arg 4    (optional) label for timings file
   *
   * See populateVars for details
   */
   private static void usageToStdErr() {
    System.err.println("Lab04 Sort Comparison");
    System.err.println("Requires three command line arguments, three optional:");
    System.err.println("  inPath        File with whitepace delimited integers");
    System.err.println("  outFolder     Folder to save output files");
    System.err.println("  outPrefix     Prefix for output files -- will be five per call");
    System.err.println("  timingsFile   (optional) Path to timings file");
    System.err.println("  label         (optional) Label for use in timings file");
    System.err.println("");
    System.err.println("Examples:");
    System.err.println("  java -cp src\\ Lab04 input\\given-10000-ran.dat output\\ given-10000-ran");
    System.err.println("");
    System.err.println("  java -cp src\\ Lab04 input\\given-10000-ran.dat output\\ given-10000-ran timings.txt v1");
    System.err.println("");
    System.err.println("\n");
  }

}



