package com.arjun.learn.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        SampleBean sampleBean = new SampleBean();
        sampleBean.setFirstNameName("sample");
        sampleBean.setLastName("bean");

        Map<String, String> map = new HashMap<>();
        map.put("first", "1");
        map.put("second", "2");
        sampleBean.setFlatMap(map);

        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = mapper.writeValueAsString(sampleBean);
        System.out.println(result);
    }
}
