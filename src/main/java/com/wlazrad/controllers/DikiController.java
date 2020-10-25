package com.wlazrad.controllers;

import com.wlazrad.integration.DikiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/diki")
public class DikiController {

    @Autowired
    DikiClient dikiClient;

    @GetMapping("/autocompletelist/{partWord}")
    public List<String> getAutoCompleteList(@PathVariable String partWord) {
        return dikiClient.getAutoCompleteList(partWord);
    }
}
