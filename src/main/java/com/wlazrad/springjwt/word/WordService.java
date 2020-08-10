package com.wlazrad.springjwt.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {
    @Autowired
    WordRepository wordRepository;

    public Word saveWord(Word word) {

        return wordRepository.save(word);
    }

    public List<Word> returnAllWords(){
        return wordRepository.findAll();
    }
}
