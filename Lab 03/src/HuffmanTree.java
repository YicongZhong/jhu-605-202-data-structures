/*  Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  April 23, 2018
 *
 *  class HuffmanTree
 *
 *
 */

public class HuffmanTree {
  
  private String key = "";
  private int freq = -1;
  private HuffmanTree left = null;
  private HuffmanTree right = null;
  private String[] codes = new String[26];
  private boolean complete = false;
  private boolean codesBuilt = false;
  private String freqTable = "";
  private int[] freqArray;
  private String ties = "";

  public int nClear = 0;
  public int nCoded = 0;
  
  public HuffmanTree(String pKey, int pFreq) {
    key = pKey;
    freq = pFreq;
    ties = "default";
  }

  public HuffmanTree(String pKey, int pFreq, String pTies) {
    if (!pTies.equals("default") && !pTies.equals("mirror")) {
      System.err.println("ERROR: ties method passed does not exist.  Must be 'default' or 'mirror'.  Using 'default'.");
      pTies = "default";
    }
    key = pKey;
    freq = pFreq;
    ties = pTies;
  }
  
  public HuffmanTree(HuffmanTree t1, HuffmanTree t2) {
    
    /**/// System.out.println("t1.getTies() = " + t1.getTies());
    /**/// System.out.println("t2.getTies() = " + t2.getTies());
    
    if (!t1.getTies().equals(t2.getTies())) {
      throw new RuntimeException("ERROR: cannot merge trees with different tie-breaking methods");
    }
    
    ties = t1.getTies();
    key = t1.getKey() + t2.getKey();
    freq = t1.getFreq() + t2.getFreq();
    if (t1.toLeftOf(t2)) {
      right = t2;
      left = t1;
    } else {
      left = t2;
      right = t1;
    }
    this.rekey();
  }
  
  public void setFreq(int[] pFreq) {
    freqArray = pFreq;
  }
  
  public void setFreqTable(String pFreqTable) {
    freqTable = pFreqTable;
  }
  
  public String toString() {
    return this.toString("");
  }
  
  public String toString(String indent) {
    String out = "";
    out = indent + key + ":" + freq;
    if (left != null) out = out + "\n" + left.toString(indent + "  ");
    if (right != null) out = out + "\n" + right.toString(indent + "  ");
    return out;
  }
  
  public String toDocumentation() {
    
    if (!this.checkComplete()) {
      System.err.println("ERROR: cannot create documentation using an incomplete tree");
      return "";
    }
    
    String out = "";
    out += "**************************************\n";
    out += "**** Documentation of HuffmanTree ****\n";
    out += "**************************************\n";
    out += "\n\nTie-break method: " + ties;
    out += "\n\nOriginal Freq Table:\n\n";
    out += freqTable;
    out += "\n\nPre-order transversal of tree:\n\n";
    out += this.toString();
    out += "\n\nTable of codes:\n\n";
    out += this.toCodes();
    return out;
  }
  
  public String getKey() {
    return key;
  }
  
  public int getFreq() {
    return freq;
  }
  
  public String getTies() {
    return ties;
  }
  
  public HuffmanTree getLeft() {
    return left;
  }
  
  public HuffmanTree getRight() {
    return right;
  }
  
  public boolean toLeftOf(HuffmanTree pOther) {
    if (ties.equals("mirror")) return this.toLeftOf__mirror(pOther);
    return this.toLeftOf__default(pOther);
  }
  
  private boolean toLeftOf__default(HuffmanTree pOther) {
    String oKey = pOther.getKey();
    int oFreq = pOther.getFreq();
    int key1 = key.charAt(0);
    int oKey1 = oKey.charAt(0);
    
    // These are the same for every toLeftOf__* method
    if (freq < oFreq) return true;
    if (freq > oFreq) return false;
    
    // How ties are resolved in this method
    if (key.length() < oKey.length()) return true;
    if (key.length() > oKey.length()) return false;
    if (key1 < oKey1) return true;
    return false;
  }
  
  private boolean toLeftOf__mirror(HuffmanTree pOther) {
    String oKey = pOther.getKey();
    int oFreq = pOther.getFreq();
    int key1 = key.charAt(0);
    int oKey1 = oKey.charAt(0);
    
    // These are the same for every toLeftOf__* method
    if (freq < oFreq) return true;
    if (freq > oFreq) return false;
    
    // How ties are resolved in this method
    if (key.length() < oKey.length()) return false;
    if (key.length() > oKey.length()) return true;
    if (key1 < oKey1) return false;
    return true;
  }
  
  private void rekey() {
    int n = key.length();
    if (n == 1) return;
    
    int[] charkey = new int[n];
    for (int i = 0; i < n; i++) {
      charkey[i] = key.charAt(i);
    }
    
    key = "";
    int jmin = 0;
    int t = 0;
    
    for (int i = 0; i < n; i++) {
      jmin = i;
      for (int j = i; j < n; j++) {
        if (charkey[j] < charkey[jmin]) {
          jmin = j;
        }
      }
      t = charkey[jmin];
      charkey[jmin] = charkey[i];
      charkey[i] = t;
      key += "" + (char)charkey[i];
    }
  }
  
  public void buildCodes() {
    rBuildCodes(codes, "");
  }
  
  public void rBuildCodes(String[] kodes, String kode) {
    int index = 0;
    if (left == null) {
      index = this.getKey().charAt(0) - 'A';
      kodes[index] = kode;
    } else {
      left.rBuildCodes(kodes, kode + "0");
      right.rBuildCodes(kodes, kode + "1");
    }
  }
  
  public String toCodes() {
    if (!this.checkComplete()) return "Tree is not complete.";
    String out = "";
    for (int i = 0; i < 26; i++) {
      out += (char)(i + 'A') + ":" + codes[i] + "\n";
    }
    return out;
  }
  
  public String encode(String msg) {
    if (!this.checkComplete()) {
      System.err.println("ERROR: cannot encode message using an incomplete tree");
      return "";
    }
    
    nClear = 0;
    nCoded = 0;
    String out = "";
    int c = 0;
    int index = 0;
    msg = msg.toUpperCase();
    
    /**/// System.out.println("msg = " + msg);
    
    for (int i = 0; i < msg.length(); i++) {
      c = msg.charAt(i);
      
      /**/// System.out.println("  i = " + i);
      /**/// System.out.println("  c = " + c);
      /**/// System.out.println("  (char)c = " + (char)c);
      
      if (c >= 'A' && c <= 'Z') {
        index = c - 'A';
        out += codes[index];
        nClear++;
        nCoded += codes[index].length();
        
        /**/// System.out.println("  index = " + index);
        /**/// System.out.println("  codes[index] = " + codes[index]);
        
      } else if (c == '\n' || c == '\r') {
        out += "" + (char)c;
      }
    }
    
    return out;
  }
  
  public String decode(String msg) {
    
    if (!this.checkComplete()) {
      System.err.println("ERROR: cannot decode message using an incomplete tree");
      return "";
    }
      
    nClear = 0;
    nCoded = 0;
    String out = "";
    HuffmanTree curr = this;
    int c = 0;
    
    for (int i = 0; i < msg.length(); i++) {
      c = msg.charAt(i);
      
      if (c == '0') {
        curr = curr.getLeft();
        nCoded++;
      }
      if (c == '1') {
        curr = curr.getRight();
        nCoded++;
      }
      
      if (c == '\n' || c == '\r') out += ("" + (char)c);
      
      if (curr.left == null) {
        out += curr.getKey();
        curr = this;
        nClear++;
      }
      
    }
    
    
    return out;
  }
  
  private boolean checkComplete() {
    
    /**/// System.out.println("Checking tree completeness...");
    /**/// System.out.println("  complete = " + complete);
    /**/// System.out.println("  codesBuilt = " + codesBuilt);
    
    if (!complete) complete = (key.equals("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    /**/// System.out.println("After checking top level key...");
    /**/// System.out.println("  complete = " + complete);
    /**/// System.out.println("  codesBuilt = " + codesBuilt);
    
    
    if (complete && !codesBuilt) {
      /**/// System.out.println("Building codes...");
      this.buildCodes();
    }
    
    /**/// System.out.println("After building codes...");
    /**/// System.out.println("  complete = " + complete);
    /**/// System.out.println("  codesBuilt = " + codesBuilt);
    
    boolean b = true;
    for (int i = 0; i < 26; i++) {
      if (codes[i] == null || codes[i].isEmpty()) {
        b = false;
        break;
      }
    }
    codesBuilt = b;
    
    /**/// System.out.println("After checking codes non-empty...");
    /**/// System.out.println("  complete = " + complete);
    /**/// System.out.println("  codesBuilt = " + codesBuilt);
    
    return complete && codesBuilt;
    
  }  
  
}

