package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NumberTest {
    public static void main(String[] args) {
        String[] strings = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        List<String> numberEnglishList = Arrays.asList(strings);
        String acceptString = "onethreefivesevenninezerotwofoursixeight";

        for (int i=0; i<acceptString.length(); i++) {
            for (String numberEngilshString : numberEnglishList) {
                int numberEngilshLenght = numberEngilshString.length(); //数字英文长度

                if (i+numberEngilshLenght > acceptString.length()){
                    continue;
                }

                int indexOfNumberEngilsh = numberEnglishList.indexOf(acceptString.substring(i, i + numberEngilshLenght));
                if (indexOfNumberEngilsh != -1) {
                    System.out.print(indexOfNumberEngilsh);
                    i += indexOfNumberEngilsh -1;
                    break;
                }
            }
        }

    }

    public static HashMap getHashMap(){
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("zero",0);
        hashMap.put("zero",1);
        hashMap.put("zero",2);
        hashMap.put("zero",3);
        hashMap.put("zero",4);
        hashMap.put("zero",5);
        hashMap.put("zero",6);
        hashMap.put("zero",7);
        hashMap.put("zero",8);
        hashMap.put("zero",9);
        return hashMap;
    }
}
