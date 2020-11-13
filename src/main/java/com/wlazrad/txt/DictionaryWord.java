package com.wlazrad.txt;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@AllArgsConstructor
public class DictionaryWord {

    @Autowired
    ReadFile readFile;
    @PostConstruct
    public List<String> getNounList(){
        return readFile.main();
    }
}
