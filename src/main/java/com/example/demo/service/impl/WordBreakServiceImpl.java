package com.example.demo.service.impl;

import com.example.demo.service.WordBreakService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class WordBreakServiceImpl implements WordBreakService {

    @Override
    public String workBreak(String[] dic, String sentence) {
        String result = generate(dic, "", sentence);
        return result;
    }

    public String generate(String[] dic, String str, String sentence) {
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
        String result = "";

        for(int i= 0 ; i<charArr.length ; i++) {
            word += charArr[i];

            final String key = word;
            Optional<String> optional = noSpacesDic.stream()
                    .filter(s -> s.equals(key))
                    .findFirst();

            if(optional.isPresent()) {
                if(i == charArr.length - 1) {
                    result = str + " " + optional.get();

                    break;
                } else {
                    result =  generate(dic,str + " " + optional.get(), new String(Arrays.copyOfRange(charArr, i + 1, charArr.length)));
                }
            }

            if(word.length() == wordMaxLen) {
                break;
            }
        }
        return result;
    }

}
