package com.arjun.learn.algorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class KMPTest {

  KMP kmp = new KMP();

  @Test
  public void firstTest() {
    String pattern = "ababd";
    this.kmp.setPattern(pattern);

    String str = "ababcabcabababd";
    int index = this.kmp.isSubString(str);
    assertEquals(pattern, str.substring(index, index + pattern.length()));
  }

  @Test
  public void secondTest() {
    String pattern = "aaabaaaac";
    this.kmp.setPattern(pattern);

    String str = "ababcabcabababd";
    int index = this.kmp.isSubString(str);
    assertEquals(index, -1);
  }

}
