/*  Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  April 23, 2018
 *
 *  class LabApplication03
 *  main() is in this file
 *
 *
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
 
 
public class Lab03 {
  
  /* command line arguments
   * see flowerbox for main and populateVars for details
   */
  private static String fFreqPath = "";
  private static String fInPath = "";
  private static String fOutPath = "";
  private static String fFreqOutPath = "";
  private static boolean encode = true;
  private static String ties = "default";
  private static String version = "5";
  private static String fResultsPath = "results.txt";
  
  /* main method
   *
   *   arg 0 is frequency file path
   *   arg 1 is input file path
   *   arg 2 is output file path
   *   arg 3 is whether encoding or decoding
   *     "encode"
   *     "decode"
   *
   *   arg 4 is output file path for 
   *     freq file analysis
   *   
   *   optional arg 5 is to give tie-break method
   *     "default"
   *     "mirror"
   *
   * See populateVars, usageToStdErr, README and/or 
   *   analysis note for details
   *
   */  
  public static void main(String[] args) throws IOException {
    
    populateVars(args);
    
    String freqTable = fileToString(fFreqPath);
    String in = fileToString(fInPath);
    
    HuffmanLeafPile hlp = new HuffmanLeafPile(freqTable, ties);
    HuffmanTree ht = hlp.rakeUp();
    
    String out = "";
    if (encode) {
      out = ht.encode(in);
    } else {
      out = ht.decode(in);
    }
    
    stringToFile(ht.toDocumentation(), fFreqOutPath, false);
    stringToFile(out, fOutPath, false);
    
    System.out.println("\n\nProcessing complete.");
    System.out.println("  Output:    " + fOutPath);
    System.out.println("  Tree Doc:  " + fFreqOutPath);
    System.out.println("  nClear = " + ht.nClear);
    System.out.println("  nCoded = " + ht.nCoded);
    System.out.println("\n");
    
    // Output results to fixed-named file for copying to analysis
    out = "version\t" + version + 
            "\tmethod\t" + (encode ? "encode" : "decode") +
            "\tfInPath\t" + fInPath + 
            "\tfFreqPath\t" + fFreqPath + 
            "\tfOutPath\t" + fOutPath + 
            "\tfFreqOutPath\t" + fFreqOutPath + 
            "\tties\t" + ht.getTies() +
            "\tnClear\t" + ht.nClear + 
            "\tCoded\t" + ht.nCoded + "\n";
            
    stringToFile(out, fResultsPath, true);
    
  }
  
  private static String fileToString(String fPath) throws IOException {
    String out = "";
    try {
      out = new String(Files.readAllBytes(Paths.get(fPath)));
    } catch(Exception e) {
      IOExceptionToStdErr(e);
    } finally {}
    return out;
  }

  private static void stringToFile(String out, String fPath, boolean append) throws IOException {
    try {
      if (append) {
        Files.write(Paths.get(fPath), out.getBytes(), StandardOpenOption.APPEND);
      } else {
        Files.write(Paths.get(fPath), out.getBytes(), StandardOpenOption.CREATE);
      }
    } catch(Exception e) {
      IOExceptionToStdErr(e);
    } finally {} 
  }  
  
  private static void populateVars(String[] args) {
  
    int size = args.length;
    int n = 0;
  
    if (size < 5 || size > 6) {
      // Print usage and exit
      usageToStdErr();
      System.exit(1);
    }
  
    int m = args[3].charAt(0);
    
    if (m == 'E') m = 'e';
    if (m == 'D') m = 'd';
    if (m != 'e' && m != 'd') {
      System.err.println(
        "ERROR: arg4 must be 'encode' or 'decode' or an abbreviation.  arg4 = " + (char)m + "\n");
      usageToStdErr();
      System.exit(1);
    }
    
    fFreqPath = args[0];
    fInPath = args[1];
    fOutPath = args[2];
    fFreqOutPath = args[4];
    encode = (m == 'e');
    
    m = 'd';
    if (size == 6) {
      m = args[5].charAt(0);
      if (m == 'M') m = 'm';
      if (m == 'D') m = 'd';
      if (m != 'd' && m != 'm') {
        System.err.println(
          "ERROR: arg6 must be 'default', 'mirror', an abbreviation or missing.  arg6 = " + 
            (char)m + "\n");
        usageToStdErr();
        System.exit(1);
      }
    } 
    
    /**/// System.out.println("Determining tie-break method:");
    /**/// System.out.println("  m = " + m);
    /**/// System.out.println("  (char)m = " + (char)m);
    if (m == 'd') ties = "default";
    if (m == 'm') ties = "mirror";
    /**/// System.out.println("  ties = " + ties);
    
  }

  /* usageToStdErr
   *   A standard usage output for when input errors are present
   */
  private static void usageToStdErr() {
    System.err.println("Lab03 Huffman Encoding");
    System.err.println("Requires five command line arguments:");
    System.err.println("  freqPath      Path to freq file");
    System.err.println("  inPath        Path to input file");
    System.err.println("                Can be clear text");
    System.err.println("                Or already encoded");
    System.err.println("  outPath       Where to print the output");
    System.err.println("  method        Use 'encode' or 'decode'");
    System.err.println("                Can abbreviate");
    System.err.println("  freqOutPath   Where to write the analysis");
    System.err.println("                of the frequency file");
    System.err.println("  tie-break     (Optional)");
    System.err.println("                Use 'default' or 'mirror'");
    System.err.println("                Can abbreviate");
    System.err.println("");
    System.err.println("Examples:");
    System.err.println("  java -cp src\\ Lab03 input\\freq-0.txt input\\clear-0.txt   ");
    System.err.println("    output\\clear-0-out.txt e output\\freq-0-out.txt");
    System.err.println("");
    System.err.println("  java -cp src\\ Lab03 input\\freq-0.txt input\\encoded-0.txt ");
    System.err.println("    output\\encoded-0-out.txt d output\\freq-0-out.txt");
    System.err.println("");
    System.err.println("  java -cp src\\ Lab03 input\\freq-1.txt input\\clear-1.txt   ");
    System.err.println("    output\\clear-1-out.txt e output\\freq-1-out.txt mirror");
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

}

