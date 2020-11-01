package com.wlazrad.word;

import com.wlazrad.security.SecurityUtils;
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

        System.out.println("lala" + SecurityUtils.getCurrentUserLogin());
        wordService.saveWord(word);
        return word;
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Word> getWordList() {
        return wordService.returnAllWords();
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public void deleteWord(@PathVariable Long id) {
        wordService.deleteWord(id);
    }

    @GetMapping("/list/all")
    public List<Word> getWordListAllUsers() {
        return wordService.returnAllWordsAllUsers();
    }

    @PutMapping("/teach/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public void addToTeachWord(@PathVariable Long id) {
        wordService.addToTeachWord(id);
    }

    @GetMapping("/teach/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Word> getAllTeachWord() {
        return wordService.getAllTeachWords();
    }
}
