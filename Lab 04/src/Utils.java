/*  Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  May 8, 2018
 *
 *  class Utils
 *
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Utils {
  
  public static String arrayToString(int[] nums) {
    String out = arrayToString(nums, "\n", false, false);
    // /**/// System.out.println("arrayToString without args");
    // /**/// System.out.println("  nums.length = " + nums.length);
    // /**/// System.out.println("  out = " + out);
    return out;
  }
  
  public static String arrayToString(int[] nums, String sep, boolean wrap, boolean label) {
    String out = "";
    
    if (nums.length == 0) {
      out += "\nEmpty";
      return out;
    }
    
    for (int i = 0; i < nums.length; i++) {
      if (wrap) {
        if (i % 10 == 0) {
          if (label) {
            out += "\n[" + (i+1) + "] ";    
          } else {
            out += "\n";    
          }
        }
      }
      
      out += nums[i] + sep;
    }
    // /**/// System.out.println("arrayToString with args");
    // /**/// System.out.println("  nums.length = " + nums.length);
    // /**/// System.out.println("  out = " + out);
    return out;
  }

  /* fileToString
   *
   *   Convenience function just to quickly 
   *   get all the contents of a text file
   */
  public static String fileToString(String fPath) throws IOException {
    String out = "";
    try {
      out = new String(Files.readAllBytes(Paths.get(fPath)));
    } catch(Exception e) {
      IOExceptionToStdErr(e);
    } finally {}
    return out;
  }

  /* stringToFile
   *
   *   Convenience function just to quickly 
   *   write a string to a file
   *  
   *   append = true will not overwrite and existing file, but just append "out"
   *   append = false will create a new file or overwrite if present
   *
   */
  public static void stringToFile(String out, String fPath, boolean append) throws IOException {
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

  /* stringToFile(append = false, ...) */
  public static void stringToFile(String out, String fPath) throws IOException {
    stringToFile(out, fPath, false);
  }  
  
  /* IOExceptionToStdErr
   *   Generic function with developer contact info
   */
  public static void IOExceptionToStdErr(Exception e) {
    System.err.println("ERROR: An IOException has occurred: " + e);
    System.err.println('\n');
    System.err.println("     Contact Adam Rich for assistance");
    System.err.println("     adamleerich@gmail.com");
    System.err.println("     +1 860 839 9778");
    System.err.println('\n');
  }
    
}

