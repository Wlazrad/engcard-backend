package com.wlazrad.springjwt.word;

import com.wlazrad.springjwt.models.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
public class Word extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String articulation;
    private String partOne;
    private String partTwo;
    private String polishMeaning;
    private String relator;
    private String title;
    private PartOfSpeech partOfSpeech;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
