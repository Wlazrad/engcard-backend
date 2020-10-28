package com.wlazrad.txt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class DictionaryWordService {

    @Autowired
    DictionaryWord dictionaryWord;
    public List<String> getFilterList(String partOfWord){

        String patternString = "^"+partOfWord+".*";

        Pattern pattern = Pattern.compile(patternString);

        return dictionaryWord.getNounList().stream().filter(x->{
            Matcher matcher = pattern.matcher(x);
            return matcher.matches();
        }).collect(Collectors.toList());
    }
//    public static void main(String[] args) {
//        String partOfWord = "doe";
//        String patternString = "^"+partOfWord+".*";
//
//        Pattern pattern = Pattern.compile(patternString);
//        Matcher matcher = pattern.matcher("domek");
//        System.out.println(matcher.matches());
//    }
}
