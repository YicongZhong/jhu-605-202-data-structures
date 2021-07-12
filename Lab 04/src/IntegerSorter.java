/*	Adam Rich
 *  EN.605.202.87.SP18 Data Structures
 *  May 5, 2018
 *
 *  class IntegerSort
 *  has several different ways to sort an array
 *  plus some convenience and timing methods
 *
 *  sort methods:
 *    quickSortR      recursive
 *    quickSortIA     iterative using array
 *    quickSortIS     iterative using Stack class
 *    heapSort        as described in lecture
 *    insertionSort   array in-place, per ZyBooks
 *
 *  other methods
 *    resetTimer
 *    isSorted
 *    isOriginal
 *    unsort
 *    + accessors for some class data
 */
 
 
public class IntegerSorter {
  
  private int[] original;
  private int[] x;
  private long cumulativeDuration = 0;
  private long lastTimedStart = 0;
  private long lastTimedEnd = 0;
  private long lastTimedDuration = 0;
  private boolean isTimerOn = false;
  
  public IntegerSorter(int[] pOriginal) {
    /**/// System.out.println("\n\n\nCreate new IntegerSorter...");
    original = new int[pOriginal.length];
    x = new int[pOriginal.length];
    for (int i = 0; i < pOriginal.length; i++) {
      original[i] = pOriginal[i];
      x[i] = pOriginal[i];
    }
    /**/// System.out.println("  original = " + Utils.arrayToString(original, " ", false, false));
    /**/// System.out.println("  x = " + Utils.arrayToString(x, " ", false, false));
  }
  
  
  public int[] original() {return original;}
  public int[] x() {return x;}
  public long lastTimedDuration() {return lastTimedDuration;}
  public long cumulativeDuration() {return cumulativeDuration;}
  
  
  public void resetTimer() {
    /**/// System.out.println("Reset timer...");
    /**/// System.out.println("  At top of call:");
    /**/// System.out.println("    cumulativeDuration = " + cumulativeDuration);
    /**/// System.out.println("    lastTimedDuration = " + lastTimedDuration);
    /**/// System.out.println("    lastTimedEnd = " + lastTimedEnd);
    /**/// System.out.println("    lastTimedStart = " + lastTimedStart);
    /**/// System.out.println("    isTimerOn = " + isTimerOn);
    cumulativeDuration = 0;
    lastTimedDuration = 0;
    lastTimedEnd = 0;
    lastTimedStart = 0;
    isTimerOn = false;
    /**/// System.out.println("  At bottom of call:");
    /**/// System.out.println("    cumulativeDuration = " + cumulativeDuration);
    /**/// System.out.println("    lastTimedDuration = " + lastTimedDuration);
    /**/// System.out.println("    lastTimedEnd = " + lastTimedEnd);
    /**/// System.out.println("    lastTimedStart = " + lastTimedStart);
    /**/// System.out.println("    isTimerOn = " + isTimerOn);
  }
  
  
  public boolean isSorted() {
    /**/// System.out.println("Is sorted?...");
    if (x.length == 1) return true;
    for (int i = 1; i < x.length; i++) {
      if (x[i] < x[i - 1]) return false;
    }
    return true;
  }
  
  
  public boolean isOriginal() {
    /**/// System.out.println("Is original?...");
    for (int i = 0; i < x.length; i++) {
      if (x[i] != original[i]) return false;
    }
    return true;
  }
  
  
  public void unsort() {
    /**/// System.out.println("Un-sort...");
    /**/// System.out.println("  At top of call:");
    /**/// System.out.println("    original = " + Utils.arrayToString(original, " ", false, false));
    /**/// System.out.println("    x = " + Utils.arrayToString(x, " ", false, false));
    for (int i = 0; i < original.length; i++) {
      x[i] = original[i];
    }
    /**/// System.out.println("  At bottom of call:");
    /**/// System.out.println("    original = " + Utils.arrayToString(original, " ", false, false));
    /**/// System.out.println("    x = " + Utils.arrayToString(x, " ", false, false));
  }
  
  
  public void quickSortR(int insertionAt, int initPivotMethod) {
    /**/// System.out.println("\n\n\nquickSortR (recursive)...");
    /**/// System.out.println("  original = " + Utils.arrayToString(original, " ", false, false));
    /**/// System.out.println("  insertionAt = " + insertionAt);
    /**/// System.out.println("  initPivotMethod = " + initPivotMethod);
    this.unsort();
    this.startTimer();
    this.quickSortR__internal(0, x.length - 1, insertionAt, initPivotMethod);
    this.endTimer();
    /**/// System.out.println("  x = " + Utils.arrayToString(x, " ", false, false));
    /**/// System.out.println("  lastTimedDuration = " + lastTimedDuration);
    /**/// System.out.println("  cumulativeDuration = " + cumulativeDuration);
  }
  
  
  public void quickSortIS(int insertionAt, int initPivotMethod) {
    /**/// System.out.println("\n\n\nquickSortIS (iterative with Stack class)...");
    /**/// System.out.println("  original = " + Utils.arrayToString(original, " ", false, false));
    /**/// System.out.println("  insertionAt = " + insertionAt);
    /**/// System.out.println("  initPivotMethod = " + initPivotMethod);
    this.unsort();
    this.startTimer();
    this.quickSortIS__internal(0, x.length - 1, insertionAt, initPivotMethod);
    this.endTimer();
    /**/// System.out.println("  x = " + Utils.arrayToString(x, " ", false, false));
    /**/// System.out.println("  lastTimedDuration = " + lastTimedDuration);
    /**/// System.out.println("  cumulativeDuration = " + cumulativeDuration);
  }
  
  
  public void quickSortIA(int insertionAt, int initPivotMethod) {
    /**/// System.out.println("\n\n\nquickSortIA (iterative with array)...");
    /**/// System.out.println("  original = " + Utils.arrayToString(original, " ", false, false));
    /**/// System.out.println("  insertionAt = " + insertionAt);
    /**/// System.out.println("  initPivotMethod = " + initPivotMethod);
    this.unsort();
    this.startTimer();
    this.quickSortIA__internal(0, x.length - 1, insertionAt, initPivotMethod);
    this.endTimer();
    /**/// System.out.println("  x = " + Utils.arrayToString(x, " ", false, false));
    /**/// System.out.println("  lastTimedDuration = " + lastTimedDuration);
    /**/// System.out.println("  cumulativeDuration = " + cumulativeDuration);
  }
  
  
  public void heapSort() {
    /**/// System.out.println("\n\n\nheapSort...");
    /**/// System.out.println("  original = " + Utils.arrayToString(original, " ", false, false));
    this.unsort();
    this.startTimer();
    this.heapSort__internal();
    this.endTimer();
    /**/// System.out.println("  x = " + Utils.arrayToString(x, " ", false, false));
    /**/// System.out.println("  lastTimedDuration = " + lastTimedDuration);
    /**/// System.out.println("  cumulativeDuration = " + cumulativeDuration);
  }
  
  
  private void heapSort__internal() {
    
    int p; // parent
    int temp;
    int j;
    int c1;
    int c2;
    int cMax;
    
    /**/// System.out.println("  START Build max heap...");
    for (int i = 1; i < x.length; i++) {
      /**/// System.out.println("    i = " + i);
      p = i;
      do {
        c1 = p;
        p = (c1 - 1) / 2;
        /**/// System.out.println("    p = "  + p);
        /**/// System.out.println("    c1 = " + c1);
        /**/// System.out.println("    x[p] = "  + x[p]);
        /**/// System.out.println("    x[c1] = " + x[c1]);
        if (x[p] >= x[c1]) break;
        /**/// System.out.println("    Swap elements x[p] and x[c1] = " + c1);
        temp = x[p];
        x[p] = x[c1];
        x[c1] = temp;
        /**/// System.out.println("    x[p] = "  + x[p]);
        /**/// System.out.println("    x[c1] = " + x[c1]);
      } while (true);
    }
    /**/// System.out.println("  END Build max heap");
    
    /**/// System.out.println("  START Sort max heap...");
    for (int i = x.length - 1; i > 0; i--) {
      /**/// System.out.println("    i = "  + i);
      /**/// System.out.println("    Swap root and x[i]...");
      /**/// System.out.println("      (before) x[0] = "  + x[0]);
      /**/// System.out.println("      (before) x[i] = "  + x[i]);
      temp = x[i];
      x[i] = x[0];
      x[0] = temp;
      /**/// System.out.println("      (after) x[0] = "  + x[0]);
      /**/// System.out.println("      (after) x[i] = "  + x[i]);
      
      /**/// System.out.println("    Start at x[0], pick biggest child and replace, move down...");
      p = 0;
      do {
        c1 = p * 2 + 1;
        c2 = p * 2 + 2;
        /**/// System.out.println("      p = "  + p);
        /**/// System.out.println("      c1 = "  + c1);
        /**/// System.out.println("      c2 = "  + c2);
        /**/// System.out.println("      x[p] = "  + x[p]);
        if (c1 >= i) {
          /**/// System.out.println("      p has no children");
          break;
        }
        if (c2 >= i) {
          /**/// System.out.println("      p has one child");
          /**/// System.out.println("      x[c1] = "  + x[c1]);
          if (x[c1] > x[p]) {
            /**/// System.out.println("      Swap with one child");
            temp = x[p];
            x[p] = x[c1];
            x[c1] = temp;
          }
          break;
        }
        /**/// System.out.println("      x[c1] = "  + x[c1]);
        /**/// System.out.println("      x[c2] = "  + x[c2]);
        if (x[c1] > x[c2] & x[c1] > x[p]) {
          /**/// System.out.println("      Swap with left child");
          temp = x[p];
          x[p] = x[c1];
          x[c1] = temp;
          p = c1;
          /**/// System.out.println("      p becomes " + p);
        } else if (x[c2] > x[p]) {
          /**/// System.out.println("      Swap with right child");
          temp = x[p];
          x[p] = x[c2];
          x[c2] = temp;
          p = c2;
          /**/// System.out.println("      p becomes " + p);
        } else break;
      } while (true);
    }
  }
  
  
  public void insertionSort(boolean pTime) {
    /**/// System.out.println("\n\n\nInsertion sort...");
    /**/// System.out.println("  original = " + Utils.arrayToString(original, " ", false, false));
    this.unsort();
    this.startTimer();
    insertionSort__internal(0, x.length - 1);
    this.endTimer();
    /**/// System.out.println("  x = " + Utils.arrayToString(x, " ", false, false));
    /**/// System.out.println("  lastTimedDuration = " + lastTimedDuration);
    /**/// System.out.println("  cumulativeDuration = " + cumulativeDuration);
  }
  
  
  private void startTimer() {
    // TODO if (isTimerOn) throw new RuntimeException("ERROR: cannot start time when it is already running");
    isTimerOn = true;
    lastTimedStart = System.nanoTime();
  }
  
  
  private void endTimer() {
    // TODO if (!isTimerOn) throw new RuntimeException("ERROR: cannot end un-started timer");
    isTimerOn = false;
    lastTimedEnd = System.nanoTime();
    lastTimedDuration = lastTimedEnd - lastTimedStart;
    cumulativeDuration += lastTimedDuration;
  }
  
  
  private void prepPartition(int start, int end, int initPivotMethod) {
    /**/// System.out.println("Prep partition...");
    // 1 = use first
    if (initPivotMethod == 1) {
      /**/// System.out.println("  First index method");
      return;
    }
    
    // 2 = median of three
    if (initPivotMethod == 2) {
      int mid = (end + start) / 2;
      int swap = 0;
      /**/// System.out.println("  Median of three method:");
      /**/// System.out.println("    x = " + Utils.arrayToString(x, " ", false, false));
      /**/// System.out.println("    start = " + start);
      /**/// System.out.println("    end = " + end);
      /**/// System.out.println("    mid = " + mid);
      /**/// System.out.println("    x[start] = " + x[start]);
      /**/// System.out.println("    x[end] = " + x[end]);
      /**/// System.out.println("    x[mid] = " + x[mid]);
      if ((x[start] <= x[end] & x[start] >= x[mid]) ||
          (x[start] <= x[mid] & x[start] >= x[end])) {
        /**/// System.out.println("    Picked start -> no swap");
        return;
      }
           
      if ((x[end] <= x[start] & x[end] >= x[mid]) ||
          (x[end] <= x[mid] & x[end] >= x[start])) {
        swap = x[start];
        x[start] = x[end];
        x[end] = swap;
        /**/// System.out.println("    Picked end -> swap with start");
        /**/// System.out.println("    x[start] = " + x[start]);
        /**/// System.out.println("    x[end] = " + x[end]);
        /**/// System.out.println("    x[mid] = " + x[mid]);
        /**/// System.out.println("    x = " + Utils.arrayToString(x, " ", false, false));
        return;
      }
      
      swap = x[start];
      x[start] = x[mid];
      x[mid] = swap;
      /**/// System.out.println("    Picked mid -> swap with start");
      /**/// System.out.println("    x[start] = " + x[start]);
      /**/// System.out.println("    x[end] = " + x[end]);
      /**/// System.out.println("    x[mid] = " + x[mid]);
      /**/// System.out.println("    x = " + Utils.arrayToString(x, " ", false, false));
      return;
      
    }
    
  }
  
  
  private void quickSortR__internal(int start, int end, int insertionAt, int initPivotMethod) {
    /**/// System.out.println("quickSortR__internal...");
    /**/// System.out.println("  start = " + start);
    /**/// System.out.println("  end = " + end);
    int d = start;
    int u = end;
    int n = end + 1 - start;
    int p = 0;
    int m = 0;
    
    if (n == 1) return;
    this.prepPartition(start, end, initPivotMethod);
    p = x[d];
    
    do {
      while (u > d & x[u] >= p) u--;
      if (u > d) {
        if (x[u] < p) x[d] = x[u];  
      } else {
        break;
      }
      while (u > d & p >= x[d]) d++;
      if (d < u) {
        if (p < x[d]) x[u] = x[d];  
      } else {
        break;
      }
    } while (d < u);

    /**/// System.out.println("  position of partition found!");
    x[d] = p;
    /**/// System.out.println("    " + Utils.arrayToString(x, " ", false, false));

    m = d - start;
    if (m > insertionAt) {
      quickSortR__internal(start, d - 1, insertionAt, initPivotMethod);
    } else {
      if (m > 1) insertionSort__internal(start, d - 1);
    }
    
    m = end - d;
    if (m > insertionAt) {
      quickSortR__internal(d + 1, end, insertionAt, initPivotMethod);
    } else {
      if (m > 1) insertionSort__internal(d + 1, end);
    }
    
  }
  
  
  private void quickSortIS__internal(int start, int end, int insertionAt, int initPivotMethod) {
    int d;
    int u;
    int n = end + 1 - start;
    int p;
    int m;
    StackInteger s = new StackInteger();
    
    
    if (n == 1) return;
    s.push(start);
    s.push(end);
    
    while (!s.isEmpty()) { 
      end = s.pop();
      start = s.pop();
      /**/// System.out.println("quickSortIS__internal...");
      /**/// System.out.println("  start = " + start);
      /**/// System.out.println("  end = " + end);
      d = start;
      u = end;
      this.prepPartition(start, end, initPivotMethod);
      p = x[d];
      do {
        while (u > d & x[u] >= p) u--;
        if (u > d) {
          if (x[u] < p) x[d] = x[u];  
        } else {
          break;
        }
        while (u > d & p >= x[d]) d++;
        if (d < u) {
          if (p < x[d]) x[u] = x[d];  
        } else {
          break;
        }
      } while (d < u);
      
      /**/// System.out.println("  position of partition found!");
      x[d] = p;
      /**/// System.out.println("    " + Utils.arrayToString(x, " ", false, false));

      m = d - start;
      if (m > insertionAt) {
        s.push(start);
        s.push(d - 1);
      } else {
        if (m > 1) insertionSort__internal(start, d - 1);
      }
      
      m = end - d;
      if (m > insertionAt) {
        s.push(d + 1);
        s.push(end);
      } else {
        if (m > 1) insertionSort__internal(d + 1, end);
      }
    }
    
  }
  
  
  private void quickSortIA__internal(int start, int end, int insertionAt, int initPivotMethod) {
    int d;
    int u;
    int n = end + 1 - start;
    int p;
    int m;
    int[] s = new int[1000];
    int i = -1;
    
    
    if (n == 1) return;
    s[++i] = start;  // s.push(start);
    s[++i] = end;    // s.push(end);
    
    while (i > 0) { 
      end = s[i--];    // end = s.pop();
      start = s[i--];  // start = s.pop();
      /**/// System.out.println("quickSortIA__internal...");
      /**/// System.out.println("  start = " + start);
      /**/// System.out.println("  end = " + end);
      d = start;
      u = end;
      this.prepPartition(start, end, initPivotMethod);
      /**/// System.out.println("  Returned from prep partition");
      p = x[d];
      do {
        while (u > d & x[u] >= p) u--;
        if (u > d) {
          if (x[u] < p) x[d] = x[u];  
        } else {
          break;
        }
        while (u > d & p >= x[d]) d++;
        if (d < u) {
          if (p < x[d]) x[u] = x[d];  
        } else {
          break;
        }
      } while (d < u);
      
      /**/// System.out.println("  position of partition found!");
      x[d] = p;
      /**/// System.out.println("    " + Utils.arrayToString(x, " ", false, false));

      m = d - start;
      if (m > insertionAt) {
        s[++i] = start;  // s.push(start);
        s[++i] = d - 1;  // s.push(d - 1);
      } else {
        if (m > 1) insertionSort__internal(start, d - 1);
      }
      
      m = end - d;
      if (m > insertionAt) {
        s[++i] = d + 1;  // s.push(d + 1);
        s[++i] = end;    // s.push(end);
      } else {
        if (m > 1) insertionSort__internal(d + 1, end);
      }
    }
    
  }
  
  
  private void insertionSort__internal(int start, int end) {
    /**/// System.out.println("Switching to insertion sort...");
    /**/// System.out.println("  start = " + start);
    /**/// System.out.println("  end = " + end);
    /**/// System.out.println("  " + Utils.arrayToString(x, " ", false, false));
    if (start == end) return;
    int j = 0;
    int temp = 0;
    for (int i = start + 1; i <= end; i++) {
      /**/// System.out.println("    i = " + i);
      j = i;
      while(j > start & x[j] < x[j - 1]) {
        /**/// System.out.println("    j = " + j);
        /**/// System.out.println("    x[j] = " + x[j]);
        /**/// System.out.println("    x[j - 1] = " + x[j - 1]);
        temp = x[j - 1];
        x[j - 1] = x[j];
        x[j] = temp;
        j--;
        if (j <= start) break;
      }
    }
    /**/// System.out.println("  " + Utils.arrayToString(x, " ", false, false));
  }
  
}




