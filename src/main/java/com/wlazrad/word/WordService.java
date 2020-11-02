package com.wlazrad.word;

import com.wlazrad.repository.UserRepository;
import com.wlazrad.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
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
        word.setCreatedDate(ZonedDateTime.now());
        word.setTeach(false);
        return wordRepository.save(word);
    }

    public List<Word> returnAllWords() {
        return wordRepository.findAll().stream()
                .filter(word -> word.getUser().getUsername().equals(SecurityUtils.getCurrentUserLogin()))
                .collect(Collectors.toList());
    }

    public List<Word> getAllTeachWords() {
        return wordRepository.findAll().stream()
                .filter(word -> word.getUser().getUsername().equals(SecurityUtils.getCurrentUserLogin()))
                .filter(word -> word.getTeach().equals(true))
                .collect(Collectors.toList());
    }

    public void deleteWord(Long id) {
        wordRepository.deleteById(id);
    }

    public void addToTeachWord(Long id) {
        Word word = wordRepository.getOne(id);
        word.setTeach(true);
        wordRepository.save(word);
    }

    public void removeFromTeachWord(Long id) {
        Word word = wordRepository.getOne(id);
        word.setTeach(false);
        wordRepository.save(word);
    }

    public List<Word> returnAllWordsAllUsers() {

        return wordRepository.findAll();
    }
}
