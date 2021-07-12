/*  Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  April 23, 2018
 *
 *  class HuffmanLeafPile
 *
 *
 */


 
public class HuffmanLeafPile {
  
  private HuffmanTree[] pile = new HuffmanTree[26];
  private int leaves = 0;
  private int[] freq;
  private String freqTable = "";
  private String ties = "";
  
  public HuffmanLeafPile(int[] pFreq, String pTies) {
    freq = pFreq;
    freqTable = intArrayToFreqTable(freq);
    ties = pTies;
    this.konstruct();
  }

  public HuffmanLeafPile(String pFreqTable, String pTies) {
    freqTable = pFreqTable;
    freq = freqTableToIntArray(freqTable);
    ties = pTies;
    this.konstruct();
  }
  
  private void konstruct() {
    leaves = freq.length;
    for (int i = 0; i < leaves; i++) {
      /**/// System.out.println("Creating HuffmanTree Node");
      /**/// System.out.println("  i = " + i);
      /**/// System.out.println("  freq[i] = " + freq[i]);
      /**/// System.out.println("  ties = " + ties);
      /**/// System.out.println("  key = " + (char)(i + 'A'));
      pile[i] = new HuffmanTree("" + (char)(i + 'A'), freq[i], ties);
    }
    this.sort();
    
    /**/// System.out.println("Creating HuffmanLeafPile");
    /**/// System.out.println("  leaves = " + leaves);
    /**/// System.out.println("  ties = " + ties);
    
  }
  
  private void sort() {
    int jmax = 0;
    HuffmanTree t = null;
    for (int i = 0; i < leaves; i++) {
      jmax = i;
      for (int j = i; j < leaves; j++) {
        if (!pile[j].toLeftOf(pile[jmax])) {
          jmax = j;
        }
      }
      t = pile[jmax];
      pile[jmax] = pile[i];
      pile[i] = t;
    }
  }
  
  public String toString() {
    String out = "Huffman Leaf Pile:\n";
    for (int i = 0; i < leaves; i++) {
      out += "  " + pile[i].getKey() + ": " + pile[i].getFreq() + "\n";
    }
    return out;
  }
  
  public void merge() {
    HuffmanTree t1 = pile[leaves - 1];
    HuffmanTree t2 = pile[leaves - 2];
    pile[leaves - 2] = new HuffmanTree(t1, t2);
    pile[leaves - 1] = null;
    leaves--;
    this.sort();
  }
  
  public HuffmanTree rakeUp() {
    for (int i = leaves; i >= 2; i--) {
      this.merge();
    }
    pile[0].setFreqTable(freqTable);
    pile[0].setFreq(freq);
    return pile[0];
  }

  public static int[] freqTableToIntArray(String pFreqTable) {
    int c = -1;
    int out[] = new int[26];
    int column = 0;
    int letter = 0;
    String freq = "";
      
    for (int i = 0; i < pFreqTable.length(); i++) {
      c = pFreqTable.charAt(i);
      if (c == '\n' || c == '\r') {
        
        if (letter > 0) {
          // System.out.println((char)letter + "(" + (letter - 'A') + ") = " + freq);
          out[(int)(letter - 'A')] = Integer.parseInt(freq);
        }
    
        column = 0;
        letter = 0;
        freq = "";
        continue;
    
      }
    
      column++;
    
      if (column == 1 && c >= 'A' && c <= 'Z') {
        letter = c;
      }
    
      if (column > 4 && c >= '0' && c <= '9') {
        freq += (char)c;
      }
    }
    return out;
  }

  public static String intArrayToFreqTable(int[] pFreq) {
    // int c = -1;
    // int out[] = new int[26];
    // int column = 0;
    // int letter = 0;
    // String freq = "";
    //   
    // for (int i = 0; i < pFreqTable.length(); i++) {
    //   c = pFreqTable.charAt(i);
    //   if (c == '\n' || c == '\r') {
    //     
    //     if (letter > 0) {
    //       // System.out.println((char)letter + "(" + (letter - 'A') + ") = " + freq);
    //       out[(int)(letter - 'A')] = Integer.parseInt(freq);
    //     }
    // 
    //     column = 0;
    //     letter = 0;
    //     freq = "";
    //     continue;
    // 
    //   }
    // 
    //   column++;
    // 
    //   if (column == 1 && c >= 'A' && c <= 'Z') {
    //     letter = c;
    //   }
    // 
    //   if (column > 4 && c >= '0' && c <= '9') {
    //     freq += (char)c;
    //   }
    // }
    // return out;
    return "";
  }

  
}

