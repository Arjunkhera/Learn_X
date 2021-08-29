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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.io.FileUtils;

public class App {

  public static void main(String[] args) {
    Character.is

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

