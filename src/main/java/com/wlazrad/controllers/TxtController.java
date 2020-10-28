package com.wlazrad.controllers;

import com.wlazrad.integration.DikiClient;
import com.wlazrad.txt.DictionaryWord;
import com.wlazrad.txt.DictionaryWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/txt")
@RequiredArgsConstructor
public class TxtController {

    @Autowired
    DictionaryWordService dictionaryWordService;

    @GetMapping("/autocompletelist/{partWord}")
    public List<String> getAutoCompleteList(@PathVariable String partWord) {
        return dictionaryWordService.getFilterList(partWord);
    }


}
