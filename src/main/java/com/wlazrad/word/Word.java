package com.wlazrad.word;

import com.wlazrad.models.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;

//@Audited
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
    private String spelling;
    private String title;
    private PartOfSpeech partOfSpeech;
//    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    private Boolean teach;
}
