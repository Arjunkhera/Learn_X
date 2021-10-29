package com.arjun.learn;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class App {

  static List<List<Integer>> paths = new ArrayList<>();

  public static void main(String[] args) {
    String first = "3";
    String second = "34";
    System.out.println(first.compareTo(second));
  }

//    actual(5);
//    for(List<Integer> path : paths) {
//      System.out.println(path);
//    }


  public static int formulaOne(int n) {
    int res = 1;
    for(int i = 1; i <= n-1; i++)
      res *= i;
    return res;
  }

  public static int formulaTwo(int n) {
    double res = Math.pow(2, n-1) - 1;
    return (int) res;
  }

  public static int formulaThree(int n) {
    double res = Math.pow(n, n-1);
    return (int) res;
  }

  public static int actual(int n) {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++)
        if(i != j) {
          graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
          // graph.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
        }
    }

    boolean[] visited = new boolean[n];
    // return solve(0, n-1, graph, visited, new LinkedList<Integer>());
    return solve(0, n-1, graph, visited);
  }


  public static int solve(int current, int end, Map<Integer, List<Integer>> graph, boolean[] visited) {
    if(current == end) return 1;

    visited[current] = true;
    int count = 0;
    for(Integer next : graph.get(current))
      if(!visited[next])
        count += solve(next, end, graph, visited);

    visited[current] = false;
    return count;
  }


  public static int solvePaths(int current, int end, Map<Integer, List<Integer>> graph, boolean[] visited, LinkedList<Integer> path) {
    path.addLast(current);
    if(current == end)  {
      paths.add(new ArrayList<>(path));
      path.removeLast();
      return 1;
    }

    visited[current] = true;
    int count = 0;
    for(Integer next : graph.get(current))
      if(!visited[next])
        count += solvePaths(next, end, graph, visited, path);

    path.removeLast();
    visited[current] = false;
    return count;
  }

  public static String check(String sourceRepoName) {
    int indexOf = sourceRepoName.indexOf(".en");
    if (indexOf != -1) {
      sourceRepoName = sourceRepoName.substring(0, indexOf);
    }

    return sourceRepoName;
  }

  public static void Jackson() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jsonNode = objectMapper.readTree(getString());
    List<Instant> list = StreamSupport.stream(jsonNode.spliterator(), false) // Stream
        .map(element -> Instant.parse(element.get("createdDate").asText()))
        .sorted(Collections.reverseOrder())
        .collect(Collectors.toList());

    for (Instant instant : list) {
      System.out.println(instant);
    }
  }

  public static String getString() {
    return "[\n"
        + "      {\n"
        + "        \"name\": \"Video_Test_1608287729596\",\n"
        + "        \"projectName\": \"Video\",\n"
        + "        \"workflowName\": \"HumanTranslationWS\",\n"
        + "        \"translationType\": \"TRANSLATE_ONLY\",\n"
        + "        \"createdBy\": \"GCSMD\",\n"
        + "        \"createdDate\": \"2020-12-18T10:35:34Z\",\n"
        + "        \"status\": \"NORMALIZED\",\n"
        + "        \"sourceLocale\": \"en-US\",\n"
        + "        \"normalizationUrl\": \"GCSMD/Video/Video_Test_1608287729596/normalized/translationKit.zip\",\n"
        + "        \"orgId\": \"GCSMD\",\n"
        + "        \"workflowInstanceId\": \"75c7e483-624b-4eb4-a6c8-15dbc4ef8ddd\",\n"
        + "        \"assets\": null,\n"
        + "        \"assetCounts\": null\n"
        + "      },\n"
        + "      {\n"
        + "        \"name\": \"Video_Test_1610083547797\",\n"
        + "        \"projectName\": \"Video\",\n"
        + "        \"workflowName\": \"HumanTranslationWS\",\n"
        + "        \"translationType\": \"TRANSLATE_ONLY\",\n"
        + "        \"createdBy\": \"GCSMD\",\n"
        + "        \"createdDate\": \"2021-01-08T05:26:01Z\",\n"
        + "        \"status\": \"NORMALIZED\",\n"
        + "        \"sourceLocale\": \"en-US\",\n"
        + "        \"normalizationUrl\": \"GCSMD/Video/Video_Test_1610083547797/normalized/translationKit.zip\",\n"
        + "        \"orgId\": \"GCSMD\",\n"
        + "        \"workflowInstanceId\": \"220b1eba-7646-4600-82d2-07f9794b0386\",\n"
        + "        \"assets\": null,\n"
        + "        \"assetCounts\": null\n"
        + "      }\n"
        + "    ]";
  }
}

