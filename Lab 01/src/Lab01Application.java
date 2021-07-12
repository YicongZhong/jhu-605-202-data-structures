/*  Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  March 2, 2018
 *
 *  class LabApplication01
 *  main() is in this file
 *
 *  main takes two args: input file and output file
 *  output file has postfix expressions, one per line
 *  The output contains pseudo-Machine Language instructions, 
 *  with some commented markup to help with checking
 *
 *  Valid postfix expressions will only uses A-Z, 
 *  tab or spaces (for readability), and the following operators
 *    $ (exponentiation), *, /, +, -
 *  
 *
 *  io code is based on example from Dr. Erhan Guven
 *  https://blackboard.jhu.edu/webapps/blackboard/content/
 *  listContent.jsp?course_id=_154611_1&content_id=_5182936_1
 *
 *  
 *
 */

// (char)65 -> 'A'
// (char)66 -> 'B'
// ...
// (char)89 -> 'Y'
// (char)90 -> 'Z'
// (char)36 -> '$'
// (char)42 -> '*'
// (char)43 -> '+'
// (char)45 -> '-'
// (char)47 -> '/'

 

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;



public class Lab01Application {
  
  /* main()
   *   args[0] is input file
   *   args[1] is output file
   *   
   *   Iterates through input file one character of a time
   *   uses StackInteger class to facilitate processing
   *
   */
  public static void main(String[] args) throws IOException {
    
    
    FileReader inputStream = null; 
    FileWriter outputStream = null;
    StackInteger s = new StackInteger();
    int iVar1 = 0;
    int iVar2 = 0;
    int nTemp = 0;
    String sExp = "";
    String sAssem = "";
    int iChar = 0;
    int iLine = 1;
    boolean bGood = true;
    String sError = "";
    
    
    try {
      
      args = fixArgs(args);
      
      inputStream = new FileReader(args[0]); 
      outputStream = new FileWriter(args[1]);

      int c; 
      
      // Read through input file one character at a time.
      do { 
        
        c = inputStream.read();
        
        iChar++;
        /**/// outputStream.write("Line: " + iLine + "\n");
        /**/// outputStream.write("Char: " + iChar + "\n");
        /**/// outputStream.write("c: " + c + "\n");
        /**/// outputStream.write("(char)c: " + (char)c + "\n");
        
        
        if (isVar(c)) {
          sExp += (char)c;
          s.push(c);
          /**/// outputStream.write("s.toString(): " + s.toString() + "\n\n");
        } else if (isOp(c) & sError == "") {
          sExp += (char)c;
          nTemp++;
          
          // Every operator encountered requires 
          // at least two variables on the stack
          // TEMP variables are put on stack as negative numbers
          // This allows them to be distinguished from 
          // valid variables 'A' through 'Z'
          // which are all positive
          if (s.isEmpty()) {
            bGood = false;
            
            sError = "//   ERROR: Malformed expression near '" + 
              (char)c + "' in " + sExp + 
              ".  Operator requires two variables, has zero.\n\n";
              
            continue;
          } else {
            iVar2 = s.pop();
          }
          
          if (s.isEmpty()) {
              
            sError = "//   ERROR: Malformed expression near '" + 
              (char)c + "' in " + sExp + 
              ".  Operator requires two variables, has one.\n\n";
              
            continue;
          } else {
            iVar1 = s.pop();
          }
          
          
          // Put Var1 in register
          sAssem += "LD ";
          if (iVar1 < 0) {
            sAssem += "TEMP" + -iVar1;
          } else {
            sAssem += (char)iVar1;  
          }
          sAssem += '\n';
          
          // Do operation
          if (c == '$') sAssem += "PW ";
          if (c == '*') sAssem += "ML ";
          if (c == '/') sAssem += "DV ";
          if (c == '+') sAssem += "AD ";
          if (c == '-') sAssem += "SB ";
          
          if (iVar2 < 0) {
            sAssem += "TEMP" + -iVar2;
          } else {
            sAssem += (char)iVar2;  
          }
          sAssem += '\n';
          
          // Place val in reg to TEMPn
          sAssem += "ST TEMP" + nTemp + '\n';
          
          // Push TEMPn to stack
          s.push(-nTemp);
          /**/// outputStream.write("s.toString(): " + s.toString() + "\n\n");
          
        } else if (c == '\n' || c == '\r' || c == -1) {
          // Should be end of expression
          // the only thing left on the stack 
          // should be the last temp var added
          
          /**/// outputStream.write("s.toString(): " + s.toString() + "\n");
          /**/// outputStream.write("sExp: " + sExp + "\n");
          /**/// outputStream.write("sExp.length(): " + sExp.length() + "\n");
          /**/// outputStream.write("sExp.isEmpty(): " + sExp.isEmpty() + "\n");
          /**/// outputStream.write("sExp == \"\": " + (sExp == "") + "\n");
          /**/// outputStream.write("\n");
          
          // sExp == "" means an empty line in input file, this is OK, just skip
          if (sExp != "") {
            if (s.isEmpty()) {
              // Temp variable not pushed
              // No test case yet found that triggers this code
              bGood = false;
              
              if(sError == "") sError = "//   ERROR: Malformed expression near '" + 
                (char)c + "' in " + sExp + ".  Unknown reason.\n\n";
                
            } else {
              // After this pop, s is empty when there are no left over variables
              iVar1 = s.pop();
            }
            
            outputStream.write("// ML Instruction for expression, input line " + 
              iLine + ": " + sExp + '\n');
            if (s.isEmpty() & bGood & (sError == "")) {
              outputStream.write(sAssem);
              outputStream.write("\n" + "\n");
            } else {
              
              // If no other error message, then we have variables still on the stack
              if (sError == "") sError = "//   ERROR: Malformed expression." + 
                "Too many variables not enough operators.\n\n";
                
              outputStream.write(sError);
            }
          }
          
          // Reset for next line
          sAssem = "";
          sExp = "";
          s = new StackInteger();
          iLine++;
          iChar = 0;
          bGood = true;
          iVar1 = 0;
          iVar2 = 0;
          nTemp = 0;
          sError = "";
          
        } else if (c == '\t' || c == ' ') {
          // Skip tab and space
        } else {
          // This is an invalid character
          sExp += (char)c;
          bGood = false;
          /**/// System.out.println("c: " + c + ", " + (char)c);
          
          if (sError == "") sError = "//   ERROR: Malformed expression near '" + 
            (char)c + "' in " + sExp + ".  Invalid character encountered.\n\n";
            
        }
        
      } while (c != -1);
    
    } catch(Exception e) {
      System.err.println("ERROR: An IOException has occurred: " + e);
      System.err.println('\n');
      System.err.println("     Contact Adam Rich for assistance");
      System.err.println("     adamleerich@gmail.com");
      System.err.println("     +1 860 839 9778");
      System.err.println('\n');
    } finally {
      if (inputStream != null) inputStream.close();
      if (outputStream != null) outputStream.close();
    }
  }
  
  
  // Take a character encoded as integer
  // Test whether it is a valid upper case letter
  private static boolean isVar(int c) {
    return ((char)c >= 'A' && (char)c <= 'Z');
  }
  
  // Take a character encoded as integer
  // Test whether it is a valid operator
  private static boolean isOp(int c) {
    return (c == '$' || c == '*' || c == '/' || c == '+' || c == '-');
  }
  
  // Takes String array
  // meant to only take command line args
  // returns "cleaned up" and enhanced args
  // TODO doesn't yet deal with directories 
  //   or output files that cannot be written to or are locked
  private static String[] fixArgs(String[] args) throws IOException {
    
    String sInPath = "";
    String sOutPath = "";
    String sOut[] = new String[2];
    
    if (args.length > 0) {
      sInPath = args[0];
    }
    
    if (args.length > 1) {
      sOutPath = args[1];
    }
    
    if (args.length > 2) {
      System.out.println("WARNING: only two command line inputs are expected.");
      System.out.println("     Args 1 and 2 will be used, the rest are ignored.");
    }
    
    File fInFile = new File(sInPath);
    File fOutFile = new File(sOutPath);
    
    while (!fInFile.exists()) {  
      System.out.println("\nERROR: The input file does not exist.");
      System.out.println("Enter an input file name (blank to exit): ");
      Scanner fname = new Scanner(System.in);
      sInPath = fname.nextLine();
      if (sInPath == "") return null;
      /**/// System.out.println("sInPath = " + sInPath);
      fInFile = new File(sInPath);
    }
    
    while (!fInFile.canRead()) {
      System.out.println("\nERROR: The input file cannot be read.");
      System.out.println("Enter an input file name (blank to exit): ");
      Scanner fname = new Scanner(System.in);
      sInPath = fname.nextLine();
      if (sInPath == "") return null;
      /**/// System.out.println("sInPath = " + sInPath);
      fInFile = new File(sInPath);
    }
    
    if (!fOutFile.exists()) fOutFile.createNewFile();
      
    while (!fOutFile.exists()) {
      System.out.println("\nERROR: The output file is not valid.");
      System.out.println("Enter an output file name (blank to exit): ");
      Scanner fname = new Scanner(System.in);
      sOutPath = fname.nextLine();
      if (sOutPath == "") return null;
      fOutFile = new File(sOutPath);
    }
    
    sOut[0] = sInPath;
    sOut[1] = sOutPath;
        
    return sOut;
  }
  
}



