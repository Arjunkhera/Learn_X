package com.arjun.learn.algorithms.dynamicprogramming;

import java.util.Arrays;

public class KMP {

  private String pattern;
  int[] prefix;

  public KMP() {
    pattern = null;
    prefix = null;
  }

  public KMP(String pattern) {
    setPattern(pattern);
  }

  private void populatePrefixArray() {
    for (int i = 1, j = 0; i < this.pattern.length(); i++) {
      while (j > 0 && this.pattern.charAt(i) != this.pattern.charAt(j)) {
        j = this.prefix[j - 1];
      }
      if (this.pattern.charAt(i) == this.pattern.charAt(j)) {
        this.prefix[i] = ++j;
      }
    }
  }

  public void setPattern(String newPattern) {
    this.pattern = newPattern;
    this.prefix = new int[newPattern.length()];
    populatePrefixArray();
  }

  public void printPattern() {
    System.out.println(Arrays.toString(this.prefix));
  }

  public int isSubString(String str) {
    int j = 0, i = 0;
    for (; i < str.length() && j < this.pattern.length(); i++) {
      while (j > 0 && str.charAt(i) != this.pattern.charAt(j)) {
        j = this.prefix[j - 1];
      }
      if (str.charAt(i) == this.pattern.charAt(j)) {
        j++;
      }
    }

    return j == this.pattern.length() ? i - this.pattern.length() : -1;
  }
}
