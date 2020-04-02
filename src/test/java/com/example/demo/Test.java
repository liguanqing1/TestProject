package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {

    static String [] dicc = new String [] {"i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man go"};

    public static void main(String[] args) throws Exception {
        String sentence = "ilikesamsungmobile";
        generate(dicc,"", sentence);
    }

    public static void generate(String[] dic, String str, String sentence) {
        List<String> noSpacesDic = new ArrayList<>();
        Arrays.stream(dic).forEach(item -> {
            noSpacesDic.addAll(Arrays.asList(item.trim().split("\\s+")));
        });

        int wordMaxLen = Arrays.stream(dic)
                .mapToInt(String -> String.length())
                .max()
                .getAsInt();

        char [] charArr = sentence.toCharArray();

        String word = "";


        for(int i= 0 ; i<charArr.length ; i++) {
            word += charArr[i];

            final String key = word;
            Optional<String> optional = noSpacesDic.stream()
                    .filter(s -> s.equals(key))
                    .findFirst();

            if(optional.isPresent()) {
                if(i == charArr.length - 1) {
                    String showtime = str + " " + optional.get();
                    System.out.println(str + " " + optional.get());
                } else {
                    generate(dic, str + " " + optional.get(), new String(Arrays.copyOfRange(charArr, i + 1, charArr.length)));
                }
            }

            if(word.length() == wordMaxLen) {
                break;
            }
        }
    }
}
