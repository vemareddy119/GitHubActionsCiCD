package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class TaskOneExample {
    public static void main(String[] args) {
        Map<String, String> options = getOptions("BC", "BANGALORE");
        System.out.println(options);
    }

    public static Map<String, String> getOptions(String str1, String str2) {
        Map<String, String> optionsMap = new HashMap<>();
        String opt1 = "";
        String[] str1Split = str1.split("");
        for (int i = 0; i < str1.length(); i++) {
            if (!str2.contains(str1Split[i])) {
                opt1 += str1Split[i];
            }
        }
        optionsMap.put("opt1", opt1.isEmpty() ? null : opt1);
        String opt2 = "";
        String[] str2Split = str2.split("");
        for (int i = 0; i < str2.length(); i++) {
            if (!str1.contains(str2Split[i]) && !opt2.contains(str2Split[i])) {
                opt2 += str2Split[i];
            }
        }
        optionsMap.put("opt2", opt2.isEmpty() ? null : opt2);

        return optionsMap;
    }
}
