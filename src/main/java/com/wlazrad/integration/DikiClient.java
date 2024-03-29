package com.wlazrad.integration;

import com.wlazrad.txt.DictionaryWord;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Dictionary;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DikiClient {
    @Autowired
    DictionaryWord dictionaryWord;

    private final RestTemplate restTemplate;
    public static final String NBP_USD = "https://www.diki.pl/dictionary/autocomplete?q=";
    public static String WORD = "&langpair=en%3A%3Apl";

    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<>(headers);

    public List<String> getAutoCompleteList(String partWord) {
        ResponseEntity<List> forEntity = restTemplate.getForEntity(NBP_USD +partWord+ WORD, List.class, entity);
//        List<String> autoCompleteList = forEntity.getBody();
        List<String> autoCompleteList = dictionaryWord.getNounList();
        autoCompleteList.forEach(x -> System.out.println(x));
        return Objects.requireNonNull(forEntity.getBody());
    }
}
