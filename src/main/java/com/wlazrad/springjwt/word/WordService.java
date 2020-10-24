package com.wlazrad.springjwt.word;

import com.wlazrad.springjwt.repository.UserRepository;
import com.wlazrad.springjwt.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordService {
    @Autowired
    WordRepository wordRepository;

    @Autowired
    UserRepository userRepository;

    public Word saveWord(Word word) {
        word.setCreatedBy(SecurityUtils.getCurrentUserLogin());
        word.setUser(userRepository.findByUsername(SecurityUtils.getCurrentUserLogin()).get());
        return wordRepository.save(word);
    }

    public List<Word> returnAllWords() {
        return wordRepository.findAll().stream()
                .filter(word -> word.getUser().getUsername().equals(SecurityUtils.getCurrentUserLogin()))
                .collect(Collectors.toList());
    }

    public void deleteWord(Long id) {
        wordRepository.deleteById(id);
    }

    public List<Word> returnAllWordsAllUsers() {

        return wordRepository.findAll();
    }
}
