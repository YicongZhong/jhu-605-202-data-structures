/*	Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  May 5, 2018
 *
 *  class QuickSorter 
 *
 */
 
public class ArrayStringParser {
  
  public static final int INIT_SIZE = 1000;
  
  private int nums[];
  private int origSize = INIT_SIZE;
  private int growBy = INIT_SIZE;
  private int length = 0;
  private String toParse = "";
  
  // // Constructor with defaults
  // public ArrayStringParser() {
  //   ArrayStringParser(INIT_SIZE, INIT_SIZE);
  // }
	
  public ArrayStringParser(int pOrigSize, int pGrowBy) {
    origSize = pOrigSize;
    growBy = pGrowBy;
    nums = new int[origSize];
  }
	
  public int[] parse(String pToParse) {
    length = 0;
    toParse = pToParse;
    
    int c = 0;
    int sLen = toParse.length();
    String s = "";
    int begin = 0;
    int end = 0;
    boolean inNum = false;
    
    for (int i = 0; i <= sLen; i++) {
      if (i != sLen) {
        c = toParse.charAt(i);
      } else {
        c = ' ';
      }
      
      if (!inNum & c == '-') {
        inNum = true;
        begin = i;
      } else if (c >= '0' & c <='9') {
        if (!inNum) {
          inNum = true;
          begin = i;
        }
      } else {
        if (inNum) {
          inNum = false;
          end = i;
          s = toParse.substring(begin, end);
          if (!s.equals("-")) {
            if (length >= nums.length) {
              int g = toParse.length() / i * nums.length + growBy;
              this.autoGrow(g);
            }
            length++;
            nums[length-1] = Integer.valueOf(s);
          }
        }
      }
    }
    
    int out[] = new int[length];
    for (int i = 0; i < length; i++) {
      out[i] = nums[i];
    }
    
    return out;
    
  }
  
  private int autoGrow(int n) {
    
    /**/// System.out.println("Doing an auto-grow...");
    /**/// System.out.println("  length = " + length);
    /**/// System.out.println("  growBy = " + growBy);
    /**/// System.out.println("  nums.length = " + nums.length);
    /**/// System.out.println("  n = " + n);
    
    int temp[] = new int[nums.length + n];
    for (int i = 0; i < nums.length; i++) {
      temp[i] = nums[i];
    }
    nums = temp;
    return nums.length;
  }
  
}

