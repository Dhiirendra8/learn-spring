package com.hbn.learn.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Question {

    @Id
    @Column(name = "que_id")
    private int queId;
    private String question;

//    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
//    private List<Answer> answers;
}
