package com.wlazrad.pdf;

import com.wlazrad.word.Word;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CardPdfParameters {
    List<Word> word;
}
