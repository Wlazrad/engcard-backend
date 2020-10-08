package com.wlazrad.springjwt.word;

import com.wlazrad.springjwt.repository.UserRepository;
import com.wlazrad.springjwt.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return wordRepository.findAll();
    }

    public void deleteWord(Long id) {
        wordRepository.deleteById(id);
    }
}
