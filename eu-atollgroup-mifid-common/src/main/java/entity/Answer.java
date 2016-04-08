package entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by u95599 on 2016.03.08.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
@javax.persistence.Table(name = "ANSWERS")
public class Answer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    private Question question;

    public Answer(){
    }

    public Answer(Question question, String name) {
        this.question = question;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
