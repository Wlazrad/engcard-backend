package com.wlazrad.txt;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DictionaryWord {
    @PostConstruct
    public List<String> getNounList(){
        return ReadFile.main();
    };
}
