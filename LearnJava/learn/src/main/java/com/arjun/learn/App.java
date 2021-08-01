package com.arjun.learn;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.io.FileUtils;

public class App {

  private static final String DEFAULT_HOSTNAME = "amazonaws.com";

  public static void main(String[] args) throws IOException {
    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
        (String hostname, javax.net.ssl.SSLSession sslSession) ->
            hostname.endsWith(DEFAULT_HOSTNAME));

    String url = "https://gcsstorage1.blob.core.windows.net/gcstest1/MDConnector/MDTest/Test_16269425/2021-07-26/1627270882527/AnotherNewFile.md?sp=r&st=2021-07-26T17:13:29Z&se=2021-07-27T01:13:29Z&spr=https&sv=2020-08-04&sr=b&sig=n2D5%2FpAuL6CZfUy1zFAC3oWM%2BkhcrZMy7w%2F4EBB5kJA%3D";
    File file = new File("temp.md");
    file.createNewFile();
    FileUtils.copyURLToFile(new URL(url), file);

    // checkEmpty().forEach(System.out::println);
  }

  public static List<Integer> checkEmpty() {
    List<Integer> empty = List.of(1,2,3);
    return empty.stream().filter(x -> x > 2).collect(Collectors.toList());
  }

  public static List<String> getFilesInDirectory(String path) throws IOException {
    List<String> files;
    try (Stream<Path> paths = Files.walk(Paths.get(path))) {
      files = paths
          .filter(Files::isRegularFile)
          .map(String::valueOf)
          .collect(Collectors.toList());
    }

    return files;
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

  class Solution {
    long mod = 1000000007;

    public int countGoodNumbers(long n) {
      long ans = fast(20, n/2);
      if(n % 2 == 1) ans = (ans*5) % mod;

      return (int) ans;
    }

    public long fast(int base, long power) {
      if(power == 0) return 1;
      if(power == 1) return base;

      long square = base*base;
      long start = 2;
      while(start * start <= power) {
        square = (square*square) % mod;
        start *= start;
      }

      System.out.printf("power %d, square %d, sending %d", power, square, power-start);
      return (square * fast(base, power - start)) % mod;
    }
  }
}
