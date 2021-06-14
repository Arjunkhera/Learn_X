package com.arjun.learn.algorithms.searching;

import com.arjun.learn.algorithms.trees.Converter;
import com.arjun.learn.algorithms.trees.TreeNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConverterTest {

  @Test
  public void firstTest() {
    String input = "1,2,null,null,3,4,null,null,5,null,null,";
    TreeNode root = Converter.deserialize(input);
    String output = Converter.serialize(root);

    assertEquals(input, output, "Serialized and Deserialized strings are not equal");
  }
}
