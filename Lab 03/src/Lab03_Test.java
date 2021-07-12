/*  Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  April 23, 2018
 *
 *  class Lab03_Test
 *  Do some checking on Lab03 classes
 *
 *
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
 
 
public class Lab03_Test {
  
  public static void main(String[] args) throws IOException {
    
    String t = fileToString(".\\input\\freq-given.txt");
    HuffmanLeafPile p1 = new HuffmanLeafPile(t, "default");
    HuffmanLeafPile p2 = new HuffmanLeafPile(t, "mirror");
    
    System.out.println(p1.toString());
    System.out.println(p2.toString());
    
    p1.merge();
    p2.merge();
    
    System.out.println(p1.toString());
    System.out.println(p2.toString());
    
    HuffmanTree t1 = p1.rakeUp();
    HuffmanTree t2 = p2.rakeUp();
    
    System.out.println(t1.toString());
    System.out.println(t2.toString());
    
    System.out.println(t1.toCodes());
    System.out.println(t2.toCodes());
    
    // Make sure that encoding and decoding are inverses
    String clear1 = fileToString(".\\input\\clear-bible.txt");
    System.out.println("  clear1 = " + clear1.substring(0, 100));
    
    String encoded2 = t1.encode(clear1);
    System.out.println("  encoded2 = " + encoded2.substring(0, 100));
    
    String clear3 = t1.decode(encoded2);
    System.out.println("  clear3 = " + clear3.substring(0, 100));
    
    String encoded4 = t1.encode(clear3);
    System.out.println("  encoded4 = " + encoded4.substring(0, 100));
    
    String clear5 = t1.decode(encoded4);
    System.out.println("  clear5 = " + clear5.substring(0, 100));
    
    
    System.out.println("Check encode/decode are inverses...");
    System.out.println("  clear3.equals(clear5) = " + clear3.equals(clear5));
    System.out.println("  encoded2.equals(encoded4) = " + encoded2.equals(encoded4));
    System.out.println("");
    
    System.out.println("\n\n  clear1.substring(0, 20) = " + clear1.substring(0, 20));
    System.out.println("\n\n  clear3.substring(0, 20) = " + clear3.substring(0, 20));
    System.out.println("\n\n  clear5.substring(0, 20) = " + clear5.substring(0, 20));
    
    System.out.println("\n\n  encoded2.substring(0, 20) = " + encoded2.substring(0, 20));
    System.out.println("\n\n  encoded4.substring(0, 20) = " + encoded4.substring(0, 20));
    
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
    // FileWriter f = null;
    try {
      
      if (append) {
        Files.write(Paths.get(fPath), out.getBytes(), StandardOpenOption.APPEND);
      } else {
        // f = new FileWriter(fPath);   
        Files.write(Paths.get(fPath), out.getBytes(), StandardOpenOption.CREATE);
      }
      // for(int i = 0; i < out.length(); i++) {
      //   f.write("" + (char)out.charAt(i));
      // }
    } catch(Exception e) {
      IOExceptionToStdErr(e);
    } finally {
      // if (f != null) f.close();
    } 
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

