package com.wlazrad.springjwt.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/word")
public class WordController {
    @Autowired
    WordService wordService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Word addWord(@RequestBody Word word) {
        wordService.saveWord(word);
        return word;
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Word> getWordList(@RequestBody Word word) {
        return wordService.returnAllWords();
    }
}
